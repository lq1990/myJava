package cn.wendaocp.tree;

/**
 * @author lq
 * create 2020-02-10 20:50
 */
public class IsSameTree2 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1); p.right = new TreeNode(2); p.left = new TreeNode(11);
        TreeNode q = new TreeNode(1); q.right = new TreeNode(2);

        boolean res = new IsSameTree2().isSameTree(p, q);
        System.out.println(res);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p != null && q == null || p == null && q != null) {
            System.out.println("pos 1");
            return false;
        }

        if (q != null && p != null) {
            if (p.val != q.val) {
                System.out.println(" pos 2");
                return false;
            } else {
                System.out.println("pos 3");
                return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
            }

        }

        return true;
    }

}
