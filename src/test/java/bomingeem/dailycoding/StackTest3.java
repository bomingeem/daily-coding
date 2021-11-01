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

    public static class Stack {
        private Integer data;
        public Stack() {};

        public void push(Integer data) {
        }

        public boolean isEmpty() {
            return true;
        }
    }
}
