/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

/**
 * The main class for the Virtual Pet Game application.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class Main {

    /**
     * Main method which runs the initialisation.
     *
     * @param args The command line arguments.
     * @author Ruben Gueorguiev (19072173)
     */
    public static void main(String[] args) {
        init();
    }

    /**
     * Initialises the pet and the main menu.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public static void init() {
        //Test the program before initialising
        Test test = new Test();
        test.test();

        Pet pet = null;
        MainMenuGUI menu = new MainMenuGUI();
        menu.runMenu();
    }
}
