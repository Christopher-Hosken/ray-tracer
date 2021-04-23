import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Color;


public class Camera extends Obj {
    private Vec3 direction;
    private int width;
    private int height;

    public Camera(int w, int h) {
        super();
        width = w;
        height = h;
        direction = new Vec3(0, 0, 1);
    }

    public Camera(int w, int h, Vec3 c, Vec3 d) {
        super(c);
        direction = d;
        width = w;
        height = h;
    }

    public Ray castRay(double u, double v) {
        Vec3 corner = new Vec3(center.x - 1, center.y - 1, center.z);
        Vec3 target = new Vec3(corner.x + u*2, corner.y + v*2, 1);
        return new Ray(center, target);
    }

    public void render() throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double u = (double) x / width;
                double v = (double) y / height;
                Vec3 col = new Vec3(0, 0, 0);
                Ray ray = castRay(u, v);

                if (new Sphere(new Vec3(0, 0, 5), 2).intersect(ray) > 0) {
                    col = new Vec3(1, 0, 0);
                }

                int rgb = convertRGB(col);
                image.setRGB(x, (height - 1) - y, rgb);
            }
            System.out.println(y + 1 + "/" + height + " Lines Rendered.");
        }

        File outFile = new File("render.png");
        ImageIO.write(image, "png", outFile);
    }

    public int convertRGB(Vec3 c) {
        c.clamp(0.0, 1.0);

        int r = (int) (c.x * 255);
        int g = (int) (c.y * 255);
        int b = (int) (c.z * 255);

        return new Color(r, g, b).getRGB();
    }
}
