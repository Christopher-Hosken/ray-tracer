public class Tri {
    private Vec3 A,B,C;

    public Tri(Vec3 i, Vec3 j, Vec3 k) {
        A = i;
        B = j;
        C = k;
    }

    public Vec3 A() {
        return A;
    }

    public Vec3 B() {
        return B;
    }

    public Vec3 C() {
        return C;
    }
}
