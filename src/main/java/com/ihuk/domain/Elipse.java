package com.ihuk.domain;

/**
 * <p>
 *     Elipse class.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
public class Elipse extends Shape{

    /**
     * Horisontal radius
     */
    private double hRadius;

    /**
     * Vertical radius
     */
    private double vRadius;

    public Elipse(double hRadius, double vRadius) {
        this.hRadius = hRadius;
        this.vRadius = vRadius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * hRadius * vRadius;
    }
}
