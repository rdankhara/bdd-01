package com.examples.api;

import algorithm.AreaCalculator;
import algorithm.CircleAreaCalculator;
import algorithm.SquareAreaCalculator;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AreaCalculatorTest {

    public int getSum(List<Integer> list) {
        int sum = 0;
        for (int s: list ) {
            sum += s;
        }
        return sum;
    }

    @Test
    public void verifyInterfacePower() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        LinkedList linked = new LinkedList();
        linked.add(20);
        linked.add(20);

        List<Integer> stack = new Stack<Integer>();
        stack.add(30);
        stack.add(20);
        System.out.println("Total  = " + getSum(list));
        System.out.println("Total  = " + getSum(linked));
        System.out.println("Total  = " + getSum(stack));

    }

    public float getArea(AreaCalculator areaCalculator) {

        return areaCalculator.calculate();
    }

    @Test
    public void verifyAreaOfSquare() {
        SquareAreaCalculator squareAreaCalculator = new SquareAreaCalculator(10.0f);
        float area = getArea(squareAreaCalculator);

        CircleAreaCalculator circleAreaCalculator = new CircleAreaCalculator(10.0f);
        area = getArea(circleAreaCalculator);

    }

    @Test
    public void verifyAreaOfCircle() {
        AreaCalculator areaCalculator = new CircleAreaCalculator(10.0f);
        float area = areaCalculator.calculate();
        System.out.println("area=" + area);
    }
}
