import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

    private MyLinkedList linkedList;
    private final int startLength = 10;

    @BeforeEach
    void setUp() {
        linkedList = new MyLinkedList();
        for (int i = 0; i < startLength - 2; i++) {
            linkedList.append((char) i);
        }
        linkedList.append('2');
        linkedList.append('2');
    }

    @Test
    void length() {
        Assertions.assertEquals(linkedList.length(), startLength);
    }

    @Test
    void append() {
        linkedList.append('9');
        Assertions.assertEquals(linkedList.getChar(linkedList.length() - 1), '9');

    }

    @Test
    void insert() {
        int length = linkedList.length();
        linkedList.insert('2', 5);
        Assertions.assertEquals(linkedList.length(), length + 1);
        Assertions.assertEquals(linkedList.getChar(5), '2');
    }

    @Test
    void delete() {
        int length = linkedList.length();
        linkedList.delete(3);
        Assertions.assertEquals(linkedList.length(), length - 1);
    }

    @Test
    void deleteAll() {
        linkedList.deleteAll('2');
        for (int i = 0; i < linkedList.length(); i++) {
            Assertions.assertNotEquals(linkedList.getChar(i), '2');
        }
    }

    @Test
    void getChar() {
        linkedList.getChar(8);
    }


    @Test
    void clear() {
        linkedList.clear();
        Assertions.assertNull(linkedList.getTailNode());
        Assertions.assertNull(linkedList.getHeadNode());
    }

    @Test
    void getHeadNode() {
        System.out.println(linkedList.getHeadNode());
    }

    @Test
    void getTailNode() {
        System.out.println(linkedList.getTailNode());
    }

}
