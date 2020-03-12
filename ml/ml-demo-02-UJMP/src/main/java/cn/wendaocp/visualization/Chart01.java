package cn.wendaocp.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.io.File;

/**
 * JFreeChart 学习:
 *   创建dataset
 *   创建chart
 *   将chart输出
 *
 * PieChart
 * @author lq
 * @since 2020-03-12 16:05
 */
public class Chart01 {
    public static void main(String[] args) throws Exception {
        JFreeChart chart = createChart(createDataset());

        ChartUtils.saveChartAsJPEG(
                new File("D:\\myGithub\\myJava\\ml\\ml-demo-02-UJMP\\dest\\pie.jpeg"),
                chart, 500, 500);

        System.out.println("over");

    }

    /**
     * 创建一个数据源，饼图数据
     * @return
     */
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", new Double(43.2000000000003D));
        dataset.setValue("Two", new Double(10D));
        dataset.setValue("Three", new Double(27.5D));
        dataset.setValue("Four", new Double(17.5D));

        return dataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart Demo 01",
                pieDataset, true, true, false);

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setExplodePercent("One", 0.3); // 把Label="One"的那一块 挖出来30%
        plot.setNoDataMessage("no data"); // if no data, show message
        return pieChart;
    }


}
