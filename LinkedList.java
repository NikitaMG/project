package project;

public class LinkedList implements IntList{
    private Node head;
    private int size;
    private Node tail;

    public LinkedList(){
        head=null;
        size=0;
        tail=null;
    }
    @Override
    public void add(int element) {
        Node node = new Node();
        node.setValue(element);
        node.setNext(null);
        if (isEmpty()) {
            node.setPrev(null);
            head = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    @Override
    public void add(int index, int element) {
        checkIndex(index);
        Node newNode = new Node();
        newNode.setValue(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else if (index == size - 1) {
            add(element);
            size--;
        } else {
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.getNext();
            }
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }
        size++;
    }

    @Override
    public void clear() {
        head = null;
        tail=null;
        size = 0;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int remove(int index) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
        }
        int deletedEl = node.getNext().getValue();
        node.setNext(node.getNext().getNext());
        size--;
        return deletedEl;
    }

    @Override
    public boolean removeByValue(int value) {
        int count = 0;
        Node node = head;
        while (node.getValue() != value) {
            node = node.getNext();
            count++;
        }
        remove(count);
        return true;
    }

    @Override
    public int set(int index, int element) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        int previousEl = node.getValue();
        node.setValue(element);
        return previousEl;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        return null;
        //hmm...
    }


    @Override
    public int[] toArray() {
        int[] array;

        if (head == null) {
            array = new int[0];
        } else {
            array = new int[size];
            int count = 0;
            Node node = head;

            while (node != null) {
                array[count] = node.getValue();
                count++;
                node = node.getNext();
            }
        }
        return array;
    }


    private void checkIndex(int index) {
        boolean checkIndex = index < 0 || index > size;
        if (checkIndex) {
            throw new IndexOutOfBoundsException(String.format("Index should be greater than -1 and less than %s.", size));
        }
    }

    private static class Node {
        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        private int value;
        private Node next;
        private Node prev;
    }
}
