package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.enumerate.Message.PLEASE_INPUT_AMOUNT;
import static lotto.enumerate.Message.PLEASE_INPUT_WINNING_NUMBER;

public class InputView {
    public String inputAmount() {
        System.out.println(PLEASE_INPUT_AMOUNT);
        return readLine();
    }

    public String inputWinningNumber() {
        System.out.println(PLEASE_INPUT_WINNING_NUMBER);
        return readLine();
    }

    public String inputBonusNumber() {

    }
}
