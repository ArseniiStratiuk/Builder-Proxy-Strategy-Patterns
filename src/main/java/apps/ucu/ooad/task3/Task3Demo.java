package apps.ucu.ooad.task3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public final class Task3Demo {
    private Task3Demo() {
    }

    public static void main(String[] args) throws IOException {
        Path imagePath = Path.of("target", "demo-image.png");
        ensureSampleImage(imagePath);

        MyImage image = new ProxyImage(imagePath.toString());
        image.display();
    }

    private static void ensureSampleImage(Path imagePath) throws IOException {
        if (Files.exists(imagePath)) {
            return;
        }
        Files.createDirectories(imagePath.getParent());
        BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0, 0, 200, 200);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Proxy Demo", 50, 100);
        g2d.dispose();
        ImageIO.write(bufferedImage, "png", imagePath.toFile());
    }
}
