package bomingeem.dailycoding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest2 {
    //함수에 대해서 더 세세하게 표기 할 필요가 있다
    //사이즈 체크보다 이 값들이 잘 들어갔는지 확인 -> 반환하지 않고 스택에 대한 모든 값을 합해서 보여주면 될듯
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
        assertThat(stack.size, is(1));
    }

    public static class Stack<Integer> {
        private Integer data;
        private Stack next;
        private Stack top;
        private int size;

        public Stack() {
            this.size = 0;
        }

        public Stack(Integer data) {
            this.data = data;
            this.size = 0;
        }

        public void push(Integer data) {
            if (data == null) throw new EmptyStackException();
            Stack stack = new Stack(data);
            stack.next = top;
            top = stack;
            size++;
        }

        public int size() {
            return size;
        }
    }
}
