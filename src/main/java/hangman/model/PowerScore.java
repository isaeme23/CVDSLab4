package hangman.model;

public class PowerScore implements GameScore{

     private int score;

    public PowerScore(){
        score = 0;
    }

    /**
     * @pre gameScore >= 0, correctCount > 0, incorrectCount > 0
     * @pos 0 <= gameScore <= 500
     * @param correctCount number of times when the guesses have been correct
     * @param incorrectCount number of times when the guesses have been incorrect
     * @param gameModel
     * @return score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel) {
        if (correctCount > gameModel.getCorrectCount()){
            score = (int)Math.pow(5, correctCount - gameModel.getCorrectCount());
        }
        if (incorrectCount > gameModel.getIncorrectCount()){
            score = gameModel.getScore() - 8;
        }
        if (score > 500){
            score = 500;
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
}
