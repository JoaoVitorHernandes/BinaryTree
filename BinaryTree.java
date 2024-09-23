class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    void insert(T value) {
        root = insertRec(root, value);
    }

    Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }

        if (value.compareTo(root.value) < 0)
            root.left = insertRec(root.left, value);
        else if (value.compareTo(root.value) > 0)
            root.right = insertRec(root.right, value);

        return root;
    }

    void delete(T value) {
        root = deleteRec(root, value);
    }

    Node<T> deleteRec(Node<T> root, T value) {
        if (root == null) return root;

        if (value.compareTo(root.value) < 0)
            root.left = deleteRec(root.left, value);
        else if (value.compareTo(root.value) > 0)
            root.right = deleteRec(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    T minValue(Node<T> root) {
        T minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
}
