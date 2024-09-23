class Node<T extends Comparable<T>> {
    T value;
    Node<T> left, right;

    public Node(T item) {
        this.value = item;
        left = right = null;
    }
}
