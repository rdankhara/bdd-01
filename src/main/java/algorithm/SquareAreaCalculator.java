package algorithm;

public class SquareAreaCalculator implements AreaCalculator {
    private float length = 0;
    public SquareAreaCalculator (float length) {
        this.length = length;
    }

    @Override
    public float calculate() {
        return this.length * this.length;
    }
}
