package com.emmmer.gui;

import javax.swing.*;

public class MainFace {

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel questionLabel = new JLabel("请判断以下弹幕是否引战");

        questionLabel.setBounds(10, 0, 200, 30);
        panel.add(questionLabel);


        JButton confirmButton1 = new JButton("danmakuText");
        confirmButton1.setBounds(0, 80, 100, 100);
        panel.add(confirmButton1);

        JButton confirmButton2 = new JButton("danmakuText");
        confirmButton2.setBounds(100, 80, 100, 100);
        panel.add(confirmButton2);

        JButton confirmButton3 = new JButton("danmakuText");
        confirmButton3.setBounds(200, 80, 100, 100);
        panel.add(confirmButton3);

        JButton confirmButton4 = new JButton("danmakuText");
        confirmButton4.setBounds(300, 80, 100, 100);
        panel.add(confirmButton4);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Judgement");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);
        frame.setVisible(true);
    }


}