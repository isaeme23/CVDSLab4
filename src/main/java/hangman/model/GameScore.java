package hangman.model;

public interface GameScore {
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel);
    public void setScore(int score);
    public int getScore();
}
