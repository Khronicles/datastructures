package khronitech.com.singlylinkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Node<T> {
    private T data;
    private Node<T> next;
}
