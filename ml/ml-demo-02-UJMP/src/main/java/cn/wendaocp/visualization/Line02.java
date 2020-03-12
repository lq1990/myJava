package cn.wendaocp.visualization;

import com.sun.imageio.plugins.gif.GIFImageMetadataFormatResources;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtils;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.xml.crypto.Data;
import java.awt.*;
import java.io.File;
import java.util.Random;

/**
 * 折线图
 * @author lq
 * @since 2020-03-12 19:10
 */
public class Line02 {

    public static void main(String[] args)  throws  Exception{

        JFreeChart chart = createChart(createDateset());

        // save chart
        ChartUtils.saveChartAsPNG(
                new File("D:\\myGithub\\myJava\\ml\\ml-demo-02-UJMP\\dest\\line02.png"), chart, 500,500);
        System.out.println("over");

//        ChartFrame frame = new ChartFrame("", chart);
//        frame.pack();
//        frame.setVisible(true);

    }

    private static CategoryDataset createDateset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        double[][] datas = new double[2][10];
        for (int i=0; i<10; i++) {
            datas[0][i] = i+5;
            datas[1][i] = (new Random().nextDouble())*10 - 5; // [0,1)
        }

//        String[] rowKeys = new String[2];
//        rowKeys[0] = "row0";
//        rowKeys[0] = "row1";

//        String[] columnKeys = new String[10];
//        for (int i=0; i<10; i++) {
//            columnKeys[i] = "col"+i;
//        }

//        CategoryDataset categoryDataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, datas);
        CategoryDataset categoryDataset = DatasetUtils.createCategoryDataset("row", "col", datas);

        return categoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart chart = ChartFactory.createLineChart("line0",
                "x",
                "y",
                categoryDataset, PlotOrientation.VERTICAL,
                true,
                true,
                false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white); // 背景色
        plot.setDomainGridlinesVisible(true); // x grid on
        plot.setRangeGridlinesVisible(true);  // y grid on

        plot.setDomainGridlinePaint(Color.BLACK); // x grid line color
        plot.setRangeGridlinePaint(Color.black);  // y grid line color

        // 设置：line上 点可见，点见连线可见
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) plot.getRenderer();
        lineAndShapeRenderer.setDefaultLinesVisible(true);
        lineAndShapeRenderer.setDefaultShapesVisible(true);

        // 显示折点数据
        lineAndShapeRenderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineAndShapeRenderer.setDefaultItemLabelsVisible(true);


        return chart;
    }

}
