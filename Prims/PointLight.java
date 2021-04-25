package Prims;

import Shaders.Emit;
import Data.*;

public class PointLight extends Sphere {
    public PointLight(String n, double s) {
        super(n, new Emit(n, new Vec3(1, 1, 1), s));
    }

    public PointLight(String n, Vec3 cen, double rad, double s) {
        super(n, cen, rad, new Emit(n, new Vec3(1, 1, 1), s));
    }

    public PointLight(String n, Vec3 cen, double rad, Vec3 col, double s) {
        super(n, cen, rad, new Emit(n, col, s));
    }

    public boolean isLight() {
        return true;
    }
}