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
    public void popSuccessfullyWhenOnlyOneValuePushedTest() {
        //when
        Object push = stack.push(1);

        //then
        assertThat(push, is(1));
    }

    public static class Stack<E> {
        private Object[] array;
        private Object data;
        private int size;

        public Stack() {
            array = new Object[10];
        };
        public Stack(int data) {
            this.data = data;
        };

        public Object push(Object data) {
            //TODO: NullPointerException 에러 시 어떻게 에러를 처리해야 올바른 방법일까?
            System.out.println(data);
            if (data == null) {
                throw new NullPointerException("null cannot be allowed");
            }
            array[0] = data;
            return data;
        }

        public boolean isEmpty() {
            return data == null;
        }

        public int size() {
            return size;
        }
    }
}
