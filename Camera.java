import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Color;


public class Camera extends Obj {
    private Vec3 direction;
    private int width;
    private int height;
    private int aspectRatio = 1;

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

    public Ray getRay(double u, double v) {
        Vec3 corner = new Vec3(center.x - 1*aspectRatio, center.y - 1, center.z);
        Vec3 target = new Vec3(corner.x + u*2*aspectRatio, corner.y + v*2, 1);
        return new Ray(center, target);
    }

    public void render(int samples) throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Vec3 col = new Vec3(0, 0, 0);
                for (int s = 0; s < samples; s++) {
                    double u = ((double) x + Math.random()) / width;
                    double v = ((double) y + Math.random()) / height;
                    Ray ray = getRay(u, v);

                    col = Vec3.add(col, solveRay(ray));
                }
                int rgb = convertRGB(col, samples);
                image.setRGB(x, (height - 1) - y, rgb);
            }
            System.out.println(y + 1 + "/" + height + " Lines Rendered.");
        }

        File outFile = new File("render.png");
        ImageIO.write(image, "png", outFile);
    }

    public int convertRGB(Vec3 c, int s) {
        c = Vec3.div(c, s);
        c.clamp(0.0, 1.0);

        int r = (int) (c.x * 255);
        int g = (int) (c.y * 255);
        int b = (int) (c.z * 255);

        return new Color(r, g, b).getRGB();
    }

    public Vec3 solveRay(Ray ray) {
        double t = new Sphere(new Vec3(0, 0, 1), 0.5).intersect(ray);
        if (t > 0.001) {
            Vec3 normal = Vec3.sub(ray.at(t), center).unitVector();

            return Vec3.mult(Vec3.add(normal, new Vec3(1, 1, 1)), 0.5);
        }

        else {
            t = ray.direction().unitVector().y + 0.5;
            return Vec3.add(
                Vec3.mult(new Vec3(1, 1, 1), (1 - t)), 
                Vec3.mult(new Vec3(0.3, 0.5, 1), t)
            );
        }
    }
}
