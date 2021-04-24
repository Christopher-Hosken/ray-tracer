package Shaders;
import Data.*;

public class Shader {
    protected String name;
    protected Vec3 color;

    public Shader(String n) {
        name = n;
    }

    public Ray scatter(Ray r) {
        return r;
    }
}