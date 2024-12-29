package common;


import java.util.Comparator;
import java.util.Stack;

public class MStack<T> {

    public Stack<T> stack = new Stack<>();

    public void push(T element, Comparator<T> comparator) {
        if ( this.stack.isEmpty() || comparator.compare( element, this.stack.peek() ) > 0  ) {
            stack.push(element);
        }
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

}
