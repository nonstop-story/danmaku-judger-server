package com.emmmer.gui;

import javax.swing.*;

public class MainFace {

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel userLabel = new JLabel("请判断以下弹幕是否引战");

        userLabel.setBounds(10, 0, 200, 30);
        panel.add(userLabel);


        JButton confirmButton = new JButton("danmakuText");
        confirmButton.setBounds(10, 80, 80, 25);
        panel.add(confirmButton);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Judgement");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);
        frame.setVisible(true);
    }


}