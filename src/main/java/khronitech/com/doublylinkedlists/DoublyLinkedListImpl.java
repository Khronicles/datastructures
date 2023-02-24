package khronitech.com.doublylinkedlists;

public class DoublyLinkedListImpl<T> {
    private Node<T> head;

    public boolean checkDataAvailability(T value){
        Node<T> currentNode = head;
        return currentNode.getData().equals(value);
    }
    public void addFirst(T value){
        Node<T> newNode = new Node<>(value, null, null);
        if (!isEmpty()) {
            newNode.setNext(head);
        }
        head = newNode;

    }
    public void addLast(T value){
        Node<T> newNode = new Node<>(value, null, null);
        Node<T> currentNode = head;
        if(isEmpty()){
           addFirst(value);
        } else {
            while(!checkDataAvailability(value) && currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
        }
    }
    public boolean contains(T value){
        Node<T> currentNode = head;
        if(isEmpty() || !checkDataAvailability(value)){
            return false;
        }else if(checkDataAvailability(value)){
            return true;
        } else {
            while(currentNode != null && !checkDataAvailability(value)){
                currentNode = currentNode.getNext();
            }
        }
        return true;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean removeFirst(T value){
        Node<T> currentNode = head;
        if(isEmpty() || !contains(value)){
            return false;
        } else {
            head = currentNode.getNext();
            currentNode.setNext(head);
        }
        return true;
    }

    public boolean removeLast(T value){
        Node<T> currentNode = head;
        if(isEmpty() || contains(value)){
            return false;
        } else {
            while(!currentNode.getData().equals(value)){
                currentNode = currentNode.getNext();
            }

            Node<T> previousNode = currentNode.getPrevious();
            previousNode.setNext(currentNode.getNext());
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> currentNode = head;
        if (currentNode.getPrevious() == null) {
            builder.append("null");
        }
        while (currentNode != null) {
            builder.append(" <- ").append(currentNode.getData()).append(" -> ");
            currentNode = currentNode.getNext();
        }
        builder.append("null");
        return builder.toString();
    }

}
