package khronitech.com.singlylinkedlist;

public class SinglyLinkedListImpl<T> {
    private Node<T> head;

    @Override
    public String toString() {
        return "SinglyLinkedListImpl{" +
                "head=" + head +
                '}';
    }

    public void addFirst(T value){
        Node<T> newNode = new Node<>(value, null);
        if(head == null){
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addLast(T value){
        Node<T> newNode = new Node<>(value, null);
        Node<T> currentNode = head;
        if(currentNode == null){
            addFirst(value);
        } else {
            while(!checkDataAvaiability(value) && currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    public boolean isEmpty(){
        Node<T> currentNode = head;
        return currentNode == null;
    }

    public boolean checkDataAvaiability(T value){
        Node<T> currentNode = head;
        return currentNode.getData().equals(value);
    }

    public boolean contains(T value){
        Node<T> currentNode = head;
        if(currentNode == null || !checkDataAvaiability(value)){
            return false;
        }

        if(checkDataAvaiability(value)){
            return true;
        } else {
            while(currentNode != null && !checkDataAvaiability(value)){
                currentNode = currentNode.getNext();
            }
        }
        return true;
    }

    public boolean removeFirst(T value){
        Node<T> currentNode = head;
        if(isEmpty() || !contains(value)){
            return false;
        }
        if(checkDataAvaiability(value)){
            head = currentNode.getNext();
            currentNode.setNext(head);
        }
        return true;
    }

    public boolean removeLast(T value){
         Node<T> currentNode = head;
         if(isEmpty() || contains(value)){
             return false;
         } if(checkDataAvaiability(value)){
             removeFirst(value);
         } else {
           while(!currentNode.getNext().getData().equals(value)){
               currentNode = currentNode.getNext();
           }
           currentNode.setNext(currentNode.getNext().getNext());
         }

         return true;
    }

}
