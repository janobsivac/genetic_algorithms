package cv11;

import java.io.IOException;

public class main {

    public static void main(String[] args) {
        try {
            String imagePath = "C:\\Users\\janob\\Downloads\\Garfield.jpg";
            
            Fitness fitnessFunc = new Fitness(imagePath);
            
            int popSize = 50;
            double mutationRate = 0.01;
            double crossRate = 0.5;
            int generations = 3000;

            Populace populace = new Populace(popSize);

            System.out.println("Start evoluce...");

            for (int i = 0; i < generations; i++) {
                populace.evaluate(fitnessFunc);

                if (i % 100 == 0) {
                    Chromozome best = populace.getBest();
                    System.out.println("Generace: " + i + " | Best Fitness (Error): " + best.fitness);
                }

                populace.evolve(mutationRate, crossRate);
            }

            System.out.println("Evoluce dokončena.");
            Chromozome best = populace.getBest();
            System.out.println("Nejlepší nalezená chyba: " + best.fitness);

            ShowChromozome.show(best, "Nejlepší řešení (Fitness: " + best.fitness + ")");

        } catch (IOException e) {
            System.err.println("Chyba: Nelze načíst obrázek předlohy.");
            System.err.println("Ujistěte se, že existuje daný soubor nebo upravte cestu v kódu.");
            e.printStackTrace();
        }
    }
}
