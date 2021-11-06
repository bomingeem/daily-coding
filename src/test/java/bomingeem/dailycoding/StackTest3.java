package bomingeem.dailycoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest3 {
    private Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack();
    }

    @Test
    public void pushedNullValueTest() {
        stack.push(null);
        assertThrows(NullPointerException.class, () -> {
            System.out.println("null cannot be allowed");
        });
    }

    @Test
    public void pushSuccessfullyWhenOnlyOneValuePushedTest() {
        //when
        Object push = stack.push(1);

        //then
        assertThat(stack.size(), is(1));
    }

    @Test
    public void pushSuccessfullyWhenOnlyTwoValuePushedTest() {
        //when
        Object pushedFirstValue = stack.push(1);
        Object pushedSecondValue = stack.push(2);

        //then
        assertThat(stack.size(), is(2));
    }

    public static class Stack<E> {
        private Object[] array;
        private int size;

        public Stack() {
            array = new Object[10];
            size = 0;
        };

        public Object push(Object data) {
            //TODO: NullPointerException 에러 시 어떻게 에러를 처리해야 올바른 방법일까?
            if (data == null) {
                throw new NullPointerException("null cannot be allowed");
            }
            array[0] = data;
            size++;
            return data;
        }

        public int size() {
            return size;
        }

    }
}
