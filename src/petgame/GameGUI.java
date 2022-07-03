/*
 * Virtual Pet Game by Ruben Gueorguiev (19072173).
 */
package petgame;

import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * The main game-play graphical user interface, takes user input to interact
 * with the pet.
 *
 * @author Ruben Gueorguiev (19072173)
 */
public class GameGUI extends javax.swing.JFrame {

    Scanner scanner;
    Pet pet;
    String input;
    Controller controller;
    String commands;
    GameLoop loop;

    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JToolBar bottomToolBar;
    private javax.swing.JButton cleanButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton feedButton;
    private javax.swing.JProgressBar happinessProgressBar;
    private javax.swing.JProgressBar healthProgressBar;
    private javax.swing.JProgressBar hungerProgressBar;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton patButton;
    private javax.swing.JLabel petAgeLabel;
    private javax.swing.JDialog petDialog;
    private javax.swing.JLabel petLabel;
    private javax.swing.JLabel petNameLabel;
    private javax.swing.JLabel poopLabel;

    /**
     * Initialises the class.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public GameGUI() {
        initComponents();
        this.setVisible(true);
        this.controller = new Controller();
        this.loop = new GameLoop(1, this);
        poopLabel.setVisible(false);

    }

    /**
     * Initialises the components.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void initComponents() {

        petDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        backgroundPanel = new javax.swing.JPanel();
        bottomToolBar = new javax.swing.JToolBar();
        feedButton = new javax.swing.JButton();
        patButton = new javax.swing.JButton();
        cleanButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        exitButton = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        happinessProgressBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        healthProgressBar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        hungerProgressBar = new javax.swing.JProgressBar();
        petAgeLabel = new javax.swing.JLabel();
        petNameLabel = new javax.swing.JLabel();
        petLabel = new javax.swing.JLabel();
        poopLabel = new javax.swing.JLabel();

        petDialog.setAlwaysOnTop(true);

        jLabel1.setText("Select Your Pet");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Select Pet");

        jButton3.setText("Cancel");

        javax.swing.GroupLayout petDialogLayout = new javax.swing.GroupLayout(petDialog.getContentPane());
        petDialog.getContentPane().setLayout(petDialogLayout);
        petDialogLayout.setHorizontalGroup(
                petDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(petDialogLayout.createSequentialGroup()
                                .addGroup(petDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(petDialogLayout.createSequentialGroup()
                                                .addGroup(petDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(petDialogLayout.createSequentialGroup()
                                                                .addGap(119, 119, 119)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(petDialogLayout.createSequentialGroup()
                                                                .addGap(151, 151, 151)
                                                                .addComponent(jLabel1)))
                                                .addGap(0, 114, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, petDialogLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                                .addContainerGap())
        );
        petDialogLayout.setVerticalGroup(
                petDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(petDialogLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(petDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setMaximumSize(new java.awt.Dimension(300, 300));
        backgroundPanel.setMinimumSize(new java.awt.Dimension(300, 300));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(300, 300));

        bottomToolBar.setBackground(new java.awt.Color(255, 255, 204));
        bottomToolBar.setFloatable(false);
        bottomToolBar.setRollover(true);
        bottomToolBar.setBorderPainted(false);

        feedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Feed.png"))); // NOI18N
        feedButton.setToolTipText("Feed pet");
        feedButton.setBorderPainted(false);
        feedButton.setContentAreaFilled(false);
        feedButton.setFocusable(false);
        feedButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        feedButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        feedButton.setMaximumSize(new java.awt.Dimension(57, 65));
        feedButton.setMinimumSize(new java.awt.Dimension(57, 65));
        feedButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        feedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedButtonActionPerformed(evt);
            }
        });
        bottomToolBar.add(feedButton);

        patButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Pat.png"))); // NOI18N
        patButton.setToolTipText("Pat your pet");
        patButton.setBorderPainted(false);
        patButton.setFocusPainted(false);
        patButton.setFocusable(false);
        patButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        patButton.setMaximumSize(new java.awt.Dimension(57, 65));
        patButton.setMinimumSize(new java.awt.Dimension(57, 65));
        patButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        patButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patButtonActionPerformed(evt);
            }
        });
        bottomToolBar.add(patButton);

        cleanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Clean.png"))); // NOI18N
        cleanButton.setToolTipText("Clean droppings");
        cleanButton.setBorderPainted(false);
        cleanButton.setFocusable(false);
        cleanButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cleanButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cleanButton.setMaximumSize(new java.awt.Dimension(57, 65));
        cleanButton.setMinimumSize(new java.awt.Dimension(57, 65));
        cleanButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanButtonActionPerformed(evt);
            }
        });
        bottomToolBar.add(cleanButton);
        bottomToolBar.add(jSeparator1);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Exit.png"))); // NOI18N
        exitButton.setBorderPainted(false);
        exitButton.setFocusable(false);
        exitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exitButton.setMaximumSize(new java.awt.Dimension(43, 65));
        exitButton.setMinimumSize(new java.awt.Dimension(43, 65));
        exitButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        bottomToolBar.add(exitButton);

        menuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Menu.png"))); // NOI18N
        menuButton.setBorderPainted(false);
        menuButton.setFocusable(false);
        menuButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        menuButton.setMaximumSize(new java.awt.Dimension(43, 65));
        menuButton.setMinimumSize(new java.awt.Dimension(43, 65));
        menuButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });
        bottomToolBar.add(menuButton);

        infoPanel.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Hapiness.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Health.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Hunger.png"))); // NOI18N

        petAgeLabel.setFont(new java.awt.Font("Papyrus", 0, 14)); // NOI18N
        petAgeLabel.setText("Age:");
        petAgeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        petNameLabel.setFont(new java.awt.Font("Papyrus", 0, 14)); // NOI18N
        petNameLabel.setText("Name:");
        petNameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(happinessProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(healthProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hungerProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(petAgeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(petNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(petNameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(petAgeLabel))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(happinessProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(healthProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(hungerProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        petLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/PetIdle.png"))); // NOI18N

        poopLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petgame/assets/Poop.png"))); // NOI18N

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bottomToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(poopLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(petLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(petLabel)
                                        .addComponent(poopLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(bottomToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Feeds the pet when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void feedButtonActionPerformed(java.awt.event.ActionEvent evt) {
        controller.feed(this.pet, 5);
        System.out.println("You fed your pet.");
        petLabel.setIcon(new ImageIcon("src/petgame/assets/PetEating.png"));
    }

    /**
     * Exits the game when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("\nQuitting...");
        System.exit(0);
    }

    /**
     * Returns to the main menu when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenuGUI gui = new MainMenuGUI();
        gui.setVisible(true);
        this.setVisible(false);
        loop.end();
    }

    /**
     * Pats the pet when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void patButtonActionPerformed(java.awt.event.ActionEvent evt) {
        controller.pat(this.pet);
        System.out.println("You pat your pet.");
        petLabel.setIcon(new ImageIcon("src/petgame/assets/PetPatting.png"));
    }

    /**
     * Cleans the droppings when the action has been performed.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    private void cleanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        controller.clean(this.pet);
        System.out.println("You clean the droppings.");
        removePoop();
    }

    /**
     * Updates the GUI elements.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public void updatePetInfo() {
        //Draws droppings
        if (this.pet.getDroppings() >= 1) {
            poopLabel.setVisible(true);
        } else {
            poopLabel.setVisible(false);
        }
        //Updates progress bars
        happinessProgressBar.setValue(this.pet.getHappiness());
        healthProgressBar.setValue(this.pet.getHealth());
        hungerProgressBar.setValue(this.pet.getHunger());
        //Updates pet name and age
        petNameLabel.setText("Name: " + this.pet.getName());
        petAgeLabel.setText("Age: " + this.pet.getFullAge());
        //Death message
        if (this.pet.isAlive() == false) {
            petLabel.setIcon(new ImageIcon("src/petgame/assets/PetDead.png"));
            JOptionPane.showMessageDialog(
                    null,
                    "Your pet has died of "
                    + this.pet.getReasonForDeath(),
                    "",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon("src/petgame/assets/DeathIcon.png"));
            MainMenuGUI gui = new MainMenuGUI();
            gui.setVisible(true);
            this.setVisible(false);
            loop.end();
        }
    }

    /**
     * Sets the pet label icon to idle.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public void returnToIdle() {
        petLabel.setIcon(new ImageIcon("src/petgame/assets/PetIdle.png"));
    }

    /**
     * Makes the poop label visible.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public void setPooped() {
        poopLabel.setVisible(true);
    }

    /**
     * Makes the poop label invisible.
     *
     * @author Ruben Gueorguiev (19072173)
     */
    public void removePoop() {
        poopLabel.setVisible(false);
    }

    /**
     * Runs the game GUI.
     *
     * @author Ruben Gueorguiev (19072173)
     * @param pet The pet.
     */
    public void runMenu(Pet pet) {
        this.pet = pet;

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                loop.init(pet);
                loop.start();
            }
        });

    }
}
