package hangman.model;

public class BonusScore implements GameScore {

    private int score;

    public BonusScore(){
        score = 0;
    }

    /**
     * @pre gameScore >= 0, correctCount > 0, incorrectCount >0
     * @pos gameScore >= 0
     * @param correctCount number of times when the guesses have been correct
     * @param incorrectCount number of times when the guesses have been incorrect
     * @param gameModel
     * @return score
     */

    @Override
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel) {
        if (correctCount > gameModel.getCorrectCount()){
            score = gameModel.getScore() + 10;
        }
        if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() >= 5){
            score = gameModel.getScore() - 5;
        }
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void reset(){
        score = 0;
    }
}
