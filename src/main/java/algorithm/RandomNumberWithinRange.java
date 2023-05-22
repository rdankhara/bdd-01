package algorithm;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberWithinRange {
    private int start;
    private int end;
    private Set<Integer> generated;
    private int multiplier;

    public RandomNumberWithinRange(int start, int end) {
        this.start = start;
        this.end = end;
        generated = new HashSet<>();
        this.calculateMultiplier(end);
    }

    private void calculateMultiplier(int number) {
        this.multiplier = 1;
        int num = number;
        while (num > 1) {
            this.multiplier *= 10;
            num /=10;
        }
    }

    public int getNext() {
        while (true) {
            int rand = (int) Math.floor(Math.random() * this.multiplier);
            // case if random number is out of range, e.g. < 25 or > 50 and we want in between 25 - 50
            if (rand < this.start || rand > this.end) {
                int diff = this.end - this.start;
                rand = rand % diff;
                // if number is < this.start then add start
                if (rand < this.start) {
                    rand += this.start;
                }
            }
            if (!generated.contains(rand)) {
                return rand;
            }
        }
    }

}
