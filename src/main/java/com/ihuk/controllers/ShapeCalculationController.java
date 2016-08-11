package com.ihuk.controllers;

import com.ihuk.domain.*;
import com.ihuk.entity.CalculationStatistics;
import com.ihuk.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *     Main controller.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 * @since 0.0.1
 */
@Controller
public class ShapeCalculationController {

    /**
     * <p>
     *     DB service.
     * </p>
     */
    @Autowired
    StatisticRepository statisticRepository;

    /**
     * <p>
     *     POST Request mapping to calculateCircleShape url.
     * </p>
     * @param radius - Radius of circle.
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateCircleShape", method= RequestMethod.POST)
    public String calculateCircleShape(@RequestParam(value="radius", required=true, defaultValue="0") int radius, Model model) {
        fillModelPostAction(new Circle(radius), model);

        return "calculateCircleShape";
    }

    /**
     * <p>
     *     GET Request mapping to calculateCircleShape url.
     * </p>
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateCircleShape", method= RequestMethod.GET)
    public String calculateCircleShapeForm(Model model) {
        model.addAttribute("visibleResult", false);
        return "calculateCircleShape";
    }

    /**
     * <p>
     *     POST Request mapping to calculateElipseShape url.
     * </p>
     * @param vradius - Vertical Radius of elipse.
     * @param hradius - Horisontal Radius of elipse.
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateElipseShape", method= RequestMethod.POST)
    public String calculateElipseShape(@RequestParam(value="hradius", required=true, defaultValue="0") int hradius,
                                       @RequestParam(value="vradius", required=true, defaultValue="0") int vradius, Model model) {
        fillModelPostAction(new Elipse(hradius, vradius), model);

        return "calculateElipseShape";
    }

    /**
     * <p>
     *     GET Request mapping to calculateElipseShape url.
     * </p>
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateElipseShape", method= RequestMethod.GET)
    public String calculateElipseShapeForm(Model model) {
        model.addAttribute("visibleResult", false);
        return "calculateElipseShape";
    }

    /**
     * <p>
     *     POST Request mapping to calculateRectangleShape url.
     * </p>
     * @param vside - Vertical Side of rectangle.
     * @param hside - Horisontal Side of rectangle.
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateRectangleShape", method= RequestMethod.POST)
    public String calculateRectangleShape(@RequestParam(value="hside", required=true, defaultValue="0") int hside,
                                          @RequestParam(value="vside", required=true, defaultValue="0") int vside,Model model) {
        fillModelPostAction(new Rectangle(hside, vside), model);

        return "calculateRectangleShape";
    }

    /**
     * <p>
     *     GET Request mapping to calculateRectangleShape url.
     * </p>
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateRectangleShape", method= RequestMethod.GET)
    public String calculateRectangleShapeForm(Model model) {
        model.addAttribute("visibleResult", false);
        return "calculateRectangleShape";
    }

    /**
     * <p>
     *     POST Request mapping to calculateSquareShape url.
     * </p>
     * @param side - Side of square.
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateSquareShape", method= RequestMethod.POST)
    public String calculateSquareShape(@RequestParam(value="side", required=true, defaultValue="0") int side, Model model) {
        fillModelPostAction(new Square(side), model);
        return "calculateSquareShape";
    }

    /**
     * <p>
     *     POST Request mapping to calculateSquareShape url.
     * </p>
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="/calculateSquareShape", method= RequestMethod.GET)
    public String calculateSquareShapeForm(Model model) {
        model.addAttribute("visibleResult", false);
        return "calculateSquareShape";
    }

    /**
     * <p>
     *     Request mapping to index url.
     * </p>
     * @param model - Model object of view.
     * @return - name of view.
     */
    @RequestMapping(value="index")
    public String index(Model model) {
        model.addAttribute("circleCount", obtainStatistic(Circle.class.getSimpleName()));
        model.addAttribute("elipseCount", obtainStatistic(Elipse.class.getSimpleName()));
        model.addAttribute("rectangleCount", obtainStatistic(Rectangle.class.getSimpleName()));
        model.addAttribute("squareCount", obtainStatistic(Square.class.getSimpleName()));
        return "index";
    }

    /**
     * <p>
     *     Update statistic.
     *     <li>
     *         Get CalculationStatistics object from DataBase.
     *     </li>
     *     <li>
     *         Increase countcall of CalculationStatistics object.
     *     </li>
     *     <li>
     *         Update CalculationStatistics object in DataBase.
     *     </li>
     * </p>
     * @param shapeName
     */
    private void updateStatistic(String shapeName){
        CalculationStatistics statistic = statisticRepository.findShapeStatistic(shapeName);
        long count = statistic != null ? statistic.getCountcall() : 0;
        if(statistic == null){
            statistic = new CalculationStatistics();
            statistic.setShape(shapeName);
        }
        statistic.setCountcall(++count);
        statisticRepository.saveAndFlush(statistic);
    }

    /**
     * <p>
     *     Obtain count of calculation`s calls.
     * </p>
     * @param shapeName - String representation of Shape class.
     * @return - count of calls.
     */
    private long obtainStatistic(String shapeName){
        CalculationStatistics statistic = statisticRepository.findShapeStatistic(shapeName);

        return statistic != null ? statistic.getCountcall() : 0L;
    }

    /**
     * <p>
     *     Base filling of model for post request.
     * </p>
     *
     * @param shape - Shape object.
     * @param model - Model object of view.
     */
    private void fillModelPostAction(Shape shape, Model model) {
        model.addAttribute("visibleResult", true);
        model.addAttribute("result", shape.processCalculation());
        model.addAttribute("count", shape.getCount());
        updateStatistic(shape.getClass().getSimpleName());
    }
}
