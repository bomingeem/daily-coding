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
        public Stack(Integer data) {
            this.data = data;
        };

        public void push(Integer data) {
            Stack stack = new Stack(data);
        }

        public boolean isEmpty() {
            return data == null;
        }
    }
}
