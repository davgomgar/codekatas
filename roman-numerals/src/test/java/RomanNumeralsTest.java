import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;
/**
 * Created by david on 4/5/15.
 */
@RunWith(Parameterized.class)
public class RomanNumeralsTest {

    private final String arabic;
    private final String roman;

    @Parameterized.Parameters(name = "{index} ==> {1} = RomanNumerals.of({0})")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"0", ""},
                {"1", "I"},
                {"2", "II"},
                {"4", "IV"},
                {"5", "V"},
                {"9", "IX"},
                {"10", "X"},
                {"40", "XL"},
                {"50", "L"},
                {"90", "XC"},
                {"100", "C"},
                {"400", "CD"},
                {"500", "D"},
                {"900", "CM"},
                {"1000", "M"},
                {"4489", "MMMMCDLXXXIX"}
        });
    }

    public RomanNumeralsTest(final String arabic, final String roman){
        this.arabic = arabic;
        this.roman = roman;
    }



    @Test
    public void test_conversion() {
        assertThat(roman).isEqualTo(RomanNumerals.of(arabic));
    }

}