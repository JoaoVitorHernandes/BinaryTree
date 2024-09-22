class Node<T extends Comparable<?>> {
    T data;
    Node<T> left, right;
    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
    }
}