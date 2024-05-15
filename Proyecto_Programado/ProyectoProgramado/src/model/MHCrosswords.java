
package model;

/**
 * This class contains the error method to MediumCrossword and HardCrossword
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */
public class MHCrosswords extends Crossword{

    public MHCrosswords(String levelElected, int numberOfCrossword) {
        super(levelElected, numberOfCrossword);
    }

    /**
     * this method search at crossword the words that have errors
     * @return return an int with the amount of the words of the crossword with errors
     */
    @Override
    public String getErrors() {
        int cantidadMalas = 0;
        
        for(int i = 0; i<getCrosswordWords().length; i++){
            if(getCrosswordWords()[i].getWord().equals(getUserWords()[i])==false){
                cantidadMalas++;
            }
        }
        return "Palabras con error: " + cantidadMalas;
    }

    
    
    
}
