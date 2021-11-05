package step3.controller;

import step3.domain.Amount;
import step3.domain.LottoService;
import step3.dto.LottoRanksDto;
import step3.dto.WinnerLottoNumbersDto;
import step3.service.LottoServiceImpl;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {
    LottoService lottoService;
    InputView inputView;
    ResultView resultView;

    public LottoController() {
        lottoService = new LottoServiceImpl();
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void play() {
        // 금액을 입력하세요.
        Amount amount = readMoney();

        // 로또 구매 진행
        lottoBuyProcess(amount);

        // 지난 주 우승 번호 입력해주세요.
        WinnerLottoNumbersDto winnerLottoNumbersDto = readWinNumbers();

        // 당첨 통계 출력
        printResult(winnerLottoNumbersDto, amount);
    }

    private Amount readMoney() {
        resultView.amountRequestPrintln();
        int money = inputView.readOnlyNumber();
        return new Amount(money);
    }

    private void lottoBuyProcess(Amount amount) {
        lottoService.buyLotto(amount);

        // 구입된 로또 번호 목록 출력
        resultView.printLottoList(lottoService.lottoList());
    }

    private WinnerLottoNumbersDto readWinNumbers() {
        resultView.winnerRequestPrintln();
        return inputView.getWinnerLottoNumberDto();
    }

    private void printResult(WinnerLottoNumbersDto winnerLottoNumbersDto, Amount amount) {
        LottoRanksDto lottoRanksDto = lottoService.lottoPurchaseDetails(amount, winnerLottoNumbersDto);
        resultView.lottoResultPrint(lottoRanksDto);
    }
}