import java.util.ArrayList;

public class World {
    private ArrayList<Obj> scene;

    public World() {
        scene = new ArrayList<Obj>();
    }

    public void add(Obj ob) {
        scene.add(ob);
    }

    public Obj get(int idx) {
        return scene.get(idx);
    }

    public Obj get(String n) {
        if (scene != null && scene.size() > 0)
            for (Obj ob : scene) {
                if (ob.name().equals(n)) return ob;
            }
        return null;
    }

    public Obj hit(Ray r) {
        Obj c = new Obj("tmp");
        boolean hit = false;
        double t = Double.POSITIVE_INFINITY;

        if (scene != null && scene.size() > 0)
        for (Obj ob : scene) {
            double t0 = ob.intersect(r);
            if (t0 > 0.0001 && t0 < t) {
                c = ob;
                t = t0;
                hit = true;
            }
        }

        if (hit) {
            return c;
        }

        return null;
        

    }

}
