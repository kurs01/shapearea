package com.ihuk.domain;

/**
 * <p>
 *     Parent abstract class for shapes.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
abstract public class Shape {

    /**
     * <p>
     *     Counter of calculations.
     * </p>
     */
    static private long count;

    /**
     * <p>
     *     Process of area calculation consist:
     *     <li>increase of counter</li>
     *     <li>shape area calculation</li>
     * </p>
     * @return shape area.
     */
    public double processCalculation() {
        count++;
        return calculateArea();
    }

    /**
     * <p>
     *     Calculation of shape area.
     * </p>
     * @return shape area.
     */
    protected abstract double calculateArea();

    /**
     * <p>
     *     Getter for count field.
     * </p>
     * @return value of counter.
     */
    public long getCount() {
        return count;
    }
}
