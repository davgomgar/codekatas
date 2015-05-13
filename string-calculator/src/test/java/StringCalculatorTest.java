import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by david on 13/5/15.
 */
public class StringCalculatorTest {


    @Test
    public void add_returns_zero_for_an_empty_string() {
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void  add_returns_one_when_is_the_only_received_value() {
        assertThat(StringCalculator.add("1")).isEqualTo(1);
    }

    @Test
    public void add_returns_two_when_is_the_only_received_value() {
        assertThat(StringCalculator.add("2")).isEqualTo(2);
    }

    @Test
    public void add_returns_the_sum_of_two_comma_separated_numbers(){
        assertThat(StringCalculator.add("1,2")).isEqualTo(3);
    }

    @Test
    public void add_returns_the_sum_of_any_comma_separated_numbers() {
        assertThat(StringCalculator.add("1,2,3,4,5,6")).isEqualTo(21);
    }

    @Test
    public void add_can_use_line_breaks_as_separator() {
        assertThat(StringCalculator.add("1\n2\n3")).isEqualTo(6);
    }
    @Test
    public void add_can_use_commas_and_line_breaks_as_separator() {
        assertThat(StringCalculator.add("1\n2,3")).isEqualTo(6);
    }
    @Test
    public void add_might_contain_a_line_definining_a_delimiter() {
        assertThat(StringCalculator.add("//&\n1&4&5&10")).isEqualTo(20);
    }

    @Test
    public void add_with_negatives_throw_exceptions() {
        assertThatThrownBy(() -> StringCalculator.add("1,2,-1,-2"))
                    .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("-1,-2");
    }

}