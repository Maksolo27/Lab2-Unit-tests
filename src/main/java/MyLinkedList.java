public class MyLinkedList {
    private Node head;
    private Node tail;
    private int listSize;

    private static class Node {
        char element;
        int index;
        Node next;
        Node prev;

        public Node(char element, int index) {
            this.element = element;
            this.index = index;
        }
    }

    public MyLinkedList() {
        listSize = 0;
        head = tail = null;
    }

    public Node getHeadNode() {
        return head;
    }

    public Node getTailNode() {
        return tail;
    }

    public int length() {
        return listSize;
    }

    public void append(char newElement) {
        Node newNode = new Node(newElement, listSize);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        listSize++;
    }

    public void insert(char newElement, int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node tempNode = head;
            while (tempNode.index != index) {
                tempNode = tempNode.next;
            }
            tempNode.element = newElement;
            listSize++;
        }
    }

    public char delete(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node tempNode = head;
            while (tempNode.index != index) {
                tempNode = tempNode.next;
            }
            if (head.index == tail.index) {
                head = null;
                tail = null;
            }
            else if (tempNode.index == head.index){
                head = tempNode.next;
                head.prev = null;
            }
            else if (tempNode.index == tail.index){
                tail = tempNode.prev;
                tail.next = null;
            }
            else {
                tempNode.prev.next = tempNode.next;
                tempNode.next.prev = tempNode.prev;
            }
            listSize--;
            reorderIndex();
            return tempNode.element;
        }
    }

    public void deleteAll(char character) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.element == character) {
                if (head.index == tail.index) {
                    head = null;
                    tail = null;
                }
                else if (tempNode.index == head.index){
                    head = tempNode.next;
                    head.prev = null;
                }
                else if (tempNode.index == tail.index){
                    tail = tempNode.prev;
                    tail.next = null;
                }
                else {
                    tempNode.prev.next = tempNode.next;
                    tempNode.next.prev = tempNode.prev;
                }
                listSize--;
                reorderIndex();
            }
            tempNode = tempNode.next;
        }
    }

    public char getChar(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node tempNode = head;
            while (tempNode.index != index) {
                tempNode = tempNode.next;
            }
            return tempNode.element;
        }
    }

    public MyLinkedList clone() {
        MyLinkedList duplicate = new MyLinkedList();
        Node tempNode = head;
        while (tempNode != null) {
            duplicate.append(tempNode.element);
            tempNode = tempNode.next;
        }

        return duplicate;
    }

    public void reverse() {
        Node tempNodeStart = head;
        Node tempNodeEnd = tail;
        int tempCounter = 0;
        char tempChar;
        while (tempCounter != Math.floor(listSize / 2)) {
            tempChar = tempNodeStart.element;
            tempNodeStart.element = tempNodeEnd.element;
            tempNodeEnd.element = tempChar;
            tempCounter++;
        }
    }

    public int findFirst(char character) {
        Node tempNode = head;
        int index = -1;
        while (tempNode != null) {
            if (tempNode.element == character) {
                index = tempNode.index;
                break;
            }
            tempNode = tempNode.next;
        }
        return index;
    }

    public int findLast(char character) {
        Node tempNode = tail;
        int index = -1;
        while (tempNode.prev != null) {
            if (tempNode.element == character) {
                index = tempNode.index;
                break;
            }
            tempNode = tempNode.prev;
        }
        return index;
    }

    public void clear() {
        Node tempNode = tail;
        while (tempNode.prev != null) {
            tempNode.next = null;
            tempNode = tempNode.prev;
        }
        listSize = 0;
        head = null;
        tail = null;
    }

    public void extend(MyLinkedList list) {
        Node tempNode = tail;
        while (list.listSize != 0) {
            append(list.delete(0));
        }
    }

    private void reorderIndex() {
        Node tempNode = head;
        int tempCounter = 0;
        while(tempCounter != listSize) {
            tempNode.index = tempCounter;
            tempNode = tempNode.next;
            tempCounter++;
        }
    }
}

