package com.ihuk.repository;

import com.ihuk.entity.CalculationStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>
 *     Statistic repository.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
public interface StatisticRepository extends JpaRepository<CalculationStatistics, Long> {

    @Query("FROM CalculationStatistics where shape = ?1 ")
    CalculationStatistics findShapeStatistic(String shapeName);
}
