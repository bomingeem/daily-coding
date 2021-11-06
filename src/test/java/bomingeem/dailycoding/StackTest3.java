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
        //then
        stack.push(null);

        //then
        assertThrows(NullPointerException.class, () -> {
            System.out.println("null cannot be allowed");
        });
    }

    @Test
    public void successfullyWhenOnlyOneValuePushedTest() {
        //when
        Object push = stack.push(1);

        //then
        assertThat(stack.size(), is(1));
    }

    @Test
    public void successfullyWhenTwoValuePushedTest() {
        //when
        Object pushedFirstValue = stack.push(1);
        Object pushedSecondValue = stack.push(2);

        //then
        assertThat(stack.size(), is(2));
    }

    @Test
    public void poppedNullValueTest() {
        //when
        Object pop = stack.pop();

        //then
        assertThat(pop, is(0));
    }

    @Test
    public void popSuccessfullyWhenOnlyOneValuePushedTest() {
        //when
        stack.push(1);
        Object pop = stack.pop();

        //then
        assertThat(pop, is(1));
    }

    @Test
    public void popSuccessfullyWhenTwoValuePushedTest() {
        //when
        stack.push(5);
        stack.push(10);
        Object poppedFirstValue = stack.pop();
        Object poppedSecondValue = stack.pop();

        //then
        assertThat(poppedFirstValue, is(10));
    }

    @Test
    public void checkStackIsEmptyTest() {
        //when
        boolean checkIsEmptyFlag = stack.isEmpty();

        //then
        assertThat(checkIsEmptyFlag, is(true));
    }

    @Test
    public void checkStackIsEmptyWhenPutValue() {
        //when
        stack.push(10);
        stack.push(30);

        //then
        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void sumOfAllValuesStackIsCorrected() {
        //when
        stack.push(3500);
        stack.push(2000);
        stack.push(550);
        stack.pop();

        //then
        assertThat(stack.sum(), is(5500));
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
            array[size] = data;
            size++;
            return data;
        }

        public Object pop() {
            if (array[0] == null) {
                throw new NullPointerException("null cannot be allowed");
            }
            Object object = array[size - 1];
            size--;
            return object;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int sum() {
            int sum = 0;
            //TODO: casting을 여러가지 방법으로 함에도 불구하고 for문이 0번째 index만 실행된다. 확인 필요
            for (int i=0; i<size; i++) {
                sum += (int) pop();
            }
            System.out.println(sum);
            return sum;
        }
    }
}
