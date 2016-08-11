package com.ihuk.domain;

/**
 * <p>
 *     Square class.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
public class Square extends Shape{

    /**
     *  Square side length.
     */
    private int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    protected double calculateArea() {
        return sideLength * sideLength;
    }
}
