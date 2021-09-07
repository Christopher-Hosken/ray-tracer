package data.ops;

import data.base.*;

public class transforms {
    public static void translate(object obj, vec3 v) {
        obj.translate(v);
    }

    public static void rotate(object obj, vec3 v) {
        obj.rotate(v);
    }

    public static void scale(object obj, vec3 v) {
        obj.scale(v);
    }
}
