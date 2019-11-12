package r.w.practice.leetcode.nAryTreePreorderTraversal.nAryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

class Node {

    public int val;

    public List<Node> children;

    public Node() {

    }

    public Node(int _val, List<Node> _children) {

        val = _val;
        children = _children;
    }
};

class Solution {

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        _pOrder(root, result);
        return result;
    }

    private void _pOrder(Node node, List<Integer> result) {

        if (node == null) {
            return;
        }
        result.add(node.val);
        final List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                _pOrder(child, result);
            }
        }
    }
}