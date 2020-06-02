package com.mycompany.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoardGeneratorUI {

    private JPanel Jpanel;

    private JLabel select_hoard_description;
    private JLabel tittle;

    private JRadioButton local_challenge_radio_btn;
    private JRadioButton regional_challenge_radio_btn;
    private JRadioButton national_challenge_radio_btn;
    private JRadioButton world_challenge_radio_btn;

    private JButton make_loot;
    private JButton quit;

    private javax.swing.JScrollPane JScrollPane;
    private JTextArea textArea1;

    public HoardGeneratorUI() {

        ButtonGroup button_group = new ButtonGroup();
        button_group.add(local_challenge_radio_btn);
        button_group.add(regional_challenge_radio_btn);
        button_group.add(national_challenge_radio_btn);
        button_group.add(world_challenge_radio_btn);

        make_loot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // All this logic is temporary since is working as a test for now

                TreasureHoard treasure_hoard;

                if (local_challenge_radio_btn.isSelected()) {
                    treasure_hoard = TreasureHoardManager.build(TreasureHoard.LOCAL_HERO_TIER);
                    printHoardAtTextArea(treasure_hoard);
                }

                else if (regional_challenge_radio_btn.isSelected()) {
                    treasure_hoard = TreasureHoardManager.build(TreasureHoard.REGIONAL_HERO_TIER);
                    printHoardAtTextArea(treasure_hoard);
                }

                else if (national_challenge_radio_btn.isSelected()) {
                    treasure_hoard = TreasureHoardManager.build(TreasureHoard.NATIONAL_HERO_TIER);
                    printHoardAtTextArea(treasure_hoard);
                }

                else if (world_challenge_radio_btn.isSelected()) {
                    treasure_hoard = TreasureHoardManager.build(TreasureHoard.WORLD_HERO_TIER);
                    printHoardAtTextArea(treasure_hoard);
                }

                else
                    JOptionPane.showMessageDialog(null, "You must select one of the game tiers to generate a Treasure Hoard");
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    private void printHoardAtTextArea(TreasureHoard treasure_hoard) {
        textArea1.append("Copper coins: " + treasure_hoard.getCopperPieces() + "\n");
        textArea1.append("Silver coins: " + treasure_hoard.getSilverPieces() + "\n");
        textArea1.append("Gold coins: " + treasure_hoard.getGoldPieces()+ "\n");
        textArea1.append("Platinum coins: " + treasure_hoard.getPlatinumPieces()+ "\n");
        textArea1.append("Valuables: " + treasure_hoard.getValuables() + "\n");
        textArea1.append("----------------------------------\n");
        textArea1.append("Magic  Items: \n" + treasure_hoard.getMagicItems());
        textArea1.append("\n\n");

        System.out.println(treasure_hoard.getCopperPieces() + " cp");
        System.out.println(treasure_hoard.getSilverPieces() + " sp");
        System.out.println(treasure_hoard.getGoldPieces() + " gp");
        System.out.println(treasure_hoard.getPlatinumPieces() + " pp");
        System.out.println(treasure_hoard.getValuables());
        System.out.println(treasure_hoard.getMagicItems());
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Loot Generator");

        frame.setPreferredSize(new Dimension(400, 600));
        frame.setContentPane(new HoardGeneratorUI().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

