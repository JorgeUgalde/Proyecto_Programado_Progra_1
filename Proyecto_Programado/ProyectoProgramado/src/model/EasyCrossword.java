package model;

/**
 * This class contains the logic codification for easy level
 *
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version 11/07/2021
 */
public class EasyCrossword extends Crossword implements HelpingCrosswords {

    public EasyCrossword(int numberOfCrossword) {
        super("easy", numberOfCrossword);
        setHelpedWords(new Word[18]);
    }

    /**
     * Override method that show the errors of the easy crossword
     *
     * @return return the initial letter and position of the wrong word
     */
    @Override
    public String getErrors() {
        String ss = "Palabras con error: \n\n";

        for (int i = 0; i < getCrosswordWords().length; i++) {
            if (getCrosswordWords()[i].getWord().equals(getUserWords()[i]) == false) {
                char letter = getUserWords()[i].charAt(0);
                String row = "" + getCrosswordWords()[i].getStartRow();
                String column = "" + getCrosswordWords()[i].getStartColumn();

                ss += "Letra '" + letter + "' fila " + row + " columna " + column + "\n";
            }
        }
        return ss;
    }

    /**
     * Override method that get a random word, it uses Math.random()
     *
     * @return return a random word
     */
    @Override
    public Word getRandomWord() {
        int randomNumber = (int) Math.floor(Math.random() * getCrosswordWords().length);
        return getCrosswordWords()[randomNumber];
    }

    /**
     * Override method, this is in charge of the logic of help option for the
     * easy game
     *
     * @return if the help is available it returns a String with the information
     * of the letter of the helped position, if the help isn't available return
     * that there are not more helps available
     */
    @Override
    public String help() {
        String help = "";
        Word[] helpedWords = getHelpedWords();

        if (isHelpAvailable()) {

            Word randomWord = getRandomWord();

            int row = randomWord.getStartRow();
            int col = randomWord.getStartColumn();

            if (!verifyIfFirstLetterWasAlreadyProvided(randomWord) && getCrosswordMatrix()[row][col].contains("?")) {

                charInsert(row, col, randomWord.getWord().charAt(0));
                helpedWords[getIndexOfFreeSpaceInHelpedWords()] = new Word(
                        randomWord.getWord().charAt(0) + "",
                        randomWord.getNumberOfWord(),
                        row,
                        col,
                        randomWord.getOrientation(),
                        randomWord.getClue()
                );

            } else if (!verifyIfLastLetterWasAlreadyProvided(randomWord)) {

                if (randomWord.getOrientation() == 'V') {

                    row = row + randomWord.getWord().length() - 1;
                } else {
                    col = col + randomWord.getWord().length() - 1;
                }

                if (getCrosswordMatrix()[row][col].contains("?")) {
                    char letter = randomWord.getWord().charAt(randomWord.getWord().length() - 1);
                    charInsert(row, col, letter);
                    helpedWords[getIndexOfFreeSpaceInHelpedWords()] = new Word(
                            letter + "",
                            randomWord.getNumberOfWord(),
                            row,
                            col,
                            randomWord.getOrientation(),
                            randomWord.getClue()
                    );
                } else {
                    help();
                }
            } else {
                help();
            }
        } else {
            help += "No hay mas ayudas disponibles\n\n";
        }
        help += printCrosswordMatrix() + "Ayudas : \n";

        for (int i = 0; i < getHelpedWords().length; i++) {
            Word helpedWord = getHelpedWords()[i];
            if (helpedWord != null) {
                char letter = helpedWord.getWord().charAt(0);
                String row1 = "" + helpedWord.getStartRow();
                String column = "" + helpedWord.getStartColumn();

                help += "Letra '" + letter + "' fila " + row1 + " columna " + column + "\n";
            }
        }
        return help;
    }

    /**
     * this method check if the first letter was provided with the help method
     *
     * @param word: to search the word at the helpedWords vector at the first
     * letter
     * @return return true if was helped or false if wasn't helped
     */
    private boolean verifyIfFirstLetterWasAlreadyProvided(Word word) {
        Word[] helpedWords = getHelpedWords();
        for (int i = 0; i < helpedWords.length; i++) {
            Word helpedWord = helpedWords[i];
            if (helpedWord != null && word.getWord().charAt(0) == helpedWord.getWord().charAt(0)
                    && word.getStartRow() == helpedWord.getStartRow()
                    && word.getStartColumn() == helpedWord.getStartColumn()) {
                return true;
            }
        }
        return false;
    }

    /**
     * this method check if the last letter was provided with the help method
     *
     * @param word: to search the word at the helpedWords vector at the last
     * letter
     * @return return true if was helped or false if wasn't helped
     */
    private boolean verifyIfLastLetterWasAlreadyProvided(Word word) {
        Word[] helpedWords = getHelpedWords();
        for (int i = 0; i < helpedWords.length; i++) {
            Word helpedWord = helpedWords[i];
            if (helpedWord != null && word.getWord().charAt(word.getWord().length() - 1) == helpedWord.getWord().charAt(0)
                    && word.getStartRow() == helpedWord.getStartRow()
                    && word.getStartColumn() == helpedWord.getStartColumn()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Override method, this check the position to determinate if the help
     * method is available
     *
     * @return true if it is available or false if it isn't
     */
    @Override
    public boolean isHelpAvailable() {
        for (int i = 0; i < getCrosswordWords().length; i++) {

            Word word = getCrosswordWords()[i];
            int row = word.getStartRow();
            int col = word.getStartColumn();

            if (getCrosswordMatrix()[row][col].contains("?")) {
                return true;
            }

            if (word.getOrientation() == 'V') {

                row = row + word.getWord().length() - 1;
            } else {
                col = col + word.getWord().length() - 1;
            }

            if (getCrosswordMatrix()[row][col].contains("?")) {
                return true;
            }
        }
        return false;
    }
}
