package cv11;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Fitness {
    private BufferedImage template;
    private BufferedImage canvas;
    private Graphics2D g2d;

    public Fitness(String path) throws IOException {
        template = ImageIO.read(new File(path));
        canvas = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
    }

    public long getFitness(Chromozome ch) {
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, template.getWidth(), template.getHeight());
        
        ch.draw(g2d, template.getWidth(), template.getHeight());
        
        long error = 0;
        int width = template.getWidth();
        int height = template.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int c1 = canvas.getRGB(x, y);
                int c2 = template.getRGB(x, y);

                Color color1 = new Color(c1);
                Color color2 = new Color(c2);

                error += Math.abs(color1.getRed() - color2.getRed());
                error += Math.abs(color1.getGreen() - color2.getGreen());
                error += Math.abs(color1.getBlue() - color2.getBlue());
            }
        }
        ch.fitness = error;
        return error;
    }
}
