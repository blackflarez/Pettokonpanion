/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

/**
 * Represents the pet with all its data.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class Pet {

    private Boolean alive;
    private Integer age;
    private Integer hunger;
    private Integer health;
    private Integer happiness;
    private Integer droppings;
    private String name;
    private String reasonForDeath;

    /**
     * Initialises the default pet data.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public Pet() {
        this.alive = true;
        this.age = 0;
        this.hunger = 100;
        this.health = 100;
        this.happiness = 100;
        this.droppings = 0;
        this.name = "No Name";
        this.reasonForDeath = "unknown reasons";
    }

    /**
     * Returns true if the pet is alive or false if it's dead.
     *
     * @return Boolean representing if the pet is alive.
     * @author Ruben Gueorguiev (19072173)
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Set to false to kill the pet.
     *
     * @param alive Boolean representing if the pet is alive.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Returns the pet's age in seconds.
     *
     * @return The pet's age as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns a string of the pet's age rounded to the closest unit.
     *
     * @return The pet's age as a string.
     * @author Ruben Gueorguiev (19072173)
     */
    public String getFullAge() {
        Integer years = (((age / 60) / 60) / 24) / 365;
        Integer days = (((age / 60) / 60) / 24) % 365;
        Integer hours = ((age / 60) / 60) % 24;
        Integer minutes = (age / 60) % 60;
        Integer seconds = age % 60;
        String age;

        if (years > 0) {
            age = years.toString() + " years old";
        } else if (days == 1) {
            age = days.toString() + " day old";
        } else if (days > 1) {
            age = days.toString() + " days old";
        } else if (hours == 1) {
            age = hours.toString() + " hour old";
        } else if (hours > 1) {
            age = hours.toString() + " hours old";
        } else if (minutes == 1) {
            age = minutes.toString() + " minute old";
        } else if (minutes > 1) {
            age = minutes.toString() + " minutes old";
        } else if (seconds > 1) {
            age = seconds.toString() + " seconds old";
        } else {
            age = "Just hatched!";
        }
        return age;
    }

    /**
     * Sets the pet's age in seconds.
     *
     * @param age The pet's age in seconds as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the pet's hunger level as an integer.
     *
     * @return The hunger level as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Sets the pet's hunger level as an integer.
     *
     * @param hunger The hunger level as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    /**
     * Returns the pet's hunger level as an integer.
     *
     * @return The health level as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the pet's health level as an integer.
     *
     * @param health The health level as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the pet's happiness level as an integer.
     *
     * @return The happiness level as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public Integer getHappiness() {
        return happiness;
    }

    /**
     * Sets the pet's happiness level as an integer.
     *
     * @param happiness The happiness level as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    /**
     * Returns the amount of droppings as an integer.
     *
     * @return The amount of droppings as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public Integer getDroppings() {
        return droppings;
    }

    /**
     * Sets the amount of droppings as an integer.
     *
     * @param health The amount of droppings as an integer.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setDroppings(Integer droppings) {
        this.droppings = droppings;
    }

    /**
     * Returns the pet's name as a string.
     *
     * @return The pet's name as a string.
     * @author Ruben Gueorguiev (19072173)
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the pet's name as a string.
     *
     * @param name The pet's name as a string.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the pet's reason for death as a string.
     *
     * @return The reason for death as a string.
     * @author Ruben Gueorguiev (19072173)
     */
    public String getReasonForDeath() {
        return reasonForDeath;
    }

    /**
     * Sets the pet's reason for death as a string.
     *
     * @param reasonForDeath The reason for death as a string.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setReasonForDeath(String reasonForDeath) {
        this.reasonForDeath = reasonForDeath;
    }

    /**
     * Returns the pet's data variables in a string array.
     *
     * @return The pet data as a string array.
     * @author Ruben Gueorguiev (19072173)
     */
    public String[] getPetData() {
        String[] petData = {alive.toString(),
            age.toString(),
            hunger.toString(),
            health.toString(),
            happiness.toString(),
            droppings.toString(),
            name,
            reasonForDeath};
        return petData;
    }

    /**
     * Sets the pet's data variables with a string array.
     *
     * @param petData The pet data as a string array.
     * @author Ruben Gueorguiev (19072173)
     */
    public void setPetData(String[] petData) {
        if (petData[0].equals("false")) {
            this.alive = false;
        }
        this.age = Integer.parseInt(petData[1]);
        this.hunger = Integer.parseInt(petData[2]);
        this.health = Integer.parseInt(petData[3]);
        this.happiness = Integer.parseInt(petData[4]);
        this.droppings = Integer.parseInt(petData[5]);
        this.name = petData[6];
        this.reasonForDeath = petData[7];
    }

    /**
     * Returns a string representation of the pet's data.
     *
     * @return The pet data as a string.
     * @author Ruben Gueorguiev (19072173)
     */
    public String toString() {
        return "\n>Pet name: "
                + this.name
                + "\n>Age: "
                + getFullAge()
                + "\n>Hunger: "
                + this.hunger + "%"
                + "\n>Health: "
                + this.health + "%"
                + "\n>Happiness: "
                + this.happiness + "%"
                + "\n>Droppings: "
                + this.getDroppings();
    }
}
