/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

/**
 * The main game loop which constantly executes pet controls per tick.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class GameLoop extends Thread {

    Pet pet;
    Controller controller;
    int gameSpeed;
    double tickPerSecond;
    double delta;
    long currentTime;
    long lastTime;
    boolean running;
    GameGUI gui;

    /**
     * Initialises the game speed (ticks per second) from a given amount.
     *
     * @param gameSpeed The game speed as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public GameLoop(int gameSpeed, GameGUI gui) {
        this.gameSpeed = gameSpeed;
        this.running = true;
        this.gui = gui;
    }

    public void end() {
        this.running = false;
    }

    /**
     * The game loop, executes an amount of ticks every second.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    @Override
    public void run() {
        while (running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / tickPerSecond;
            lastTime = currentTime;

            if (delta >= 1) {
                tick();
                delta--;
            }
        }
    }

    /**
     * Initialises and starts the game loop.
     *
     * @param pet The pet to use in the game loop.
     * @author Ruben Gueorguiev (19072173)
     */
    public void init(Pet pet) {
        this.pet = pet;
        this.controller = new Controller();
        this.tickPerSecond = 1000000000 / gameSpeed;
        this.delta = 0;
        this.lastTime = System.nanoTime();
        //this.ui = new MainMenu();
    }

    /**
     * Executes every tick, used to increment pet data and saves the game every
     * second.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public void tick() {
        controller.age(pet, 1);
        SaveManager.save(pet, false);
        gui.updatePetInfo();

        if (pet.isAlive() == false) {
            controller.kill(pet);
        }
        if (this.pet.getAge() % 5 == 1) {
            controller.heal(pet);
        }
        if (this.pet.getAge() % 10 == 1) {
            controller.hunger(pet);
        }
        if (this.pet.getAge() % 20 == 1) {
            controller.sadden(pet);
        }
        if (this.pet.getAge() % 25 == 1) {
            controller.poop(pet, gui);
        }
        if (this.pet.getAge() % 2 == 1) {
            gui.returnToIdle();
        }
    }
}
