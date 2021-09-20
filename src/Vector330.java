import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Vector330 {
    private double x;
    private double y;

    public Vector330() {
        double x = 0;
        double y = 0;
    }

    public Vector330(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector330 add(Vector330 other) {
        return new Vector330(this.x + other.x, this.y + other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector330 vector330 = (Vector330) o;
        return Double.compare(vector330.x, x) == 0 && Double.compare(vector330.y, y) == 0;
    }

    public Vector330 subtract(Vector330 other) {
        return new Vector330(this.x - other.x, this.y - other.y);
    }

    public double dotProduct(Vector330 other) {
        return ((this.x * other.x) + (this.y * other.y));
    }

    public Vector330 scale(double factor) {
        return new Vector330(this.x * factor, this.y * factor);
    }

    public double magnitude() {
        return (Math.sqrt((this.x * this.x) + (this.y * this.y)));
    }

    public double direction() {
        return Math.atan2(this.x, this.y);

    }

    public Vector330 normalize() {
        double magnitude = this.magnitude();
        if (magnitude <= .000000001) {
            return new Vector330(0, 0);
        } else {
            return new Vector330(this.x / this.magnitude(), this.y / this.magnitude());
        }
    }

    public String toString() {
        return String.format("<  %.2f, %.2f >", this.x, this.y);
    }

    public static Vector330 parseVector(Scanner s) throws Exception {

            double y = 0.0;
            double x = 0.0;

            Pattern originalPattern = s.delimiter();

            s.useDelimiter("[" + originalPattern + ",]");

            if (s.hasNext("<")) {
                s.next("<");

                if (s.hasNextDouble()) {
                    x = s.nextDouble();

                    s.useDelimiter(originalPattern);

                    if (s.hasNext(",")) {
                        s.next(",");

                        if (s.hasNextDouble()) {
                            y = s.nextDouble();

                            s.useDelimiter(originalPattern);

                            if (s.hasNext(">")) {
                                s.next(">");
                            }
                            else {
                                throw new Exception("Missing end sign, '>'");
                            }
                        }
                    }
                }
            }
            return new Vector330(x, y);
        }
    }

