package khronitech.com.doublylinkedlists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previous;
}
