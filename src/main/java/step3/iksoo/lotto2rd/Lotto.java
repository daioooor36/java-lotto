package step3.iksoo.lotto2rd;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private List<Integer> luckyNumbers;

    Lotto() {
        this(new RandomNumberCreator().getLotto(LOTTO_SIZE));
    }

    Lotto(List<Integer> numbers) {
        this.luckyNumbers = solveDuplicated(numbers);
        sortLotto();
    }

    private List<Integer> solveDuplicated(List<Integer> numbers) {
        int nonDuplicatedCount = (int) numbers.stream()
                .distinct()
                .count();

        if (nonDuplicatedCount < LOTTO_SIZE) {
            throw new IllegalArgumentException("숫자가 중복되어 입력되었습니다.");
        }

        return numbers;
    }

    private void sortLotto() {
        Collections.sort(this.luckyNumbers);
    }

    public Rank checkNumberOfMatches(List<Integer> winNumbers, int bonusBall) {
        int countOfMatch = (int) luckyNumbers
                .stream()
                .filter(winNumbers::contains)
                .count();
        return Rank.valueOf(countOfMatch, luckyNumbers.contains(bonusBall));
    }

    public boolean isNumSize(int numSize) {
        return this.luckyNumbers.size() == numSize;
    }

    public List<Integer> getLotto() {
        return this.luckyNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return LOTTO_SIZE == lotto.LOTTO_SIZE &&
                Objects.equals(luckyNumbers, lotto.luckyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO_SIZE, luckyNumbers);
    }
}
