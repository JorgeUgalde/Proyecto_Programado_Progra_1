
package model;
/**
 * Abstract class inherits to EasyCrossword, MediumCrossword, HardCrossword and MHCrosswords
 * This class creates the crossword  using the information of the data base class
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */

import CrosswordDataBase.CrosswordDataBase;
import model.Word;


public abstract class Crossword {

    private String levelElected;
    private int numberOfCrossword;
    private String[][] crosswordMatrix;
    private Word[] crosswordWords;
    private String[] userWords;
    private Word[] helpedWords;

    public Crossword(String levelElected, int numberOfCrossword) {
        this.levelElected = levelElected;
        this.numberOfCrossword = numberOfCrossword;
    }

    public String[][] getCrosswordMatrix() {
        return crosswordMatrix;
    }

    public Word[] getCrosswordWords() {
        return crosswordWords;
    }

    public String[] getUserWords() {
        return userWords;
    }

    public Word[] getHelpedWords() {
        return helpedWords;
    }

    public void setHelpedWords(Word[] helpedWords) {
        this.helpedWords = helpedWords;
    }

    /**
     * This method creates the matrix size of the crossword and fill the matrix with (*) sign
     * @param rows: receives the amount of rows of the crossword
     * @param columns: receives the amount of columns of the crossword
     */
    public void createInitialCrosswordMatrix(int rows, int columns) {
        crosswordMatrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                crosswordMatrix[i][j] = "    *  ";
            }
        }
    }
    
    /**
     * This method replace the (*) spaces for the (?) sign sign at the correct positions of the words
     */
    public void setWordsEmptySpacesInMatrix() {
        for (int i = 0; i < crosswordWords.length; i++) {

            Word word = crosswordWords[i];
            int row = word.getStartRow();
            int col = word.getStartColumn();

            if (word.getOrientation() == 'V') {

                for (int j = row; j < (row + word.getWord().length()); j++) {
                    if (j == row) {
                        String firstLetter = " (" + word.getNumberOfWord() + ")? ";
                        crosswordMatrix[row][col] = firstLetter;
                    } else {
                        crosswordMatrix[j][col] = "    ? ";
                    }
                }
            } else {

                for (int j = col; j < (col + word.getWord().length()); j++) {
                    if (j == col) {
                        String firstLetter = "(" + word.getNumberOfWord() + ") ? ";
                        crosswordMatrix[row][col] = firstLetter;
                    } else {
                        crosswordMatrix[row][j] = "    ? ";
                    }
                }
            }
        }
    }
    
    /**
     * This method only print the matrix, it uses a string to show all the matrix
     * @return It returns a String with the matrix
     */
    public String printCrosswordMatrix() {
        String crossword = "";
        for (int i = 0; i < crosswordMatrix.length; i++) {
            for (int j = 0; j < crosswordMatrix[i].length; j++) {
                crossword += crosswordMatrix[i][j];
            }
            crossword += "\n";
        }
        return crossword;
    }

    /**
     * This method gets the data base information of the crossword that it needs and 
     * save all of that information to create the words with the correct information.
     */
    public void infoOfCrosswordDB() {
        CrosswordDataBase crosswordDB = new CrosswordDataBase();
        String crosswordString = crosswordDB.getCrossword(levelElected, numberOfCrossword);
        String[] crosswordInfo = crosswordString.split("\n");
        crosswordWords = new Word[crosswordInfo.length - 1];

        for (int i = 0; i < crosswordInfo.length; i++) {
            if (i == 0) {
                String matrixSize = crosswordInfo[i];
                int rows = Integer.parseInt(matrixSize.split("-")[0]);
                int columns = Integer.parseInt(matrixSize.split("-")[1]);
                createInitialCrosswordMatrix(rows, columns);
                printCrosswordMatrix();

            } else {
                String[] wordInfo = crosswordInfo[i].split("/");
                int initialPosRow = Integer.parseInt(wordInfo[0].split("-")[0]);
                int initialPosColumn = Integer.parseInt(wordInfo[0].split("-")[1]);
                String numberOfWord = wordInfo[1];
                char wordOrientation = wordInfo[2].charAt(0);
                String word = wordInfo[3];
                String clue = wordInfo[4];

                Word wordObj = new Word(word, numberOfWord, initialPosRow, initialPosColumn, wordOrientation, clue);
                crosswordWords[i - 1] = wordObj;
            }
        }

        setWordsEmptySpacesInMatrix();
    }

    /**
     * This method verify if the position can be used to replace with a new character
     * @param row 
     * @param column
     * @return return true if this position was helped or return false if this position wasn't helped
     */
    private boolean isInHelpedWordPosition(int row, int column) {

        for (int i = 0; i < helpedWords.length; i++) {
            Word helpedWord = helpedWords[i];
            if (helpedWord != null && helpedWord.getStartRow() == row && helpedWord.getStartColumn() == column) {
                return true;
            }
        }
        return false;
    }

    /**
     * this method insert the help or user character in a valid position, this position 
     * can be get by the help method or by the user
     * @param row
     * @param column
     * @param charInsert 
     */
    public void charInsert(int row, int column, char charInsert) {
        charInsert = Character.toUpperCase(charInsert);

        if (crosswordMatrix[row][column].contains("*") == false && isInHelpedWordPosition(row, column) == false) {
            String replace = crosswordMatrix[row][column].replace(crosswordMatrix[row][column].charAt(crosswordMatrix[row][column].length() - 2), charInsert);
            crosswordMatrix[row][column] = replace;
        }
    }

    /**
     * This method is the charge to check if the crossword was completely fill  
     * @return return true if the crossword is full or return false if it isn't full
     */
    public boolean checkFullMatrix() {
        for (int i = 0; i < crosswordMatrix.length; i++) {
            for (int j = 0; j < crosswordMatrix[i].length; j++) {
                if (crosswordMatrix[i][j].contains("?") == true) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * This method saves all the words added by the user
     */
    public void userWordsInsert() {
        userWords = new String[crosswordWords.length];
        String userWord = "";

        for (int i = 0; i < crosswordWords.length; i++) {

            int row = crosswordWords[i].getStartRow();
            int col = crosswordWords[i].getStartColumn();

            if (crosswordWords[i].getOrientation() == 'V') {
                for (int r = row; r < (row + crosswordWords[i].getWord().length()); r++) {
                    userWord += crosswordMatrix[r][col].charAt(crosswordMatrix[r][col].length() - 2);
                }
            } else {
                for (int c = col; c < (col + crosswordWords[i].getWord().length()); c++) {
                    userWord += crosswordMatrix[row][c].charAt(crosswordMatrix[row][c].length() - 2);
                }
            }
            userWords[i] = userWord;
            userWord = "";
        }
    }
    
    /**
     * This method compares the original words with the user words  
     * @return if the comparison is exactly equal it returns true, if isn't equal returns false
     */
    private boolean compareWords() {
        userWordsInsert();

        for (int i = 0; i < userWords.length; i++) {
            if (userWords[i].equals(crosswordWords[i].getWord()) == false) {
                return false;

            }
        }
        return true;
    }

    /**
     * this method find the different words added by the user with he original words  
     * @return return the information of the crosswords errors
     */
    public abstract String getErrors();

    /**
     * this method uses the method compareWords() to check if all the words are equals
     * @return return true if the words are equals, else return false 
     */
    public boolean verifyWin() {
        if (compareWords() == false) {
            return false;
        }
        return true;
    }

    /**
     * this method search free spaces in the helpedWords vector 
     * @return if has space it returns an int with the position of the valid space at vector
     */
    public int getIndexOfFreeSpaceInHelpedWords() {
        for (int i = 0; i < helpedWords.length; i++) {
            if (helpedWords[i] == null) {
                return i;
            }
        }
        return 0;
    }

    /**
     * This method gets the words clues to show to the user
     * @return return the clues o the words 
     */
    public String clues() {
        String cluesV = "Pistas de palabras verticales: \n";
        String cluesH = "Pistas de palabras horizontales: \n";
        for (int i = 0; i < crosswordWords.length; i++) {
            if (crosswordWords[i].getOrientation() == 'V') {
                cluesV += crosswordWords[i].getNumberOfWord() + ": " + crosswordWords[i].getClue() + ".\n";
            } else {
                cluesH += crosswordWords[i].getNumberOfWord() + ": " + crosswordWords[i].getClue() + ".\n";
            }
        }
        return printCrosswordMatrix() +  cluesV + "\n" +  cluesH;
    }
    
    
}
