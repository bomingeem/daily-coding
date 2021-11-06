package bomingeem.dailycoding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest3 {
    private Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack();
    }

    @Test
    public void pushedNullValueTest() {
        stack.push(null);
        assertThat(stack.isEmpty(), is(false));
    }

    public static class Stack<Integer> {
        private Integer[] array;
        private Integer data;

        public Stack() {};
        public Stack(Integer data) {
            this.data = data;
        };

        public Integer push(Integer data) {
            array[0] = data;
            return data;
        }

        public boolean isEmpty() {
            return data == null;
        }
    }
}
