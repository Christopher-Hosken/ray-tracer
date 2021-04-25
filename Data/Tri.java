package Data;

public class Tri {
    private Vec3 A,B,C;
    private Vec3 N;

    public Tri() {

    }

    public Tri(Vec3 i, Vec3 j, Vec3 k) {
        A=i; B=j; C=k;
        Vec3 BA = Vec3.sub(B, A);
        Vec3 CA = Vec3.sub(C, A);
        N = Vec3.cross(BA, CA).unitVector();
    }

    public Vec3 N() {
        return N;
    }

    public double intersect(Ray r) {
        return -1.0;
    }
}