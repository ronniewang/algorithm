package r.w.practice.tree;

/**
 * @author ronniewang
 * 2019-10-18 15:46
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {

        this.val = val;
    }

    public static void main(String[] args) {

        final TreeNode _2 = new TreeNode(2);
        final TreeNode _3 = new TreeNode(3);
        final TreeNode _4 = new TreeNode(4);
        final TreeNode _5 = new TreeNode(5);
        final TreeNode _6 = new TreeNode(6);
        final TreeNode _7 = new TreeNode(7);
        final TreeNode _8 = new TreeNode(8);
        _3.left = _2;
        _3.right = _4;
        _7.left = _6;
        _7.right = _8;
        _5.left = _3;
        _5.right = _7;

        preOrder(_5);
        System.out.println();
        inOrder(_5);
        System.out.println();
        postOrder(_5);
    }

    private static void preOrder(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    private static void inOrder(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrder(treeNode.right);
    }
    private static void postOrder(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }
}
