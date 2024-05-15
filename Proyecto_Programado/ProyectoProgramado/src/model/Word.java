
package model;

/**
 * This class contains the data of the words
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */

public class Word {  
    private String word;
    private String numberOfWord;
    public int startRow;
    public int startColumn;
    public char orientation;
    public String clue;

    public Word(String word, String numberOfWord, int startRow, int startColumn, char orientation, String clue) {
        this.word = word;
        this.numberOfWord = numberOfWord;
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.orientation = orientation;
        this.clue = clue;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNumberOfWord() {
        return numberOfWord;
    }

    public void setNumberOfWord(String numberOfWord) {
        this.numberOfWord = numberOfWord;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }
 
}
