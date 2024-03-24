import java.util.Stack;

public class InOrder {
    // TC: O(N) | SC: O(N)
    // TC = O(N) or O(height of tree) for skewed tree.
    void inOrderRec(TreeNode root) {
        if (root == null)
            return;
        inOrderRec(root.left);
        System.out.println(root.data);
        inOrderRec(root.right);
    }

    // TC: O(N) | SC: O(N)
    void inOrderItr(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.data);
            cur = cur.right;
        }
    }
}
