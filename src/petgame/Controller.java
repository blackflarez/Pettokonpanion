/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

import java.util.Random;

/**
 * The main control interface for the pet.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class Controller {

    Random random;

    /**
     * Instantiates the random class.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public Controller() {
        random = new Random();
    }

    /**
     * Feeds the pet by a given amount.
     *
     * @param pet The pet to feed.
     * @param amount The amount to feed the pet.
     * @author Ruben Gueorguiev (19072173)
     */
    public void feed(Pet pet, int amount) {
        pet.setHunger(pet.getHunger() + amount);

        if (pet.getHunger() >= 100) {
            pet.setHunger(100);
        }
    }

    /**
     * Ages the pet by a given amount, and kills the pet when its age exceeds
     * 600,000 seconds.
     *
     * @param pet The pet to age.
     * @param amount The amount to age the pet.
     * @author Ruben Gueorguiev (19072173)
     */
    public void age(Pet pet, int amount) {
        if (pet.getAge() > 600000 && random.nextInt(10) == 1) {
            pet.setAlive(false);
            pet.setReasonForDeath("old age");
        }
        pet.setAge(pet.getAge() + amount);
    }

    /**
     * Hungers the pet by a random amount up to 3, and kills the pet when its
     * hunger reaches 0.
     *
     * @param pet The pet to hunger.
     * @author Ruben Gueorguiev (19072173)
     */
    public void hunger(Pet pet) {
        int amount = random.nextInt(3);
        pet.setHunger(pet.getHunger() - amount);
        if (pet.getHunger() <= 0) {
            pet.setReasonForDeath("starvation");
            pet.setAlive(false);
        }
    }

    /**
     * Heals the pet by 1 depending on the pet's condition.
     *
     * @param pet The pet to hunger.
     * @author Ruben Gueorguiev (19072173)
     */
    public void heal(Pet pet) {
        int amount = 0;
        if (pet.getDroppings() == 0) {
            amount += 1;
            if (pet.getHappiness() > 50) {
                amount += 1;
            }
            if (pet.getHunger() > 50) {
                amount += 1;
            }
        } else {
            amount = -1;
        }

        //System.out.println("Your pet is healing by " + amount);
        pet.setHealth(pet.getHealth() + amount);
    }

    /**
     * Saddens the pet by a random amount up to 2 plus an amount depending on
     * health and hunger, and kills the pet if its sadness reaches 0.
     *
     * @param pet The pet to sadden.
     * @author Ruben Gueorguiev (19072173)
     */
    public void sadden(Pet pet) {
        int amount = random.nextInt(2) + (200 - (pet.getHealth() + pet.getHunger())) / 10;
        pet.setHappiness(pet.getHappiness() - amount);
        if (pet.getHappiness() < amount) {
            pet.setReasonForDeath("sadness");
            pet.setAlive(false);
        }
    }

    /**
     * Makes the pet poop, and kills the pet if its health is too low.
     *
     * @param pet The pet to poop.
     * @author Ruben Gueorguiev (19072173)
     */
    public void poop(Pet pet, GameGUI gui) {
        if (pet.getHealth() < 1) {
            pet.setReasonForDeath("sickness");
            pet.setAlive(false);
        }
        if (pet.getDroppings() >= 1) {
            int amount = 7;
            pet.setHealth(pet.getHealth() - amount);
        }
        if (random.nextInt(2) == 1) {
            pet.setDroppings(pet.getDroppings() + 1);
            gui.setPooped();
        }
    }

    /**
     * Pats the pet which increases the its happiness by 50%.
     *
     * @param pet The pet to pat.
     * @author Ruben Gueorguiev (19072173)
     */
    public void pat(Pet pet) {
        pet.setHappiness(pet.getHappiness() + pet.getHappiness() / 2);

        if (pet.getHappiness() >= 100) {
            pet.setHappiness(100);
        }
    }

    /**
     * Cleans the pet's droppings.
     *
     * @param pet The pet to clean.
     * @author Ruben Gueorguiev (19072173)
     */
    public void clean(Pet pet) {
        pet.setDroppings(0);
    }

    /**
     * Used for when the pet dies, prints the reason for death, and quits the
     * game.
     *
     * @param pet The pet to kill.
     * @author Ruben Gueorguiev (19072173)
     */
    public void kill(Pet pet) {
        System.out.println("\nYour pet has died of " + pet.getReasonForDeath());
        SaveManager.delete(pet.getName());
    }
}
