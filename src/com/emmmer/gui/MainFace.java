package com.emmmer.gui;

import javax.swing.*;

public class MainFace {

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel questionLabel = new JLabel("请判断以下弹幕是否引战");

        questionLabel.setBounds(10, 0, 200, 30);
        panel.add(questionLabel);


        danmakuButton(panel, 0);

        danmakuButton(panel, 100);

        danmakuButton(panel, 200);

        danmakuButton(panel, 300);
    }

    private static void danmakuButton(JPanel panel, int i) {
        JButton confirmButton1 = new JButton("danmakuText");
        confirmButton1.setBounds(i, 80, 100, 100);
        panel.add(confirmButton1);
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