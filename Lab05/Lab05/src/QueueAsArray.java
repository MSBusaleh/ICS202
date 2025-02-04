// Java program to implement a queue using an array 
public class QueueAsArray<T> { 
    private int front, rear, capacity;
    private T[] queue;
  
    public QueueAsArray(int capacity) { 
        front = rear = -1; 
        this.capacity = capacity; 
        queue = (T[]) new Object[capacity]; 
    } 
    
    public boolean isEmpty(){
       return front == -1;
    }
    
    public boolean isFull(){
      return rear == capacity - 1;
    }
  
    // function to insert an element at the rear of the queue 
    public void enqueue(T data)  { 
        if (isFull())
            throw new UnsupportedOperationException("Queue is full!"); 
        if(isEmpty())
           front++;
           
        rear++;
        queue[rear] = data;
    } 

    /*
    public T dequeue() { 
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
        T temp = queue[front];    
        if (rear == 0) {  
            rear = front = -1;
        }
        else{
            for(int i = 0; i <= rear - 1; i++) { 
                queue[i] = queue[i + 1]; 
            } 
            rear--;  
        }
        return temp; 
    }
     */

    public T dequeue(){
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        T el = queue[front]; //Store the first el
        if (rear == 0) {
            rear = front = -1;
        }
        else
            dequeue(0);

        return el;
    }

    private void dequeue(int idx){
        queue[idx] = queue[idx+1];//Move the next el

        if(idx+1 == rear) { //Reached the end
            rear = idx;
            return;
        }
        else
            dequeue(idx+1);
    }


       
    public boolean search(T e){
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
            
        for(int i = 0; i <= rear; i++) 
            if(e.equals(queue[i]))
               return true;
               
        return false;
  }
  
  public String toString()  { 
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
         
        String str = "";  
        for (int i = 0; i <= rear; i++) { 
            str = str + queue[i] + "   "; 
        } 
        
        return str;
    } 
  
    public  T peek() { 
        if (isEmpty())
             throw new UnsupportedOperationException("Queue is empty!"); 
 
        return queue[front];  
    } 
} 