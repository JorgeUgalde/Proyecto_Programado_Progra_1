package view;

/**
 * This class contains methods reques information and display information
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */

import javax.swing.JOptionPane;


public class IOManager {
    
    /**
     * This method request to user values type int
     *
     * @param message with the information
     * @return return the number inserted by the user
     */
    public static int requestInt(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }
    
    /**
     * This method request to user values type char
     * @param message with the information
     * @return return the character insert by the user 
     */
    public static char requestChar(String message) {
    	return JOptionPane.showInputDialog(null, message).charAt(0);
    }

    /**
     * This method show  to user the information
     * @param message with the information
     */
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}

