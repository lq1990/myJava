package cn.wendaocp.ml;

import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;

/**
 * ejml
 * @author lq
 * @since 2020-03-11 21:39
 */
public class Demo02 {
    public static int D = 3;

    public static void main(String[] args) {
        DenseMatrix64F mat = new DenseMatrix64F(3, 3);
        mat.set(0,0,4.0);
        mat.set(0,1,13.0);
        mat.set(0,2,-16.0);
        mat.set(1,0,12.0);
        mat.set(1,1,37.0);
        mat.set(1,2,-43.0);
        mat.set(2,0,-16.0);
        mat.set(2,1,-43.0);
        mat.set(2,2,98.0);

        System.out.println(mat);

        // 数组，内元素是 矩阵格式
        DenseMatrix64F[] vecs = new DenseMatrix64F[D];

        CommonOps.rowsToVector(mat, vecs); // 把mat每一行 存到vecs数组中




    }
}
