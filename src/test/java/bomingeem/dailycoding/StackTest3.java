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

    public static class Stack<Integer> {
        private Integer[] array;
        private Integer data;

        public Stack() {};
        public Stack(Integer data) {
            this.data = data;
        };

        public Integer push(Integer data) {
            //TODO: NullPointerException 에러 시 어떻게 에러를 처리해야 올바른 방법일까?
            if (data == null) {
                throw new NullPointerException("null cannot be allowed");
            }
            array[0] = data;
            return data;
        }

        public boolean isEmpty() {
            return data == null;
        }
    }
}
