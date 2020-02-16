package cn.wendaocp.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Tree本身就是递归定义，所以在 遍历 getHeight size 求解时，都用递归
 *
 * @author lq
 * create 2020-02-10 12:26
 */
public class TreeDemo01 {

    public static void main(String[] args) {
        // create
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, node5);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, node7);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, node6);
        TreeNode node1 = new TreeNode(1, node4, node2);

        LinkedBinaryTree btree = new LinkedBinaryTree(node4);

        // 先序遍历 1452367
        System.out.println("先序遍历：");
        btree.preOrderTraverse();
        System.out.println();

        // 中序遍历 4513267
        btree.inOrderTraverse();


        // 后序遍历 5437621
        btree.postOrderTraverse();

        // getHeight
        btree.getHeight();

        // size
        btree.size();


        List<List<Integer>> lists = btree.levelOrder(node1);
        for (List<Integer> list : lists) {
            for (Integer elem :list){
                System.out.print("[ "+elem + " ]");
            }
            System.out.println();
        }

    }


}

class LinkedBinaryTree {

    private TreeNode root; // root node

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(TreeNode root) {
        this.root = root;
    }

    // 先序遍历
    public void preOrderTraverse() {

        if (root != null) {
            // 根
            System.out.print(root.val+" ");

            // 左
            // 构建一个二叉树，根是左子树的根
            LinkedBinaryTree leftChild = new LinkedBinaryTree(root.left);
            leftChild.preOrderTraverse();

            // 右
            LinkedBinaryTree rightChild = new LinkedBinaryTree(root.right);
            rightChild.preOrderTraverse();

        }

    }

    public void inOrderTraverse() {
        System.out.println("中序遍历：");

        this.inOrderTraverse(root);

        System.out.println();
    }

    private void inOrderTraverse(TreeNode root) {
        int newRes = 0;

        if (null != root) {
            // left
            this.inOrderTraverse(root.left);

            // root.val
            System.out.print(root.val+" ");

            // right
            this.inOrderTraverse(root.right);
        }

    }

    public void postOrderTraverse() {
        System.out.println("后序遍历：");

        this.postOrderTraverse(root);

        System.out.println();
    }

    private void postOrderTraverse(TreeNode root) {
        if (null != root) {
            // left
            this.postOrderTraverse(root.left);

            // right
            this.postOrderTraverse(root.right);

            // root
            System.out.print(root.val+" ");

        }

    }


    public void getHeight() {
        System.out.println("二叉树的高度：");
        System.out.println(this.getHeight(root));
    }

    private int getHeight(TreeNode root) {
        if (root != null) {
            // 获取左子树高度
            int heightLeft = this.getHeight(root.left);

            // 获取右子树高度
            int heightRight = this.getHeight(root.right);

            // 返回 左子树 右子树高度 +1
            return Math.max(heightLeft, heightRight)+1;
        }else {
            return 0;
        }
    }

    public void size() {
        System.out.println("二叉树节点的数目：");
        System.out.println(this.size(root));
    }

    private int size(TreeNode root) {

        if (null != root) {
            int lsize = this.size(root.left);
            int rsize = this.size(root.right);
            return lsize+rsize+1;
        } else {
            return 0;
        }
    }

    /**
     * use Queue
     */
    public List<List<Integer>> levelOrder0(TreeNode node) {
        System.out.println("层次遍历：");

        if (node == null) return null;

        // 确定每层有几个node
//        ArrayList<Integer> nEachLevel = new ArrayList<>();
//        nEachLevel.add(1);
//
//        while (node.left != null || node.right != null) {
//            if (node.left != null) {
//
//            }
//        }

        List<List<Integer>> resList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);

//        ArrayList<Integer> level1 = new ArrayList<>();
//        level1.add(node.val);
//        resList.add(level1);

        while (queue.size() > 0) {
            TreeNode tmp = queue.poll();

            // System.out.print(tmp.val + " ");


            if (tmp.left != null || tmp.right != null) {

                if (tmp.left != null) {
                    queue.add(tmp.left);
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                }

            }

        }

        return resList;
    }


    private List<List<Integer>> list = new ArrayList<>();
    /**
     * 递归
     *
     * @param node
     * @param level
     * @return
     */
    private void levelOrder(TreeNode node, int level) {

        if (list.size() == level) {
            list.add(new ArrayList<Integer>());
        }

        this.list.get(level).add(node.val);

        if (node.left != null) {
            this.levelOrder(node.left, level + 1);
        }

        if (node.right != null) {
            this.levelOrder(node.right, level + 1);
        }

    }

    public List<List<Integer>> levelOrder(TreeNode node) {
        if (node == null) return null;

        this.levelOrder(node, 0);

        return this.list;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {val = x;}

    TreeNode () {}

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
