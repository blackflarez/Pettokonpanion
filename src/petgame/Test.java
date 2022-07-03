/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

/**
 * Tests some of the program's core functionality for errors.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class Test {

    private int nbErrors = 0;

    /**
     * Tests initialising the pet.
     *
     * @author Ruben Gueorguiev (19072173)
     * @param pet The pet to test.
     */
    public void testInit(Pet pet) {
        pet.setName("TestPet");
        pet.setAge(60);
    }

    /**
     * Tests saving the pet.
     *
     * @author Ruben Gueorguiev (19072173)
     * @param pet The pet to test.
     * @param save The save manager to test.
     */
    public void testSave(Pet pet, SaveManager save) {
        save.save(pet, true);
        if (!save.checkFiles("TestPet")) {
            throw new RuntimeException("File not saved.");
        }
    }

    /**
     * Tests controlling the pet.
     *
     * @author Ruben Gueorguiev (19072173)
     * @param pet The pet to test.
     * @param controller The controller to save.
     */
    public void testController(Pet pet, Controller controller) {
        controller.age(pet, 1000);
        if (pet.getAge() < 999) {
            throw new RuntimeException("Controller not functional.");
        }
    }

    /**
     * Tests deleting the pet.
     *
     * @author Ruben Gueorguiev (19072173)
     * @param save The save manager to test.
     */
    public void testDelete(SaveManager save) {
        boolean test = save.delete("TestPet");
        if (!test) {
            throw new RuntimeException("File not deleted.");
        }
    }

    /**
     * Runs all the tests and prints any errors that occur.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public static void test() {
        Test test = new Test();
        Pet testPet = new Pet();
        Controller testController = new Controller();
        SaveManager testSave = new SaveManager();
        try {
            test.testInit(testPet);
            test.testSave(testPet, testSave);
            test.testController(testPet, testController);
            test.testDelete(testSave);
        } catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0) {
            throw new RuntimeException("There were "
                    + test.nbErrors + " error(s)");
        } else {
            System.out.println("No errors. Test successful.");
        }
    }

}
