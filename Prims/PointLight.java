package Prims;

import Data.*;
import Materials.Emit;

public class PointLight extends Sphere {
    public PointLight(String name, double emission) {
        super(name, new Emit(name, new Vec3(1, 1, 1), emission));
    }

    public PointLight(String name, double radius, double emission) {
        super(name, radius, new Emit(name, new Vec3(1, 1, 1), emission));
    }

    public PointLight(String name, Vec3 center, double radius, double emission) {
        super(name, center, radius, new Emit(name, new Vec3(1, 1, 1), emission));
    }

    public PointLight(String name, Vec3 center, double radius, Vec3 color, double emission) {
        super(name, center, radius, new Emit(name, color, emission));
    }

    public boolean isLight() {
        return true;
    }
}