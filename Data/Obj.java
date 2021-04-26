package Data;
import Materials.*;

public class Obj {
    protected String name;
    protected Vec3 center;
    protected double t;
    protected Vec3 N;
    protected boolean isFrontFacing;
    protected Mat mat;

    public Obj(String name) {
        center = new Vec3();
        this.name = name;
        mat = new Emit("null", new Vec3(0, 0, 0));
    }

    public Obj(String name, Vec3 center) {
        this.center = center;
        this.name = name;
        mat = new Emit("null", new Vec3(0, 0, 0));
    }

    public Obj(String name, Mat mat) {
        center = new Vec3();
        this.name = name;
        this.mat = mat;
    }

    public Obj(String name, Vec3 center, Mat mat) {
        this.center = center;
        this.name = name;
        this.mat = mat;
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

    public Mat mat() {
        return mat;
    }

    public double radius() {
        return 0.0;
    }

    public boolean isLight() {
        return false;
    }

    public boolean isfrontFacing() {
        return isFrontFacing;
    }

    //#endregion

    //#region (Transformation Methods)

    public void translate(Vec3 t) {
        center = Vec3.add(center, t);
    }

    public void scale(double s) {
        center = center;
    }

    //#endregion

    public void setNormal(Ray ray) {
        isFrontFacing = Vec3.dot(ray.direction(), N) < 0;
        if (!isFrontFacing) {
            N = N.invert();
        }
    }

    public double intersect(Ray ray) {
        return -1;
    }
}
