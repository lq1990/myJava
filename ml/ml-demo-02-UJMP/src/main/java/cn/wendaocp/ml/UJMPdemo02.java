package cn.wendaocp.ml;

import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;
import org.ujmp.core.enums.ValueType;
import org.ujmp.core.util.matrices.IrisMatrix;

/**
 * UJMP
 *
 * @author lq
 * @since 2020-03-12 22:08
 */
public class UJMPdemo02 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        IrisMatrix matrix = DenseMatrix.Factory.irisMatrix();
        System.out.println(matrix);

        long columnCount = matrix.getColumnCount();
        System.out.println("columnCount: "+columnCount);

        long rowCount = matrix.getRowCount();
        System.out.println("rowCount: "+rowCount);

//        matrix.showGUI();

        // 获取某一列
        Matrix col0 = matrix.selectColumns(Calculation.Ret.NEW, 0);
//        System.out.println(col0);
//        System.out.println(col0.getValueType()); // STRING。对于number而言也是STRING类型

        Matrix col4 = matrix.selectColumns(Calculation.Ret.NEW, 4);
//        System.out.println(col4);

        ValueType valueType = col4.getValueType();
//        System.out.println(valueType);

        // 获取特定位置的数
        double asDouble = matrix.getAsDouble(0, 0);// setAsDouble 相对
//        System.out.println(asDouble);


        // 获取指定 范围的数据，比如 行0-2， 列1-3
        Matrix select = matrix.select(Calculation.Ret.NEW, new long[]{0,1}, new long[]{1,2});
        System.out.println(select);


        // 矩阵求均值,dim=0是对列, dim=1对行
        Matrix mean = matrix.mean(Calculation.Ret.NEW, 0, true);
//        System.out.println(mean);


        // 标准差，考虑贝塞尔校正(当对采样数据进行求std时，往往需要校正)
        Matrix std = matrix.std(Calculation.Ret.NEW, 0, true, true);
//        System.out.println(std);


        // replace
        Matrix matrix1 = matrix.replace(Calculation.Ret.NEW, "Iris-setosa", "0");
        Matrix matrix2 = matrix1.replace(Calculation.Ret.NEW, "Iris-versicolor", "1");
        Matrix matrix3 = matrix2.replace(Calculation.Ret.NEW, "Iris-virginica", "2");

        matrix3.showGUI();

    }

}
