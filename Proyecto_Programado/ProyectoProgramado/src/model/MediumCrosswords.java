
package model;

/**
 * This class contains the the logic codification for medium level
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */
public class MediumCrosswords extends MHCrosswords implements HelpingCrosswords {

    public MediumCrosswords(int numberOfCrossword) {
        super("medium", numberOfCrossword);
        setHelpedWords(new Word[14]);
    }

    /**
     * Override method that get a random word, it uses Math.random()
     * @return return a random word 
     */
    @Override
    public Word getRandomWord() {
        int randomNumber = (int) Math.floor(Math.random() * getCrosswordWords().length);
        return getCrosswordWords()[randomNumber];
    }

    /**
     * Override method, this check the position to determinate if the help method is available 
     * @return true if it is available or false if it isn't
     */
    @Override
    public boolean isHelpAvailable() {
        for (int i = 0; i < getCrosswordWords().length; i++) {
            Word word = getCrosswordWords()[i];
            Boolean found = false;
            
            for (int j = 0; j < getHelpedWords().length; j++) {
                Word helpWord = getHelpedWords()[j];
                
                if(helpWord!=null && word.getNumberOfWord() == helpWord.getNumberOfWord()){
                    found = true;
                    j = getHelpedWords().length;
                }
            }
            if(found==false){
                return true;
            }
        }
        return false;
    }

    /**
     * Override method, this is in charge of the logic of help option for the medium game 
     * @return if the help is available it returns a String with the information of the letter of the helped position,
     * if the help isn't available return that there are not more helps available
     */
    @Override
    public String help() {
        
        String helpsLetter = "";

        if (isHelpAvailable() == true) {
            Word word = getRandomWord();
            if (!verifyIfWordHasHelped(word)) {
                
                int row = word.getStartRow();
                int col = word.getStartColumn();
                int randomNumber = (int) Math.floor(Math.random() * word.getWord().length());

                if (word.getOrientation() == 'V') {
                    if (getCrosswordMatrix()[row + randomNumber][col].contains("?")) {
                        
                        charInsert(row + randomNumber, col, word.getWord().charAt(randomNumber));
                        getHelpedWords()[getIndexOfFreeSpaceInHelpedWords()] = new Word(
                                "" + word.getWord().charAt(randomNumber),
                                word.getNumberOfWord(),
                                row + randomNumber,
                                col,
                                word.getOrientation(),
                                word.getClue()
                        );
                    }
                } else {
                    if (getCrosswordMatrix()[row][col + randomNumber].contains("?")) {
                        
                        charInsert(row, col + randomNumber, word.getWord().charAt(randomNumber));
                        getHelpedWords()[getIndexOfFreeSpaceInHelpedWords()] = new Word(
                                "" + word.getWord().charAt(randomNumber),
                                word.getNumberOfWord(),
                                row,
                                col + randomNumber,
                                word.getOrientation(),
                                word.getClue()
                        );
                    }

                }

                
            } else {
                help();
            }

        } else {
            helpsLetter += "No mas ayudas. \n";
        }
        helpsLetter += printCrosswordMatrix() + "Ayudas: \n";

        for (int i = 0; i < getHelpedWords().length; i++) {
            Word helpedWord = getHelpedWords()[i];
            if (helpedWord != null) {
                char letter = helpedWord.getWord().charAt(0);
                String row1 = "" + helpedWord.getStartRow();
                String column = "" + helpedWord.getStartColumn();

                helpsLetter += "Letra '" + letter + "' fila " + row1 + " columna " + column + "\n";
            }
        }

        return helpsLetter;
    }

    /**
     * this method check if the word was provided with the help method 
     * @param word: to search the word at the helpedWords vector
     * @return return true if was helped or false if wasn't helped
     */
    private boolean verifyIfWordHasHelped(Word word) {
        Word[] helped = getHelpedWords();
        for (int i = 0; i < helped.length; i++) {
            Word h = helped[i];

            if (h != null && h.getNumberOfWord() == word.getNumberOfWord()) {
                return true;
            }
        }
        return false;
    }
   
}
