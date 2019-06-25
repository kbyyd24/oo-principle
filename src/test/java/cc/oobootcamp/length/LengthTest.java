package cc.oobootcamp.length;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LengthTest {

  @Test
  void should_return_true_when_check_if_first_one_is_larger_given_4_and_2() {
    Length largerLength = new Length(4);
    Length smallerLength = new Length(2);

    boolean isLarger = largerLength.isLargerThan(smallerLength);

    assertThat(isLarger).isTrue();
  }

  @Test
  void should_return_false_when_check_if_first_one_is_larger_given_2_and_4() {
    Length smallerLength = new Length(2);
    Length largerLength = new Length(4);

    boolean isLarger = smallerLength.isLargerThan(largerLength);

    assertThat(isLarger).isFalse();
  }

  @Test
  void should_return_fals_when_check_if_first_one_is_larger_given_3_and_3() {
    Length firstLength = new Length(3);
    Length secondLength = new Length(3);

    boolean isLarger = firstLength.isLargerThan(secondLength);

    assertThat(isLarger).isFalse();
  }
}
