package cn.wendaocp.tree;

import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;

/**
 * 递归；
 * 层次遍历；
 *
 * @author lq
 * create 2020-02-10 18:22
 */
public class IsSameTree {

    List<Integer> pListPre = new ArrayList<>();
    List<Integer> pListIn = new ArrayList<>();
    List<Integer> qListPre = new ArrayList<>();
    List<Integer> qListIn = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1); p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1); q.right = new TreeNode(2);

        boolean res = new IsSameTree().isSameTree(p, q);
        System.out.println(res);


    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return false;

        this.preOrderP(p);
        this.inOrderP(p);
        this.preOrderQ(q);
        this.inOrderQ(q);

        // p vs q
        int pSize = pListPre.size();
        int qSize = qListPre.size();

        if (pSize != qSize) {
            return false;
        }

        for (int i=0; i<pSize; i++) {
            int piPre = pListPre.get(i);
            int piIn = pListIn.get(i);
            int qiPre = qListPre.get(i);
            int qiIn = qListIn.get(i);
            if (piPre != qiPre || piIn != qiIn) {
                return false;
            }

        }

        return true;
    }


    private void preOrderP(TreeNode node) {

        if (null != node) {
            // root
//            System.out.println(p.val);
            pListPre.add(node.val);

            // left
            this.preOrderP(node.left);

            // right
            this.preOrderP(node.right);

        }
    }

    private void preOrderQ(TreeNode node) {

        if (null != node) {
            // root
//            System.out.println(p.val);
            qListPre.add(node.val);

            // left
            this.preOrderQ(node.left);

            // right
            this.preOrderQ(node.right);

        }
    }

    private void inOrderP(TreeNode node) {

        if (null != node) {

            // left
            this.inOrderP(node.left);

            // root
            pListIn.add(node.val);

            // right
            this.inOrderP(node.right);

        }
    }

    private void inOrderQ(TreeNode node) {

        if (null != node) {
            // left
            this.inOrderQ(node.left);

            // root
            qListIn.add(node.val);

            // right
            this.inOrderQ(node.right);

        }
    }

}


