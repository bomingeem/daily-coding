package bomingeem.dailycoding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LeafYearTest {
    //윤년은 연도가 4의 배수이면서 100의 배수가 아닐 때 또는 400의 배수일 때이다.
    private LeafYear leafYear;

    @BeforeEach
    public void init() {
        leafYear = new LeafYear();
    }

    //TODO: 실패나는 코드의 예시를 어떻게 먼저 접근했어야 했나?

    @Test
    public void checkMultipleOfFourTest() {
        //given
        int year = 2000;

        //when
        int result = leafYear.leafYear(year);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void checkMultipleOfFourAndNotMultipleOfOneHundredTest() {
        //given
        int year = 2012;

        //when
        int result = leafYear.leafYear(year);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void checkMultipleOfFourAndNotMultipleOfOneHundredOrFourHundredTest() {
        //given
        int year = 1999;

        //when
        int result = leafYear.leafYear(year);

        //then
        assertThat(result).isEqualTo(0);
    }

    public static class LeafYear {
        public static int leafYear(int year) {
            if (year%4 == 0 && year%100 != 0 || year%400 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
