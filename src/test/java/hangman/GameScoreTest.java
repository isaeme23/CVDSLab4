package hangman;


import hangman.model.BonusScore;
import hangman.model.GameModel;
import hangman.model.OriginalScore;
import hangman.model.PowerScore;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import org.junit.Test;
import org.junit.Assert;

/***
 * Clases de equivalencia
 * Original Score:
 * Valido: Score >= 0 && Score <= 100
 * Limite superior: Score > 100
 * Limite inferior Score < 0
 *
 * Bonus Score:
 * Valido: Score >= 0
 * Limite inferior: Score < 0
 * Limite superior: Score puede ser infinito
 *
 * Power Score:
 * Valido: Score >= 0 && Score <= 500
 * Limite superior: Score > 500
 * Limite inferior: Score < 0
 */

public class GameScoreTest {

    @Test
    public void given_OriginalScore_When_GuessIsNotRightAndScore100_Then_Score90(){
        OriginalScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(100);
        int gameScore = score.calculateScore(0, 1, gameModel);
        Assert.assertEquals(90, gameScore);
    }

    @Test
    public void given_OriginalScore_When_GuessIsNotRightAndScore0_Then_Score0(){
        OriginalScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(0, 2, gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_OriginalScore_When_GuessIsRightAndScore80_Then_Score80(){
        OriginalScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(80);
        int gameScore = score.calculateScore(1, 0, gameModel);
        Assert.assertEquals(80, gameScore);
    }

    @Test
    public void given_OriginalScore_When_GuessIsRightAndScore0_Then_Score0(){
        OriginalScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(1, 0, gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_OriginalScore_When_GuessIsRightAndScore100_Then_Score100(){
        OriginalScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(100);
        int gameScore = score.calculateScore(1, 0, gameModel);
        Assert.assertEquals(100, gameScore);
    }

    @Test
    public void given_OriginalScore_When_GuessIncorrectAndScore100_Then_Score90(){
        OriginalScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(100);
        int gameScore = score.calculateScore(0, 90, gameModel);
        Assert.assertEquals(90, gameScore);
    }

    @Test
    public void given_BonusScore_When_GuessIncorrectAndScore0_Then_Score0(){
        BonusScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(0, 1, gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_BonusScore_When_GuessIsRightAndScore0_Then_Score10(){
        BonusScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(1, 0, gameModel);
        Assert.assertEquals(10, gameScore);
    }

    @Test
    public void given_BonusScore_When_GuessIncorrectScore10_Then_Score5(){
        BonusScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(10);
        int gameScore = score.calculateScore(0, 1, gameModel);
        Assert.assertEquals(5, gameScore);
    }

    @Test
    public void given_BonusScore_When_GuessRightAndWrongAndScore0_Then_Score5(){
        BonusScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(1, 1, gameModel);
        Assert.assertEquals(5, gameScore);
    }

    @Test
    public void given_BonusScore_When_GuessRightAndWrongScore10_Then_Score15(){
        BonusScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(10);
        int gameScore = score.calculateScore(1, 1, gameModel);
        Assert.assertEquals(15, gameScore);
    }

    @Test
    public void given_PowerScore_When_GuessIncorrectAndScore0_Then_Score0(){
        PowerScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(0, 1, gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_PowerScore_When_GuessIsRightAndScore0_Then_Score10(){
        PowerScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(1, 0, gameModel);
        Assert.assertEquals(5, gameScore);
    }

    @Test
    public void given_PowerScore_When_GuessIsRightAndScore10_Then_Score2(){
        PowerScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(10);
        int gameScore = score.calculateScore(0, 1, gameModel);
        Assert.assertEquals(2, gameScore);
    }

    @Test
    public void given_PowerScore_When_GuessIsRightAndWrongAndScore0_Then_Score5(){
        PowerScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(1, 1, gameModel);
        Assert.assertEquals(5, gameScore);
    }

    @Test
    public void given_PowerScore_When_GuessIsRightAndWrongAndScore10_Then_Score7(){
        PowerScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(10);
        int gameScore = score.calculateScore(1, 1, gameModel);
        Assert.assertEquals(7, gameScore);
    }

    @Test
    public void given_PowerScore_When_GuessIsRightAndScore500_Then_Score500(){
        PowerScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(500);
        int gameScore = score.calculateScore(1, 0, gameModel);
        Assert.assertEquals(500, gameScore);
    }
}
