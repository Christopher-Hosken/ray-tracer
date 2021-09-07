package data.shaders;
import data.base.*;

public class diffuse extends shader {
    public diffuse() {super();}

    public diffuse(vec3 color) {
        super(color);
    }

    public diffuse(vec3 color, double spec) {
        super(color, spec);
    }

    public ray scatter(object obj, ray ray) {
        vec3 p = ray.at(obj.t());
        return new ray(p, vec3.scatter(p, obj.normal()));
    }
}