package data.shaders;

import data.base.*;

public class emission extends shader {
    public emission() {super();}

    public emission(vec3 color) {
        super(color);
    }

    public emission(vec3 color, double spec) {
        super(color, spec);
    }

    public ray scatter(object obj, ray ray) {
        vec3 p = ray.at(obj.t());
        return new ray(p, vec3.scatter(p, obj.normal()));
    }
}