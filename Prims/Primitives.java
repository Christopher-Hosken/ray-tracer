package Prims;
import Data.*;

public class Primitives {
    public static Mesh Cube(String n) {
        Vec3 v0 = new Vec3(-1, -1, 1);
        Vec3 v1 = new Vec3(1, -1, 1);
        Vec3 v2 = new Vec3(1, -1, -1);
        Vec3 v3 = new Vec3(-1, -1, -1);

        Vec3 v4 = new Vec3(-1, 1, 1);
        Vec3 v5 = new Vec3(1, 1, 1);
        Vec3 v6 = new Vec3(1, 1, -1);
        Vec3 v7 = new Vec3(-1, 1, -1);

        Mesh m = new Mesh(n, 
            new Face[] {
                new Face("bottom",
                v0, v1, v2, v3
                ),
                new Face("top",
                v4, v5, v6, v7
                ),
                new Face("back",
                v4, v5, v1, v0
                ),
                new Face("left",
                v4, v7, v3, v0
                ),
                new Face("right",
                v5, v6, v2, v1
                ),
                new Face("front",
                v7, v6, v2, v3
                )

            }
        );
        return m;
    }   
}
