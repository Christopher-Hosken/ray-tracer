package Data;
import Materials.*;

public class Obj {
    protected String name;
    protected Vec3 center;
    protected Vec3 N;
    protected double t;
    protected boolean frontFacing;
    protected boolean invN = false;
    protected Mat mat;

    public Obj(String name) {
        center = new Vec3();
        this.name = name;
    }

    public Obj(String name, Vec3 center) {
        this.center = center;
        this.name = name;
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

    public void InvertNormal() {
        invN = !invN;
    }

    public double radius() {
        return 0;
    }

    public Mat mat() {
        return mat;
    }

    public boolean frontFacing() {
        return frontFacing;
    }

    //#endregion

    public double intersect(Ray ray) {
        return -1;
    }
}
