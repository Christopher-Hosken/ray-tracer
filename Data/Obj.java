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

    public double intersect(Ray ray) {
        return -1;
    }
}
