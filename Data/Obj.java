package Data;

public class Obj {
    protected String name;
    protected Vec3 center;
    protected Vec3 N;
    protected double t;
    protected boolean frontFacing;

    public Obj(String name) {
        center = new Vec3();
        this.name = name;
    }

    public Obj(String name, Vec3 center) {
        this.center = center;
        this.name = name;
    }

    //#region (Getter Methods)

    public String name() {
        return name;
    }

    public Vec3 center() {
        return center;
    }

    public double t() {
        return t;
    }

    public Vec3 N() {
        return N;
    }

    public double radius() {
        return 0;
    }

    public boolean frontFacing() {
        return frontFacing;
    }

    //#endregion

    //#region (Transformation Methods)

    public void translate(Vec3 t) {
        center = Vec3.add(center, t);
    }

    public void scale(double s) {
        this.center = Vec3.mult(center, s);
    }

    public void rotate(Vec3 r) {
        rotateX(new Vec3(), r.x);
        rotateY(new Vec3(), r.y);
        rotateZ(new Vec3(), r.z);
    }

    public void rotate(Vec3 c, Vec3 r) {
        rotateX(c, r.x);
        rotateY(c, r.y);
        rotateZ(c, r.z);
    }

    //#region rotations

    public void rotateX(Vec3 c, double r) {
        
        double sin_t = Math.sin(Math.toRadians(r));
        double cos_t = Math.cos(Math.toRadians(r));
        double y = center.y - c.y;
        double z = center.z - c.z;

        center.y = (y * cos_t - z * sin_t) + c.y;
        center.z = (z * cos_t + y * sin_t) + c.z;
    }

    public void rotateY(Vec3 c, double r) {
        double sin_t = Math.sin(Math.toRadians(r));
        double cos_t = Math.cos(Math.toRadians(r));
        double x = center.x - c.x;
        double z = center.z - c.z;

        center.x = (x * cos_t - z * sin_t) + c.x;
        center.z = (z * cos_t + x * sin_t) + c.z;
    }

    public void rotateZ(Vec3 c, double r) {
        double sin_t = Math.sin(Math.toRadians(r));
        double cos_t = Math.cos(Math.toRadians(r));
        double x = center.x - c.x;
        double y = center.y - c.y;

        center.x = (x * cos_t - y * sin_t) + c.x;
        center.y = (y * cos_t + x * sin_t) + c.y;
    }

    ////#endregion

    //#endregion

    public double intersect(Ray ray) {
        return -1;
    }
}
