package com.ihuk.domain;

/**
 * <p>
 *     Square class.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
public class Circle extends Shape{

    /**
     * Circle radius.
     */
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * radius * radius;
    }
}
