package step1.iksoo.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	private StringAddCalculator cal;

	@BeforeEach
	public void setUp() {
		cal = new StringAddCalculator();
	}

	@Test
	public void add_null_또는_빈문자() throws Exception {
		assertThat(cal.add(null)).isEqualTo(0);
	}

	@Test
	public void add_숫자하나() throws Exception {
		assertThat(cal.add("1")).isEqualTo(1);
	}

	@Test
	public void add_쉼표구분자() throws Exception {
		assertThat(cal.add("1,2")).isEqualTo(3);
	}

	@Test
	public void add_쉼표_또는_콜론_구분자() throws Exception {
		assertThat(cal.add("1,2:3")).isEqualTo(6);
	}

	@Test
	public void add_custom_구분자1() throws Exception {
		assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
	}

	@Test
	public void add_custom_구분자2() throws Exception {
		assertThat(cal.add("//~\n3~4~5")).isEqualTo(12);
	}

	@Test
	public void add_negative() throws Exception {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			cal.add("-1,2,3");
		});
	}

	@Test
	public void add_onlyString() throws Exception {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			cal.add("1,가,3");
		});
	}
}
