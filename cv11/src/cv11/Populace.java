package cv11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Populace {
    private List<Chromozome> jedinci;
    private Random rand = new Random();

    public Populace(int velikost) {
        jedinci = new ArrayList<>();
        for (int i = 0; i < velikost; i++) {
            Chromozome ch = new Chromozome();
            ch.mutateAll();
            jedinci.add(ch);
        }
    }

    public void evaluate(Fitness fit) {
        for (Chromozome ch : jedinci) {
            fit.getFitness(ch);
        }
        Collections.sort(jedinci); 
    }

    public Chromozome tournamentSelection(int tournamentSize) {
        Chromozome best = null;
        for (int i = 0; i < tournamentSize; i++) {
            int randomIndex = rand.nextInt(jedinci.size());
            Chromozome candidate = jedinci.get(randomIndex);
            if (best == null || candidate.fitness < best.fitness) {
                best = candidate;
            }
        }
        return best.cloneChromozome();
    }

    public void evolve(double mutationRate, double crossRate) {
        List<Chromozome> novaPopulace = new ArrayList<>();
        
        novaPopulace.add(jedinci.get(0).cloneChromozome());

        while (novaPopulace.size() < jedinci.size()) {
            Chromozome p1 = tournamentSelection(5);
            Chromozome p2 = tournamentSelection(5);

            if (rand.nextDouble() < crossRate) {
                p1.crossOver(p2);
            }

            p1.mutate(mutationRate);
            
            novaPopulace.add(p1);
        }
        
        this.jedinci = novaPopulace;
    }

    public Chromozome getBest() {
        return jedinci.get(0);
    }
}
