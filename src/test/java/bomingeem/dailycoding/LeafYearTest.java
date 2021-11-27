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

    @Test
    public void checkMultipleOfFourTest() {
        //given
        int year = 2012;

        //when
        int result = leafYear.leafYear(year);

        //then
        assertThat(result).isEqualTo(1);
    }

    public static class LeafYear {
        public static int leafYear(int year) {
            if (year%4 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
