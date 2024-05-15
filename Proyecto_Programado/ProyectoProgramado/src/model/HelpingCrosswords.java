
package model;

/**
 * This interface inherits to EasyCrossword and MediumCrossword, 
 * contains some exclusive methods of easy level and medium level
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */

public interface HelpingCrosswords {
    
    /**
     * This select random word
     * @return return the selected word 
     */
    public Word getRandomWord();
    
    /**
     * This method determinate if a the method help is available
     * @return return true if is available or return false if it isn't
     */
    public boolean isHelpAvailable();
    
    /**
     * This method inert a letter by the help option
     * @return if the help is available it returns a String with the information of the letter of the helped position,
     * if the help isn't available return that there are not more helps available
     */
    public String help();
}
