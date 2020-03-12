package cn.wendaocp.visualization;

import javafx.scene.chart.ScatterChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author lq
 * @since 2020-03-12 16:57
 */
public class Scatter01 {

    public static void main(String[] args) {

        JFreeChart chart = createChart(createDataset());

        // show
        ChartFrame frame = new ChartFrame("", chart);
        frame.pack();
        frame.setVisible(true);


    }

    public static XYDataset createDataset() {
        DefaultXYDataset xyDataset = new DefaultXYDataset();

        double[][] datas = new double[2][10];
        for (int i=0; i<10; i++) {
            datas[0][i] = i+5;
            datas[1][i] = (new Random().nextDouble())*10 - 5; // [0,1)

            xyDataset.addSeries(i, datas);
        }

        // show datas
        System.out.print("x: ");
        for (int i=0; i<10; i++) {
            System.out.print(datas[0][i]+" ");
        }
        System.out.println();
        System.out.print("y: ");
        for (int i=0; i<10; i++) {
//            String tmp = new DecimalFormat(".0").format(datas[1][i]);
            String tmp = String.format("%.1f", datas[1][i]);
            System.out.print(tmp+" ");
        }


        return xyDataset;
    }

    public static JFreeChart createChart(XYDataset xyDataset) {
        JFreeChart chart = ChartFactory.createScatterPlot("scatter0",
                "x",
                "y",
                xyDataset,
                PlotOrientation.VERTICAL,
                false, false, false);

        XYPlot plot = (XYPlot)chart.getPlot();

        // 背景色
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);

        // renderer
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setDefaultItemLabelGenerator(new StandardXYItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);

        return chart;
    }

}
