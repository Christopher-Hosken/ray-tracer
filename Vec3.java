public class Vec3 {
    public double x,y,z;

    public Vec3() {
        x=y=z=0;
    }

    public Vec3(double i, double j, double k) {
        x=i; y=j; z=k;
    }

    public double lengthSquared() {
        return x*x + y*y + z*z;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public Vec3 unitVector() {
        return div(this, length());
    }

    public void clamp(double min, double max) {
        if (x < min) x = min; if (x > max) x = max;
        if (y < min) y = min; if (y > max) y = max;
        if (z < min) z = min; if (z > max) z = max;
    }

    public static Vec3 add(Vec3 v, Vec3 u) {
        return new Vec3(
            v.x + u.x,
            v.y + u.y,
            v.z + u.z
        );
    }

    public static Vec3 sub(Vec3 v, Vec3 u) {
        return new Vec3(
            v.x - u.x,
            v.y - u.y,
            v.z - u.z
        );
    }

    public static Vec3 mult(Vec3 v, Vec3 u) {
        return new Vec3(
            v.x * u.x,
            v.y * u.y,
            v.z * u.z
        );
    }

    public static Vec3 mult(Vec3 v, double d) {
        return new Vec3(
            v.x * d,
            v.y * d,
            v.z * d
        );
    }

    public static Vec3 mult(double d, Vec3 v) {
        return mult(v, d);
    }

    public static Vec3 div(Vec3 v, double d) {
        return new Vec3(
            v.x / d,
            v.y / d,
            v.z / d
        );
    }

    public static double dot(Vec3 v, Vec3 u) {
        return v.x * u.x + v.y * u.y + v.z * u.z;
    }

    public static Vec3 cross(Vec3 v, Vec3 u) {
        return new Vec3(
            v.y * u.z - v.z * u.y,
            v.z * u.x - v.x * u.z,
            v.x * u.y - v.y * u.x
        );
    }
}
