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

        local_challenge_radio_btn.setSelected(true);


        make_loot.addActionListener(e -> {
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
        });

        quit.addActionListener(actionEvent -> System.exit(0));
    }

    private void printHoardAtTextArea(TreasureHoard treasure_hoard) {
        textArea1.append("Loot Roll:\n");

        textArea1.append(
                treasure_hoard.getCopperPieces() + "pc " +
                treasure_hoard.getSilverPieces() + "pp " +
                treasure_hoard.getGoldPieces() + "po " +
                treasure_hoard.getPlatinumPieces() + "pp"
        );

        textArea1.append("\n");
        textArea1.append(treasure_hoard.getValuables() + "\n");
        textArea1.append(treasure_hoard.getMagicItems());
        textArea1.append("\n\n");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Loot Generator");

        frame.setPreferredSize(new Dimension(450, 700));
        frame.setContentPane(new HoardGeneratorUI().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
