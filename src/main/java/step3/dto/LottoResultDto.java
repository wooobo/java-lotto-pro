package step3.dto;

public class LottoResultDto {
    private final int matchNumber;
    private final int matchCount;
    private final long prize;

    public LottoResultDto(int matchNumber, int matchCount, long prize) {
        this.matchNumber = matchNumber;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}
