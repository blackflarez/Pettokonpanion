/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * The main menu graphical user interface, takes user input to load a pet, make
 * a new pet, or quit the program.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class MainMenuGUI extends javax.swing.JFrame {

    private Scanner scanner;
    private String input;
    private Controller controller;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadPetButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton newPetButton;
    private javax.swing.JButton quitButton;

    /**
     * Initialises the class.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public MainMenuGUI() {
        this.scanner = new Scanner(System.in);
        this.controller = new Controller();
        this.input = "";
        initComponents();
    }

    /**
     * Initialises the components.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        loadPetButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        newPetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Logo.png"))); // NOI18N

        loadPetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/LoadPet.png"))); // NOI18N

        loadPetButton.setBorderPainted(false);
        loadPetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPetButtonActionPerformed(evt);
            }
        });

        quitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Quit.png"))); // NOI18N

        quitButton.setBorderPainted(false);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        newPetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/NewPet.png"))); // NOI18N

        newPetButton.setBorderPainted(false);
        newPetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(logoLabel)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(newPetButton)
                                                        .addComponent(loadPetButton)
                                                        .addComponent(quitButton))
                                                .addGap(73, 73, 73))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(logoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadPetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newPetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quitButton)
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Loads the game when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void loadPetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Pet pet = new Pet();
        if (SaveManager.getFiles().length > 0) {
            try {
                Object[] files = SaveManager.getFiles();
                input = (String) JOptionPane.showInputDialog(
                        this,
                        "Select the pet you would like to load:",
                        "Load Pet",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        files,
                        "Select");
                input = input.trim();
                if (input != null) {
                    pet.setName(input);
                    SaveManager.load(input, pet);
                    GameGUI gui = new GameGUI();
                    gui.runMenu(pet);
                    gui.setVisible(true);
                    this.setVisible(false);
                }

            } catch (NullPointerException e) {
                System.out.println("\nInvalid file. Going back...\n" + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You have no pets!", "", JOptionPane.PLAIN_MESSAGE);
        }

    }

    /**
     * Quits the game when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("\nQuitting...");
        System.exit(0);
    }

    /**
     * Creates a new pet when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void newPetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Pet pet = new Pet();
        input = JOptionPane.showInputDialog(null, "Enter your pets name.");
        input = input.trim();
        if (input != null) {
            if (input.length() > 2 && input.length() < 10) {
                try {
                    pet.setName(input);
                    SaveManager.save(pet, true);
                    SaveManager.load(input, pet);
                    GameGUI gui = new GameGUI();
                    gui.runMenu(pet);
                    gui.setVisible(true);
                    this.setVisible(false);
                } catch (NullPointerException e) {
                    System.out.println("\nInvalid file. Going back...\n" + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Your pet's name must be between 3 and 10 characters long", "", JOptionPane.PLAIN_MESSAGE);
            }
        }

    }

    /**
     * Runs the main menu GUI.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public void runMenu() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuGUI().setVisible(true);
            }
        });
    }

}
