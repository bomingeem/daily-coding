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
    // - 현재 작성 한 기준으로 놓쳤던 부분이나 더 신경써야 할 부분이있을까?
    //   1. 변수/함수명 신경쓰기: [example] stackPopOneValue → popSuccessfullyWhenOnlyOneValuePushedTest, data/information 사용 지양
    //   2. 예외처리 확실히 해보기: assertThrows 활용
    // - stack TDD 마지막으로 다시 짜보기: 너무 많은것이 구현되어 있음 → 테스트를 하지 않았다는 증거
    // - clean code 10장 정리

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
