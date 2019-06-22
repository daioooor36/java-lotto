package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMain {
    private static final int PRICE_OF_LOTTO = 1000;

    public static void main(String[] args) {
        Lottos lottos = new Lottos(buyLotto(lottoOrder()));
    }

    private static int lottoOrder() {
        OutputView.printTextln("구입금액을 입력해 주세요.");
        return InputView.inputNumber() / PRICE_OF_LOTTO;
    }

    private static List<Lotto> buyLotto(int orderCount) {
        List<Lotto> lottoBox = new ArrayList<>();
        IntStream.range(0, orderCount)
                .boxed()
                .forEach(n -> lottoBox.add(new Lotto()));

        OutputView.printTextln(lottoBox.size() + "개를 구매했습니다.");
        return lottoBox;
    }
}
