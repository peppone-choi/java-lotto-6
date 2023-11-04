package lotto.controller;

import java.util.List;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.WinningList;
import lotto.model.WinningNumber;
import lotto.record.AmountRecord;
import lotto.record.LottoNumberRecord;
import lotto.record.ProfitRate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public List<Lotto> buyLotto(Amount amount) {
        System.out.println();
        List<Lotto> lottos = amount.buyLotto();
        return lottos;
    }

    public List<Lotto> printLotto(List<Lotto> lottos) {
        List<String> lottoList = lottos.stream()
                .map(Lotto::makeLottoNumberString)
                .toList();
        outputView.printLottoList(lottos.size(), lottoList);
        return lottos;
    }

    public WinningList calculateWinning(List<Lotto> lottos) {
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber(), inputView.inputBonusNumber());
        List<LottoNumberRecord> numberRecordList = lottos.stream().map(Lotto::toRecord).toList();
        return new WinningList(numberRecordList, winningNumber);
    }

    public WinningList printWinningList(WinningList winningList) {
        outputView.printWinningList(winningList.printWinningListString());
        return winningList;
    }

    public ProfitRate calculateProfitRate(WinningList winningList, AmountRecord amountRecord) {
        return winningList.calculateProfitRate(amountRecord);
    }

    public void run() {
        Amount amount = new Amount(inputView.inputAmount());
        AmountRecord amountRecord = amount.toRecord();
        List<Lotto> lottos = printLotto(buyLotto(amount));
        WinningList winningList = printWinningList(calculateWinning(lottos));
        ProfitRate profitRate = calculateProfitRate(winningList, amountRecord);
        String printProfitRate = profitRate.printProfitRate();
        outputView.printProfitRate(printProfitRate);
    }

}
