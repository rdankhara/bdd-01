package algorithm;

public class CircleAreaCalculator implements AreaCalculator {
    private float radius = 0;
    private static float PI = 3.14f;

    public CircleAreaCalculator(float radius) {
        this.radius = radius;
    }

    @Override
    public float calculate() {
        return CircleAreaCalculator.PI * this.radius * radius;
    }
}
