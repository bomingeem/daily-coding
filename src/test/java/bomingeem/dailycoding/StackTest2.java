package bomingeem.dailycoding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest2 {
    //함수에 대해서 더 세세하게 표기 할 필요가 있다
    //peek은 굳이 안해도 될 것 같다

    private Stack stack;
    //push: 스택의 가장 윗부분에 데이터를 추가
    //pop: 스택의 가장 윗부분에 데이터를 제거
    //isEmpty: 스택이 비어있을 경우 true를 반환
    //size: 스택의 사이즈 반환

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
