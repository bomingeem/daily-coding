package bomingeem.dailycoding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GreatestCommonDivisorTest {

    @Test
    public void 최대공약수_테스트() {
        //TODO:
        // 1. stack TDD 구현(push(), pop(), peek(), empty()..)
        // 2. Clean Code 7장
        // 3. SOLID 공부해오기
        // 4. GCD TDD 다시 해오기
        //beforeAll, beforeEach 개념 확인해보기
        //given
        int a = 12;
        int b = 20;
        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();

        //when
        int gcd = greatestCommonDivisor.gcd(a, b);

        //then
        assertThat(gcd).isEqualTo(4);
    }

    static class GreatestCommonDivisor {
        static int gcd(int a, int b) {
            while (b != 0) {
                int r = a%b;
                a = b;
                b = r;
            }
            return a;
        }
    }
}
