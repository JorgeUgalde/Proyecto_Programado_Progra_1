
package view;

/**
 * This class contains the logic codification to to display the game
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */ 

import model.Crossword;
import javax.swing.JOptionPane;
import model.EasyCrossword;
import model.HardCrosswords;
import model.MediumCrosswords;

public class UserInterface {

    public UserInterface() {
    }
    

    final int MAX_FAILS = 3;
    int easyCounter = -1;
    int mediumCounter = -1;
    int hardCounter = -1;
    private String levelElected;
    int numCrossword = 0;
    
    /**
     * This method ask to the user the level, and show the options that have the game
     */
    public void menu() {
        boolean endGame = false;

        IOManager.showMessage("¡Bienvenido al juego del crucigrama!"
                + "\nJuego creado por: \n"
                + "Moisés Sánchez Alvarado\n"
                + "Jorge Ugalde Gamboa\n"
                + "Marlon Zuñiga");
        while (endGame != true) {
            String[] options = {"Instrucciones", "Facil", "Medio", "Dificil", "Salir"};
            int option = JOptionPane.showOptionDialog(null, "Opciones de juego", "Crucigrama", 0, JOptionPane.QUESTION_MESSAGE, null, options, "");

            switch (option) {
                case 0:
                    IOManager.showMessage("1- Solo podra digitar una letra a la vez.\n"
                            + "2- Deberá completar el crucigrama para poder validar el gane\n"
                            + "3- El nivel facil contara con la ayuda para las primeras y ultimas letras de cada palabra.\n"
                            + "4- El nivel medio contara con ayuda para una letra de cada palabra.\n"
                            + "5- Para las ayudas el espacio tiene que estar vacio y las letras puestas por la opción ayuda no se pueden cambiar.\n"
                            + "6- Contará con tres intentos para verificar si gano el juego.\n "
                            + "7- Si llega a los 3 intentos de verificacion y son incorrectos, se finalizará el crucigrama"
                    );
                    break;
                case 1:
                    numCrossword = easyCounter += 1;
                    levelElected = "easy";
                    if (easyCounter == 3) {
                        easyCounter = 0;
                        numCrossword = easyCounter;
                    }

                    level(levelElected);
                    break;

                case 2:
                    numCrossword = mediumCounter += 1;
                    levelElected = "medium";
                    if (mediumCounter == 3) {
                        mediumCounter = 0;
                        numCrossword = mediumCounter;
                    }

                    level(levelElected);
                    break;

                case 3:
                    numCrossword = hardCounter += 1;
                    levelElected = "hard";
                    if (hardCounter == 3) {
                        hardCounter = 0;
                        numCrossword = hardCounter;
                    }

                    level(levelElected);
                    break;

                case 4:
                    IOManager.showMessage("Gracias por utilizar nuestra aplicacion, esperamos que lo hayas disfrutado.");
                    endGame = true;
                    break;
            }//end switch
        }//end while 
    }// end menu

    /**
     * This method has the options for the crossword elected
     * @param levelElected 
     */
    public void level(String levelElected) {

        int tries = 0;
        boolean endLevel = false;
        Crossword creator = null;

        if (levelElected.equals("easy") == true) {
            creator = new EasyCrossword(numCrossword);
        } else if (levelElected.equals("medium") == true) {
            creator = new MediumCrosswords(numCrossword);
        } else if (levelElected.equals("hard") == true) {
            creator = new HardCrosswords(numCrossword);
        }

        creator.infoOfCrosswordDB();

        do {

            String[] s = {"Ayuda", "Pistas", "Insertar", "Gane", "Salir"};
            int option = JOptionPane.showOptionDialog(null, creator.printCrosswordMatrix(), "Crucigrama", 0, JOptionPane.QUESTION_MESSAGE, null, s, "");
            switch (option) {
                case 0:
                    if (creator instanceof EasyCrossword) {
                        EasyCrossword easy = (EasyCrossword) creator;
                        IOManager.showMessage(easy.help());

                    } else if (creator instanceof MediumCrosswords) {
                        MediumCrosswords medium = (MediumCrosswords) creator;
                        IOManager.showMessage(medium.help());

                    } else {
                        IOManager.showMessage("¡No hay ayudas para este nivel!");
                    }
                    break;
                case 1:
                    IOManager.showMessage(creator.clues());
                    break;
                case 2:
                    int r = IOManager.requestInt(creator.printCrosswordMatrix() + "\n\n\nDigite la fila\nNo presionar el boton ( Cancel ) puesto que termina el programa");
                    int c = IOManager.requestInt(creator.printCrosswordMatrix() + "\n\n\nDigite la columna\nNo  presionar el boton (cancel) puesto que termina el programa");
                    char i = IOManager.requestChar(creator.printCrosswordMatrix() + "\n\n\nDigite la letra\nNo  presionar el boton (cancel) puesto que termina el programa");
                    creator.charInsert(r, c, i);
                    break;
                case 3:
                    if (creator.checkFullMatrix() == true) {
                        if (creator.verifyWin() == true) {
                            IOManager.showMessage("Felicidades");
                            break;
                        } else {
                            tries++;
                            if (tries == MAX_FAILS) {
                                IOManager.showMessage("Lo sentimos, ha llegado al intento #" + tries
                                        + ", se finalizara el juego debido a las reglas del mismo\n" + creator.getErrors());
                                tries = 0;
                                endLevel = true;
                                break;
                            } else {
                                IOManager.showMessage("Intento #" + tries + "\n" + creator.getErrors());
                            }
                        }
                    } else {
                        IOManager.showMessage("Parece que no has terminado");
                    }
                    break;
                case 4:
                    endLevel = true;
                    break;
            }

        } while (endLevel == false);

    }
}

