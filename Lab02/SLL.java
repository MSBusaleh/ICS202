//**************************  SLL.java  *********************************
//           a generic singly linked list class 

import java.util.EmptyStackException;

public class SLL<T> {

    private class SLLNode<T> {
        private T info;
        private SLLNode<T> next;
        public SLLNode() {
            this(null,null);
        }
        public SLLNode(T el) {
            this(el,null);
        }
        public SLLNode(T el, SLLNode<T> ptr) {
            info = el; next = ptr;
        }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
            head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
            head = tail = null;
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(el);
                     pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }

    @Override
    public String toString() {
        if(head == null)
            return "[ ]";
        String str = "[ ";
        SLLNode<T> tmp = head;
        while(tmp != null){
            str += tmp.info + " ";
            tmp = tmp.next;
        }
        return str+"]";
    }

    public boolean contains(T el) {
        if(head == null)
            return false;
        SLLNode<T> tmp = head;
        while(tmp != null){
            if(tmp.info.equals(el))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public int size(){
        if(head == null)
            return 0;

        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
            count++;
            p = p.next;
        }

        return count;
    }

    //  Please write the methods of Task02 here:
    public void insertBefore(int index, T newElem) throws IndexOutOfBoundsException{
        if(isEmpty() || index>=size()){
            throw new IndexOutOfBoundsException();
        }


        SLLNode<T> newNode = new SLLNode<>();
        newNode.info = newElem;

        if(index == 0 || (index==size()-1 && head == tail)){
            newNode.next = head;
            head = newNode;
        }
        else{
            SLLNode<T> p = head;
            int counter = 0;

            while(counter != index-1) {
                p = p.next;
                counter++;
            }

            newNode.next = p.next;
            p.next = newNode;
        }
    }

    public T delete(int index) throws IndexOutOfBoundsException{
        if(isEmpty() || index>=size()){
            throw new IndexOutOfBoundsException();
        }

        T returnValue;

        if(head == tail && (index == 0 || index == size()-1)){
            returnValue = head.info;
            head = tail = null;
        }
        else if(index == 0){
            returnValue = head.info;
            head = head.next;
        }
        else if(index == size()-1){
            SLLNode<T> p = head;
            while(p.next != tail){
                p = p.next;
            }

            p.next = null;
            returnValue = tail.info;
            tail = p;
        }
        else {
            SLLNode<T> p = head;
            int counter = 0;

            while (counter != index - 1) {
                p = p.next;
                counter++;
            }

            returnValue = p.next.info;
            p.next = p.next.next;
        }

        return returnValue;
    }

    public void insertAfterSecondOccurrence(T e1, T e2) throws Exception {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int occurences = 0;
        SLLNode<T> p = head;

        while (p != null) {

            if (p.info.equals(e2)) {
                occurences++;
            }

            if (occurences == 2) {
                SLLNode<T> newNode = new SLLNode<>(e1, p.next);
                p.next = newNode;

                if (tail == p) {
                    tail = newNode;
                }

                p = null;
            }
            else {
                p = p.next;
            }
        }

        if (occurences < 2) {throw new Exception("The Element doesn't occur twice in this list");}
    }
}

