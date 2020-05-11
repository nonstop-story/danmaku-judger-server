package com.emmmer.gui;

import java.awt.event.*;
import java.awt.*;


class WindowButton extends Frame implements ActionListener {
    private int number;
    private final Label prompt;
    private final TextField inputs;
    private final Button buttonEnter;
    private final Button buttonGetNumber;

    WindowButton(String str) {
        super(str);
        setLayout(new FlowLayout());
        buttonGetNumber = new Button("获得一条弹幕");
        add(buttonGetNumber);
        add(buttonGetNumber);

        prompt = new Label("该弹幕", Label.CENTER);
        prompt.setBackground(Color.cyan);
        inputs = new TextField("0", 10);
        add(prompt);
        add(inputs);

        buttonEnter = new Button("提交");
        add(buttonEnter);

        buttonEnter.addActionListener(this);
        buttonGetNumber.addActionListener(this);
        setBounds(100, 100, 150, 150);
        setVisible(true);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonGetNumber) {
            number = (int) (Math.random() * 100) + 1;
            prompt.setText("");
        } else if (e.getSource() == buttonEnter) {
            int guess = 0;
            try {

            } catch (NumberFormatException event) {
            }
        }
    }
}

public class MainFace {
    public static void main(String[] args) {
        WindowButton win = new WindowButton("窗口");

    }
}