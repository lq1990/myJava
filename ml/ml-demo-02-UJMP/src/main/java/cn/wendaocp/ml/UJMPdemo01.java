package cn.wendaocp.ml;

import org.jfree.chart.plot.FastScatterPlot;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;
import org.ujmp.core.doublematrix.DenseDoubleMatrix2D;
import org.ujmp.core.intmatrix.impl.ImageMatrix;
import org.ujmp.core.objectmatrix.calculation.WelcomeMatrix;
import org.ujmp.core.treematrix.DefaultTreeMatrix;
import org.ujmp.core.treematrix.TreeMatrix;
import org.ujmp.core.util.matrices.LocalhostMatrix;
import org.ujmp.core.util.matrices.MandelbrotMatrix;

import java.io.FileInputStream;
import java.io.InputStream;


/**
 * using UJMP(universal java matrix package)
 *
 * 比 ejml 好用之处：方便链式计算 因为UJMP中矩阵计算有返回值
 *
 * @author lq
 * @since 2020-03-11 21:58
 */
public class UJMPdemo01 {
    public static void main(String[] args) throws Exception {
        test01();
//        test03();
//        testImage();
//        testLocalhostMatrix();

//        testMandelbrot();
//        testTree();

    }


    static void testTree() {
        // create a TreeMatrix with Strings as elements
        TreeMatrix<String> treeMatrix = new DefaultTreeMatrix<String>();

// create data
        treeMatrix.setRoot("root");
        treeMatrix.addChild("root", "child1");
        treeMatrix.addChild("root", "child2");
        treeMatrix.addChild("root", "child3");
        treeMatrix.addChild("child1", "subChild11");
        treeMatrix.addChild("child1", "subChild12");
        treeMatrix.addChild("child1", "subChild13");
        treeMatrix.addChild("child2", "subChild21");
        treeMatrix.addChild("child3", "subChild31");
        treeMatrix.addChild("child3", "subChild32");
        treeMatrix.addChild("subChild12", "subSubChild121");
        treeMatrix.addChild("subChild12", "subSubChild122");
        treeMatrix.addChild("subSubChild122", "subSubSubChild1221");

// show on screen
        treeMatrix.showGUI();


    }

    static void testMandelbrot() {
        MandelbrotMatrix m = new MandelbrotMatrix();
        m.showGUI();
    }

    private static void testLocalhostMatrix() throws Exception {
        LocalhostMatrix localhostMatrix = Matrix.Factory.localhostMatrix();

        localhostMatrix.showGUI();

    }

    /**
     *
     */
    private static void testImage() throws Exception {
        // get an img
        InputStream is = new FileInputStream("C:\\Users\\china\\Pictures\\dog1.jpg");

        // load image into matrix
        ImageMatrix imageMatrix = new ImageMatrix(is);

        imageMatrix.showGUI();

        is.close();


    }

    /**
     * cosine similarity matrix
     */
    private static void test03() {
        DenseMatrix mat = Matrix.Factory.correlatedColumns(10, 2, 0.1);
        // 计算相似度，结果存在新的matrix
        Matrix sim = mat.cosineSimilarity(Calculation.Ret.NEW, true);

//        mat.showGUI();

        sim.showGUI();

    }

    /**
     * 多种初始化方法 randn rand
     * showGUI
     */
    private static void test02() {
        // 元素值 [-1,1]
        DenseMatrix mat = Matrix.Factory.randn(4, 4);
        System.out.println(mat);

        // ones
        WelcomeMatrix welcomeMatrix = Matrix.Factory.welcomeMatrix();
//        System.out.println(welcomeMatrix);

        // 元素值范围：[0,1]
        DenseMatrix rand = Matrix.Factory.rand(10, 2);
//        System.out.println(rand);

        // show on screen
//        mat.showGUI();

        rand.showGUI();


    }

    /**
     * 普通初始化，
     * 矩阵 加减乘 元素乘 求逆 det eig
     */
    private static void test01() {
        // init
        DenseDoubleMatrix2D mat = DenseMatrix.Factory.zeros(2, 2);

        // set值
        mat.setAsDouble(5.0, 0, 0); // 0-based index
        mat.setAsDouble(1.0, 0, 1);
        mat.setAsDouble(3.0, 1, 0);
        mat.setAsDouble(4.0, 1, 1);
//        mat.setAsDouble(-2.0, 3, 3);
//        mat.setAsDouble(-2.0, 1, 3);

        System.out.println("mat");
        System.out.println(mat);

        // transpose
        Matrix transpose = mat.transpose();
        System.out.println("transpose");
        System.out.println(transpose);

        // plus
        Matrix plus = mat.plus(transpose);
//        System.out.println("mat plus transpose");
//        System.out.println(plus);

        // minus
        Matrix minus = mat.minus(transpose);
//        System.out.println("mat minus transpose");
//        System.out.println(minus);

        // 矩阵相乘 mtimes
        Matrix mtimes = mat.mtimes(transpose);
//        System.out.println("mat mtimes transpose");
//        System.out.println(mtimes);

        // 元素级别 * 2
        Matrix times = mat.times(2);
//        System.out.println("mat times 2");
//        System.out.println(times);

        // 求逆
//        System.out.println("inv");
//        System.out.println(mat.inv());

        // det
        double det = mat.det();
//        System.out.println("det");
//        System.out.println(det);

        // eig
        Matrix[] eig = mat.eig();
        System.out.println("eig");
        for (Matrix e : eig) {
            System.out.println(e);
            e.showGUI();
        }

    }

}
