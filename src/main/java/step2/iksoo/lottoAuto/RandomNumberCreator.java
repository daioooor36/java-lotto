package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class RandomNumberCreator {
    private static int START_NUMBER = 1;
    private static int END_NUMBER = 45;

    private static List<Integer> shuffleNum;

    public RandomNumberCreator() {
        insertSequentialNumbers();
        shuffleNumbers();
    }

    private static void insertSequentialNumbers() {
        shuffleNum = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(toCollection(ArrayList::new));
    }

    private void shuffleNumbers() {
        Collections.shuffle(this.shuffleNum);
    }

    public List<Integer> getLotto(int length) {
        return this.shuffleNum.stream()
                .limit(length)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumberCreator that = (RandomNumberCreator) o;
        return Objects.equals(shuffleNum, that.shuffleNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shuffleNum);
    }
}
