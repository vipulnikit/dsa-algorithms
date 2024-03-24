import java.util.Stack;

public class PostOrder {
    // TC: O(N) | SC: O(N)
    // TC = O(N) or O(height of tree) for skewed tree.
    void postOrderRec(TreeNode root) {
        if (root == null)
            return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.println(root.data);
    }

    // TC: O(N) | SC: O(N)
    void postOrderItr(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.println(node.data);
        }
    }
}
