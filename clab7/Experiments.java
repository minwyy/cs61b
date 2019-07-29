import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hug.
 */
public class Experiments {
    public static void experiment1() {
        BST bst = new BST();
        List<Double> yValues = new ArrayList<>();
        List<Integer> xValues = new ArrayList<>();
        for (int x = 0; x < 5000; x += 1) {
            bst.add(RandomGenerator.getRandomInt(5000));
            double thisY = bst.averageDepth();
            xValues.add(x);
            yValues.add(thisY);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("x label").yAxisTitle("y label").build();
        chart.addSeries("Average Depth", xValues, yValues);

        new SwingWrapper(chart).displayChart();
    }

    public static void experiment2() {
        BST bst = new BST();
        Random r = new Random();
        List<Double> yValues = new ArrayList<>();
        List<Integer> xValues = new ArrayList<>();
        for (int x = 0; x < 5000; x += 1) {
            bst.add(r.nextInt());
        }
        for (int x = 0; x < 10000; x += 1) {
            bst.deleteTakingSuccessor(bst.getRandomKey());
            bst.add(r.nextInt(20000));
            double thisY = bst.averageDepth();
            xValues.add(x);
            yValues.add(thisY);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("x label").yAxisTitle("y label").build();
        chart.addSeries("Average Depth", xValues, yValues);

        new SwingWrapper(chart).displayChart();
    }

    public static void experiment3() {
        BST bst = new BST();
        Random r = new Random();
        List<Double> yValues = new ArrayList<>();
        List<Integer> xValues = new ArrayList<>();
        for (int x = 0; x < 5000; x += 1) {
            bst.add(r.nextInt());
        }
        for (int x = 0; x < 10000; x += 1) {
            bst.deleteTakingRandom(bst.getRandomKey());
            bst.add(r.nextInt(20000));
            double thisY = bst.averageDepth();
            xValues.add(x);
            yValues.add(thisY);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("x label").yAxisTitle("y label").build();
        chart.addSeries("Average Depth", xValues, yValues);

        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
        experiment1();
        experiment2();
        experiment3();
    }
}
