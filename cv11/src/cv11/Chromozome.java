package cv11;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;

public class Chromozome implements Comparable<Chromozome> {
    public static final int NUM_OF_POLYG = 30;
    public static final int NUM_OF_POINTS = 5;
    public static final int GENES_PER_POLY = NUM_OF_POINTS * 2 + 4; 
    
    private int[] data = new int[NUM_OF_POLYG * GENES_PER_POLY];
    private Random rand = new Random();
    public long fitness = Long.MAX_VALUE;

    public Chromozome() {
    }

    public void mutateAll() {
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(256);
        }
    }

    public void mutate(double probability) {
        for (int i = 0; i < data.length; i++) {
            if (Math.random() < probability) {
                data[i] = rand.nextInt(256);
            }
        }
    }

    public void crossOver(Chromozome other) {
        int crossPoint = rand.nextInt(data.length);
        for (int i = crossPoint; i < data.length; i++) {
            int temp = this.data[i];
            this.data[i] = other.data[i];
            other.data[i] = temp;
        }
    }

    public void draw(Graphics2D g, int width, int height) {
        for (int i = 0; i < NUM_OF_POLYG; i++) {
            int base = i * GENES_PER_POLY;
            int[] xPoints = new int[NUM_OF_POINTS];
            int[] yPoints = new int[NUM_OF_POINTS];
            
            for (int j = 0; j < NUM_OF_POINTS; j++) {
                xPoints[j] = (int) ((data[base + j * 2] / 255.0) * width);
                yPoints[j] = (int) ((data[base + j * 2 + 1] / 255.0) * height);
            }
            
            int r = data[base + 10];
            int green = data[base + 11];
            int b = data[base + 12];
            int a = data[base + 13];
            
            g.setColor(new Color(r, green, b, a));
            g.fillPolygon(new Polygon(xPoints, yPoints, NUM_OF_POINTS));
        }
    }

    public Chromozome cloneChromozome() {
        Chromozome clone = new Chromozome();
        System.arraycopy(this.data, 0, clone.data, 0, this.data.length);
        clone.fitness = this.fitness;
        return clone;
    }

    @Override
    public int compareTo(Chromozome o) {
        return Long.compare(this.fitness, o.fitness);
    }
}
