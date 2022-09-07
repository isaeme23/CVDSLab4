package hangman.model;

interface GameScore {
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel);
}
