import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Vector330Test {

    @org.junit.jupiter.api.Test
    void add() {
        Vector330 v1 = new Vector330(1, 2);
        Vector330 v2 = new Vector330(1, 2);
        Vector330 answer = new Vector330(2, 4);
        assert(v1.add(v2) == answer);

    }
    @org.junit.jupiter.api.Test
    void testEquals() {
        Vector330 v1 = new Vector330(1, 2);
        Vector330 v2 = new Vector330(1, 2);
        assert(v1.equals(v2));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Vector330 v1 = new Vector330(3, 4);
        Vector330 v2 = new Vector330(1, 2);
        Vector330 answer = new Vector330(2, 2);
        Vector330 answer1 = v1.subtract(v2);
        assert(Objects.equals(answer1, answer));

    }

    @org.junit.jupiter.api.Test
    void dotProduct() {
        Vector330 v1 = new Vector330(3, 4);
        Vector330 v2 = new Vector330(1, 2);
        int answer = 11;
        assert(v1.dotProduct(v2) == answer);
    }

    @org.junit.jupiter.api.Test
    void scale() {
        Vector330 v1 = new Vector330(3, 4);
        int factor = 4;
        Vector330 answer = new Vector330(12, 16);
        Vector330 answer1 = v1.scale(factor);
        assert(Objects.equals(answer1, answer));
    }

    @org.junit.jupiter.api.Test
    void magnitude() {
        Vector330 v1 = new Vector330(3, 4);
        double answer = 5;
        assert(v1.magnitude() == answer);
    }

    @org.junit.jupiter.api.Test
    void direction() {
        Vector330 v1 = new Vector330(3.0, 4.0);
        double answer = v1.direction();
        assert(answer == v1.direction());
    }

    @org.junit.jupiter.api.Test
    void normalize() {
        Vector330 v1 = new Vector330(3, 4);
        double magnitude = v1.magnitude();
        Vector330 answer1 = v1.normalize();
        Vector330 answer = new Vector330(3.0/5.0, 4.0/5.0);
        assert(Objects.equals(answer1, answer));

        Vector330 v2 = new Vector330(3, 5);
        double mag = .000000000001;
        Vector330 answer2 = v1.normalize();
        Vector330 answer3 = new Vector330(0, 0);
        assert(Objects.equals(answer2, answer3));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Vector330 answer = new Vector330(5.0, 7.0);
        String answer1 = answer.toString();
        String answer2 = ("< 5.0, 7.0 >");
        assert(Objects.equals(answer1, answer2));
    }

    @org.junit.jupiter.api.Test
    void parseVector() {

    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
    }

    @org.junit.jupiter.api.Test
    void testEquals1() {
    }

    @org.junit.jupiter.api.Test
    void testSubtract() {
    }

    @org.junit.jupiter.api.Test
    void testDotProduct() {
    }

    @org.junit.jupiter.api.Test
    void testScale() {
    }

    @org.junit.jupiter.api.Test
    void testMagnitude() {
    }

    @org.junit.jupiter.api.Test
    void testDirection() {
    }

    @org.junit.jupiter.api.Test
    void testNormalize() {
    }

    @org.junit.jupiter.api.Test
    void testToString1() {
    }

    @org.junit.jupiter.api.Test
    void testParseVector() {
    }
}