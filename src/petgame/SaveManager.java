/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Manages the pet save files including saving, loading and searching.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class SaveManager {

    /**
     * Saves the given pet file or creates a new pet file.
     *
     * @param pet The pet to save.
     * @param isNewPet Boolean representing if creating a new pet.
     * @author Ruben Gueorguiev (19072173)
     */
    public static void save(Pet pet, boolean isNewPet) {
        try {
            String[] petData = pet.getPetData();
            PrintWriter pw;
            if (isNewPet) {
                if (checkFiles(pet.getName())) {
                    int response = JOptionPane.showConfirmDialog(null, "You already have a pet named " + pet.getName() + "\nWould you like to replace it?");
                    if (response != JOptionPane.YES_OPTION) {
                        return;
                    }
                }
            }
            pw = new PrintWriter(new FileOutputStream("pets/" + pet.getName() + ".txt"));
            for (String i : petData) {
                pw.println(i);
            }
            //System.out.println(pet.getName() + " has been saved.");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e);
        }
    }

    /**
     * Loads a pet file corresponding to the given the pet name.
     *
     * @param petName The pet name to load as a string.
     * @param pet The pet object to set the loaded pet file data to.
     * @author Ruben Gueorguiev (19072173)
     */
    public static void load(String petName, Pet pet) {
        String[] petData = new String[8];
        try {
            FileReader fr = new FileReader("pets/" + petName + ".txt");
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                petData[i] = line;
                i++;
            }
            System.out.println("\nPet has been loaded.");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Pet not found. ");
            JOptionPane.showMessageDialog(null, "You have no pets named " + petName + ".", "", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            System.out.println("Error reading Pet file. ");
        }
        pet.setPetData(petData);
    }

    public static boolean delete(String petName) {
        File file = new File("pets/" + petName + ".txt");
        if (file.delete()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if the given pet name is found in the pet folder.
     *
     * @param name The pet name as a string.
     * @return A boolean representing if the pet file is found.
     * @author Ruben Gueorguiev (19072173)
     */
    public static boolean checkFiles(String name) {
        File folder = new File("pets/");
        File[] listOfFiles = folder.listFiles();

        for (File f : listOfFiles) {
            if (f.isFile() && f.getName().equals(name + ".txt")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string of all the pet save files found in the pet folder.
     *
     * @return String representation of pet save files.
     * @author Ruben Gueorguiev (19072173)
     */
    public static Object[] getFiles() {
        File folder = new File("pets/");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> files = new ArrayList<String>();

        for (File f : listOfFiles) {
            if (f.toString().contains(".txt")) {
                files.add("\n" + f.toString().substring(5).replace(".txt", ""));
            }
        }
        return files.toArray();
    }
}
