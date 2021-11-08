package step3.domain;

import java.util.ArrayList;
import java.util.List;

import step3.domain.strategy.numbers.NumbersStrategy;

public class LottoNumbersBundle {
    private final List<LottoNumbers> lottoNumbersBundle = new ArrayList<>();

    public LottoNumbersBundle() {
    }

    public LottoNumbersBundle(List<LottoNumbers> lottoNumbersBundle) {
        this.lottoNumbersBundle.addAll(lottoNumbersBundle);
    }

    public void addLottoNumbers(NumbersStrategy numbersStrategy) {
        int[] numbers = numbersStrategy.getNumbers();
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        lottoNumbersBundle.add(lottoNumbers);
    }

    public LottoRanks lottoRanksOf(WinningLotto winningLotto) {
        LottoRanks lottoRanks = new LottoRanks();

        for (LottoNumbers lottoNumbers : lottoNumbersBundle) {
            int matchCount = winningLotto.containCount(lottoNumbers);
            boolean isBonusMatch = winningLotto.bonusMatch(lottoNumbers);
            lottoRanks.matchIncrementCount(matchCount, isBonusMatch);
        }

        return lottoRanks;
    }

    public int size() {
        return lottoNumbersBundle.size();
    }

    public List<LottoNumbers> getLottoNumbersBundle() {
        return lottoNumbersBundle;
    }
}
