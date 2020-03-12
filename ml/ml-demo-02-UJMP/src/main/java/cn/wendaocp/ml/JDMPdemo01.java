package cn.wendaocp.ml;

import org.jdmp.core.dataset.AbstractListDataSet;
import org.jdmp.core.dataset.DataSet;
import org.jdmp.core.dataset.ListDataSet;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.DenseMatrix2D;
import org.ujmp.core.calculation.Calculation;
import org.ujmp.core.doublematrix.DenseDoubleMatrix2D;
import org.ujmp.core.util.matrices.IrisMatrix;

/**
 * java data mining package
 * @author lq
 * @since 2020-03-12 20:19
 */
public class JDMPdemo01 {
    public static void main(String[] args) {
        System.out.println("jdmp");

        quickstart();

    }

    private static void quickstart() {
        // load example data set
        ListDataSet dataSet = DataSet.Factory.ANIMALS();

        System.out.println(dataSet);



//        IrisMatrix matrix = DenseMatrix.Factory.irisMatrix();

//        System.out.println(matrix);

    }


}
