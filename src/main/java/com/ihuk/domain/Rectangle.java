package com.ihuk.domain;

/**
 * <p>
 *     Rectangle class.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
public class Rectangle extends Shape{

    /**
     * Horisontal side.
     */
    private double hSide;

    /**
     * Vertical side.
     */
    private double vSide;

    public Rectangle(double hSide, double vSide) {
        this.hSide = hSide;
        this.vSide = vSide;
    }

    @Override
    protected double calculateArea() {
        return hSide * vSide;
    }
}
