package bomingeem.dailycoding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest2 {
    private Stack stack;

    //TODO:
    // - EmptyStackException으로 처리해야 할지 NullPointerException으로 처리해야 할지 크게 신경쓰지 않아도 되는 부분인가?
    // - 현재 작성 한 기준으로 놓쳤던 부분이나 더 신경써야 할 부분이있을까?

    @BeforeEach
    public void initialize() {
        stack = new Stack();
    }

    @Test
    public void stackPushNull() {
        stack.push(null);
        Assertions.assertThat(stack.size).isEqualTo(0);
    }

    @Test
    public void stackPushOneValue() {
        //given
        int x = 10;

        //when
        stack.push(x);

        //then
        assertThat(stack.sum(), is(10));
    }

    @Test
    public void stackPushTwoValue() {
        //given
        int x = 5500;
        int y = 12500;

        //when
        stack.push(x);
        stack.push(y);

        //then
        assertThat(stack.sum(), is(18000));
    }

    @Test
    public void stackPopNull() {
        stack.pop();
        Assertions.assertThat(stack.size).isEqualTo(0);
    }

    @Test
    public void stackPopOneValue() {
        //given
        int x = 10;

        //when
        stack.push(x);

        //then
        assertThat(stack.pop(), is(10));
    }

    @Test
    public void stackPopTwoValue() {
        //given
        int x = 10;
        int y = 45;

        //when
        stack.push(x);
        stack.push(y);
        stack.pop();

        //then
        assertThat(stack.pop(), is(10));
    }

    @Test
    public void stackIsEmpty() {
        //given
        int x = 10;

        //when
        stack.push(x);
        stack.pop();

        //then
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void stackSizeCheck() {
        //given
        int x = 50;

        //when
        stack.push(x);
        stack.push(x);
        stack.push(x);

        //then
        assertThat(stack.size(), is(3));
    }

    public static class Stack<E> {
        private E data;
        private Stack next;
        private Stack top;
        private int size;

        public Stack() {
            this.size = 0;
        }

        public Stack(E data) {
            this.data = data;
            this.size = 0;
        }

        public void push(E data) {
            if (data == null) throw new EmptyStackException();
            Stack stack = new Stack(data);
            stack.next = top;
            top = stack;
            size++;
        }

        public E pop() {
            if (top == null) throw new NullPointerException();
            E data = (E) top.data;
            top = top.next;
            size--;
            return data;
        }

        public int sum() {
            int length = size;
            int sum = 0;
            for (int i=0; i<length; i++) {
                sum += (int) pop();
            }
            return sum;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int size() {
            return size;
        }
    }
}
