package Prims;
import Data.*;
import Materials.*;
import java.util.ArrayList;

public class Primitives {
    public static Mesh Cube(String n, Mat mat) {
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
            },
            mat
        );
        return m;
    }
    
    public static Mesh IcoSphere(String n, Mat m) {
        double X = 0.525731112119133606;
        double Z = 0.850650808352039932;
        double N = 0;

        ArrayList<Face> faces = new ArrayList<Face>();
        double[][] verts = new double[][] {
            {-X,N,Z}, {X,N,Z}, {-X,N,-Z}, {X,N,-Z},
            {N,Z,X}, {N,Z,-X}, {N,-Z,X}, {N,-Z,-X},
            {Z,X,N}, {-Z,X, N}, {Z,-X,N}, {-Z,-X, N}
        };

        int[][] faceIds = new int[][] {
            {0,4,1},{0,9,4},{9,5,4},{4,5,8},{4,8,1},
            {8,10,1},{8,3,10},{5,3,8},{5,2,3},{2,7,3},
            {7,10,3},{7,6,10},{7,11,6},{11,0,6},{0,1,6},
            {6,1,10},{9,0,11},{9,11,2},{9,2,5},{7,2,11}
        };

        for (int idx = 0; idx < faceIds.length; idx++) {
            int[] fs = faceIds[idx];
            Vec3 va = new Vec3(
                verts[fs[0]][0],
                verts[fs[0]][1],
                verts[fs[0]][2]
            );
            Vec3 vb = new Vec3(
                verts[fs[1]][0],
                verts[fs[1]][1],
                verts[fs[1]][2]
            );
            Vec3 vc = new Vec3(
                verts[fs[2]][0],
                verts[fs[2]][1],
                verts[fs[2]][2]
            );

            faces.add(
                new Face(("f" + idx), 
                    va,
                    vb,
                    vc
                )
            );
        }

        Face[] facesList = new Face[faces.size()];

        for (int i = 0; i < facesList.length; i++) {
            facesList[i] = faces.get(i);
        }

        return new Mesh(n, facesList, m);
    }
}
