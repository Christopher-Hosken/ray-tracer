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
        double den = Vec3.dot(N, r.direction());
        if (Math.abs(den) < 0.001) return -1.0;

        double d = Vec3.dot(N, A);
        double t = (Vec3.dot(N, r.origin()) + d) / den;
        if (t < 0) return -1;

        Vec3 P = r.at(t);

        Vec3 BA = Vec3.sub(B, A);
        Vec3 CB = Vec3.sub(C, B);
        Vec3 AC = Vec3.sub(A, C);

        Vec3 C = Vec3.sub(P, A);
        if (Vec3.dot(N, Vec3.cross(BA, C)) < 0) return -1.0;

        C = Vec3.sub(P, B);
        if (Vec3.dot(N, Vec3.cross(CB, C)) < 0) return -1.0;

        C = Vec3.sub(P, C);
        if (Vec3.dot(N, Vec3.cross(AC, C)) < 0) return -1.0;


        return t;
    }
}