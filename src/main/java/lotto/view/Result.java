package lotto.view;

import lotto.model.LottoNumbers;
import lotto.type.Winning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {

    private static final String LOTTO_AMOUNT_MESSAGE = "%s개를 구매했습니다";
    private static final String LOTTO_NUMBER_LIST = "[%s]";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%d원) - %d";
    private static final String MARGIN_MESSAGE = "총 수익율은 %.2f입니다. (%s)";
    private static final String BENEFIT_MESSAGE = "개이득";
    private static final String LOSS_MESSAGE = "손해";
    private static final String NON_VALID_NUMBER_MESSAGE = "유효하지 않은 번호입니다.";
    private static final int MINIMUM_MARGIN = 1;


    public static void printLottoAmount(int amount) {
        System.out.println(String.format(LOTTO_AMOUNT_MESSAGE, amount));
    }

    public static void printLottoNumber(List<Integer> lottoNumber) {
        lottoNumber = lottoNumber.stream().sorted().collect(Collectors.toList());
        System.out.println(String.format(LOTTO_NUMBER_LIST,
                lottoNumber.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))));
    }

    public static void printLottoNumbers(List<LottoNumbers> numbers) {
        for (LottoNumbers number : numbers) {
            printLottoNumber(number.selectedNumber());
        }
    }

    public static void printWinningResult(Map<Winning, Integer> winningCount) {
        for (Winning winning : Winning.values()) {
            printWinning(winningCount, winning);
        }
    }

    private static void printWinning(Map<Winning, Integer> winningCount, Winning winning) {
        int count = 0;
        if (winningCount.containsKey(winning)) {
            count = winningCount.get(winning);
        }
        System.out.println(String.format(WINNING_RESULT_MESSAGE, winning.getCount(), winning.getReward(), count));
    }

    public static void printMargin(double margin) {
        String benefit = BENEFIT_MESSAGE;
        if (margin < MINIMUM_MARGIN) {
            benefit = LOSS_MESSAGE;
        }
        System.out.println(String.format(MARGIN_MESSAGE, margin, benefit));
    }

    public static void notValidNumber() {
        System.out.println(NON_VALID_NUMBER_MESSAGE);
    }
}