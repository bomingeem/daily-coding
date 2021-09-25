package bomingeem.dailycoding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StackTest {

    private Stack stack;

    @Test
    public void stackPushTest() {
        //given
        stack = new Stack();
        int x = 10;
        int y = 20;

        //when
        stack.push(x);
        stack.push(y);

        //then
        //push 자체를 구현 안하고 size 체크 한 경우 실패가 났다
        assertThat(stack.size(), is(2));

        //처음에 stack 자체를 String 으로 명시하고 Integer 타입을 대입 한 경우
        //assertThat(stack, instanceOf(Integer.class));
    }

    @Test
    public void stackPopTest() {
        //given
        stack = new Stack();

        //when
        stack.push(10);
        stack.pop();

        //then
        //애초에 null 인 상태에서 검증했을 때 pop 할 데이터가 없었다(could be null). 이전 라인에서부터 걸리기 때문에 null check 필수
        //assertThat(stack.size(), is(1));

        assertThat(stack.size(), is(0));
    }

    @Test
    public void stackPeekTest() {
        //given
        stack = new Stack();

        //when
        stack.push(25);
        stack.push(30);
        //then
        //데이터가 없을 경우 peek을 한다면?
        //Assertions.assertThat(stack.peek()).isEqualTo(10);
        Assertions.assertThat(stack.peek()).isEqualTo(30);
    }

    @Test
    public void stackIsEmptyTest() {
        //given
        stack = new Stack();

        //when
        stack.push(20);

        //then
        //처음 구현 시 return true;로 주고 작성한 실패 코드
        //Assertions.assertThat(stack.isEmpty()).isFalse();

        //데이터 push 후 작성한 실패 코드
        //Assertions.assertThat(stack.isEmpty()).isTrue();

        Assertions.assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    public void stackSizeTest() {
        //given
        stack = new Stack();

        //when
        stack.push(10);
        stack.push(20);
        stack.pop();
        stack.pop();

        //then
        //Assertions.assertThat(stack.size()).isEqualTo(3);

        Assertions.assertThat(stack.size()).isEqualTo(0);
    }

    static class Stack<E> {
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

        //push: 스택의 가장 윗부분에 추가한다
        public void push(E data) {
            Stack stack = new Stack(data);
            stack.next = top;
            top = stack;
            size++;
        }

        //pop: 스택의 가장 위에 있는 항목을 '제거'한다
        public E pop() {
            if (top == null) throw new EmptyStackException();
            E data = (E) top.data;
            top = top.next;
            size--;
            return data;
        }

        //peek: 스택의 가장 위에 있는 항목을 반환한다
        public E peek() {
            return (E) top.data;
        }

        //isEmpty: 스택이 비어있을 경우 true 를 반환한다
        public boolean isEmpty() {
            return top == null;
        }
        //size: 스택의 사이즈를 반환한다
        public int size() {
            return size;
        }
    }
}
