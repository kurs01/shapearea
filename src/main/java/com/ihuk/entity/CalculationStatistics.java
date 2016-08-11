package com.ihuk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 *     Statistic entity.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
@Entity
@Table(name="CALCULATION_STATISTICS")
public class CalculationStatistics implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    /**
     * <p>
     *     Shape name.
     * </p>
     */
    private String shape;

    /**
     * <p>
     *     Count of performed calculations.
     * </p>
     */
    private long countcall;

    public CalculationStatistics() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public long getCountcall() {
        return countcall;
    }

    public void setCountcall(long countcall) {
        this.countcall = countcall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalculationStatistics that = (CalculationStatistics) o;

        if (id != that.id) return false;
        return shape != null ? shape.equals(that.shape) : that.shape == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        return result;
    }
}
