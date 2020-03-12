package cn.wendaocp.ml;


import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;

/**
 * ml in java
 *
 * @author lq
 * @since 2020-03-11 16:56
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("ml in java");

        // mat1
        DenseMatrix64F mat1 = new DenseMatrix64F(3, 2);
        mat1.set(0,0, 1);
        mat1.print();

        // mat2
        DenseMatrix64F mat2 = new DenseMatrix64F(2, 5);
        mat2.set(0,1,2);
        mat2.print();

        // mat3
        DenseMatrix64F mat3 = new DenseMatrix64F(3, 2);
        mat3.set(1,1,10);
        mat3.print();

        // res of mult 矩阵乘法
        DenseMatrix64F res_mult = new DenseMatrix64F(3,5);
        CommonOps.mult(mat1, mat2, res_mult);
//        res_mult.print();

        // res of add 矩阵加法
        DenseMatrix64F res_add = new DenseMatrix64F(3, 2);
        CommonOps.add(mat1, mat3, res_add);
//        res_add.print();

        // 矩阵减法
        DenseMatrix64F res_sub = new DenseMatrix64F(3, 2);
        CommonOps.sub(mat1,mat3,res_sub);
//        res_sub.print();


        // 矩阵转置
        DenseMatrix64F res_trans = new DenseMatrix64F(2, 3);
        CommonOps.transpose(mat1, res_trans);
        res_trans.print();



    }



}
