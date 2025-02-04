//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    public DLLNode<T> head, tail;

    public DLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void setToNull() {
        head = tail = null;
    }

    public T firstEl() {
        if (head != null)
            return head.info;
        else return null;
    }

    public void addToHead(T el) {
        if (head != null) {
            head = new DLLNode<T>(el, head, null);
            head.next.prev = head;
        } else head = tail = new DLLNode<T>(el);
    }

    public void addToTail(T el) {
        if (tail != null) {
            tail = new DLLNode<T>(el, null, tail);
            tail.prev.next = tail;
        } else head = tail = new DLLNode<T>(el);
    }

    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }

    public void printAll() {
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
    }

    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next) ;
        if (tmp == null)
            return null;
        else return tmp.info;
    }

    public void printReverse() {
        DLLNode<T> t = tail;
        System.out.print(t.info + "  ");
        while (t.prev != null) {
            t = t.prev;
            System.out.print(t.info + "  ");
        }
        System.out.println(" ");
    }

    public void delete7() {
        int counter = 1;
        DLLNode<T> node = head;

        if (node.next == null) { //only one element is there
            head = tail = null;
            return;
        }

        while (counter < 7) {
            while (node.next != null && counter < 7) {
                node = node.next;
                counter++;
            }
            while (node.prev != null && counter < 7) {
                node = node.prev;
                counter++;
            }
        }


        if (node.next == null) {
            tail = node.prev;
            tail.next = null;
        } else if (node.prev == null) {
            head = node.next;
            head.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void insertAlternate(DLL<T> newList) throws Exception{
        if(this.isEmpty() || newList.isEmpty()){throw new Exception("Null List/s");}
        int size1 = 1, size2 = 1;
        DLLNode<T> temp1 = this.head, temp2 = newList.head;
        while(temp1.next != null){
            temp1 = temp1.next;
            size1++;
        }
        while(temp2.next != null){
            temp2 = temp2.next;
            size2++;
        }
        if(size1 != size2){throw new Exception("Lists sizes don't match");}

        temp1 = this.head; temp2 = newList.head; //Those will be used to iterate over the lists
        DLL<T> alterList = new DLL<T>();
        do{
            alterList.addToTail(temp1.info);
            alterList.addToTail(temp2.info);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }while(temp2 != null);

        this.setToNull();
        DLLNode<T> newEl = alterList.head;

        do{
            this.addToTail(newEl.info);
            newEl = newEl.next;
        }while(newEl != null);
    }
}