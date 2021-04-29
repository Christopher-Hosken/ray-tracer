package Data;

public class Tri {
    private Vec3 A,B,C;
    private Vec3 N;

    public Tri() {}

    public Tri(Vec3 i, Vec3 j, Vec3 k) {
        A=i; B=j; C=k;
        Vec3 BA = Vec3.sub(B, A);
        Vec3 CA = Vec3.sub(C, A);
        N = Vec3.cross(BA, CA).unitVector();
    }

    public void translate(Vec3 t) {
        A = Vec3.add(A, t);
        B = Vec3.add(B, t);
        C = Vec3.add(C, t);
    }

    public Vec3 N() {
        return N;
    }

    public double intersect(Ray ray) {
        return -1.0;
    }
}