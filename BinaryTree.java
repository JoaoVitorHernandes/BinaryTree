import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinaryTree {
    Node<Integer> root;
    BinaryTree() {
        root = null;
    }
    void insert(int value) {
        root = insertRec(root, value);
    }
    private Node<Integer> insertRec(Node<Integer> root, int value) {
        if (root == null) {
            return new Node<>(value);
        }

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);

        return root;
    }
    private void printAsciiTreeRec(List<Node<Integer>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<Node<Integer>> newNodes = new ArrayList<>();
        for (Node<Integer> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                System.out.print(nodes.get(j).left != null ? "/" : " ");
                printWhitespaces(i + i - 1);
                System.out.print(nodes.get(j).right != null ? "\\" : " ");
                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printAsciiTreeRec(newNodes, level + 1, maxLevel);
    }
    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private boolean isAllElementsNull(List<Node<Integer>> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
