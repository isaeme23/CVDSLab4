package hangman.setup.factoryMethod;

import hangman.model.*;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;
import hangman.model.GameScore;
import hangman.model.BonusScore;
import hangman.model.OriginalScore;
import hangman.model.PowerScore;

public class HangmanDefaultFactoryMethod extends HangmanFactoryMethod {
    @Override
    public Language createLanguage() {
        return new English();
    }

    @Override
    public HangmanDictionary createDictionary() {
        return new EnglishDictionaryDataSource();
    }

    @Override
    public HangmanPanel createHangmanPanel() {
        return new HangmanStickmanPanel();
    }

    @Override
    public GameScore createGameScore(){ return new OriginalScore(); }
}