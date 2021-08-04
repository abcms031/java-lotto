package lotto.service;

import java.util.stream.Stream;

public enum Rank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private int countOfMatch;
  private int winningMoney;

  private Rank(int countOfMatch, int winningMoney) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }
  public static Rank matchRank(int countOfMatch) {
    return Stream.of(values())
        .filter(rank -> (rank.countOfMatch == countOfMatch))
        .findFirst()
        .orElse(MISS);
  }

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
    return null;
  }
}
