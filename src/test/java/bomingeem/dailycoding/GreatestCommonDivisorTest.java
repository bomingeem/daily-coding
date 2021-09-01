package bomingeem.dailycoding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GreatestCommonDivisorTest {

    @Test
    public void 최대공약수_테스트() {
        //given
        int a = 12;
        int b = 20;

        //when
        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
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
