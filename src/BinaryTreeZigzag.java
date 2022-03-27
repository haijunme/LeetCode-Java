import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeZigzag {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return output;
        helper(root,0);
        return output;
    }

    public void helper(TreeNode root, int level){
        if(output.size() == level){
            output.add(new ArrayList<>());
        }
        if(level % 2 == 0)
            output.get(level).add(0, root.val);
        else
            output.get(level).add(root.val);

        if(root.right != null){
            helper(root.right, level + 1);
        }

        if(root.left != null){
            helper(root.left, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node21 = new TreeNode(4, null, null);
        TreeNode node22 = new TreeNode(5, null, null);
        TreeNode node11 = new TreeNode(2, node21, null);
        TreeNode node12 = new TreeNode(3, null, node22);
        TreeNode root = new TreeNode(1, node11, node12);
        BinaryTreeZigzag binaryTreeZigzag = new BinaryTreeZigzag();
        List<List<Integer>> answer = binaryTreeZigzag.zigzagLevelOrder(root);
        System.out.println(answer);
    }
}
