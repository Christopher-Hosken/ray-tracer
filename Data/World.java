package Data;
import java.util.ArrayList;
public class World {
    private ArrayList<Obj> scene;

    public World() {
        scene = new ArrayList<Obj>();
    }

    public void add(Obj obj) {
        scene.add(obj);
    }

    public Obj get(int idx) {
        return scene.get(idx);
    }

    public Obj get(String nameID) {
        if (scene != null && scene.size() > 0)
            for (Obj obj : scene) {
                if (obj.name().equals(nameID)) return obj;
            }
        return null;
    }

    public ArrayList<Obj> scene() {
        return scene;
    }

    public Obj hit(Ray ray) {
        Obj hitObj = null;
        boolean hit = false;
        double t = Double.POSITIVE_INFINITY;

        if (scene != null && scene.size() > 0)
        for (Obj obj : scene) {
            double t0 = obj.intersect(ray);
            if (t0 > 0.0001 && t0 < t) {
                hitObj = obj;
                t = t0;
                hit = true;
            }
        }

        if (hit) {
            return hitObj;
        }

        return null;
    }
}
