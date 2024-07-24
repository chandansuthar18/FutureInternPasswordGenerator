package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorUI extends JFrame {
    private JTextField lengthField;
    private JCheckBox uppercaseCheck;
    private JCheckBox lowercaseCheck;
    private JCheckBox numbersCheck;
    private JCheckBox specialCharactersCheck;
    private JTextArea passwordArea;

    public PasswordGeneratorUI() {
        setTitle("Random Password Generator");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Password Length:"));
        lengthField = new JTextField();
        panel.add(lengthField);

        uppercaseCheck = new JCheckBox("Include Uppercase Letters");
        panel.add(uppercaseCheck);
        lowercaseCheck = new JCheckBox("Include Lowercase Letters");
        panel.add(lowercaseCheck);
        numbersCheck = new JCheckBox("Include Numbers");
        panel.add(numbersCheck);
        specialCharactersCheck = new JCheckBox("Include Special Characters");
        panel.add(specialCharactersCheck);

        JButton generateButton = new JButton("Generate Password");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });
        panel.add(generateButton);

        passwordArea = new JTextArea();
        passwordArea.setEditable(false);
        panel.add(passwordArea);

        add(panel, BorderLayout.CENTER);
    }

    private void generatePassword() {
        try {
            int length = Integer.parseInt(lengthField.getText());
            boolean useUppercase = uppercaseCheck.isSelected();
            boolean useLowercase = lowercaseCheck.isSelected();
            boolean useNumbers = numbersCheck.isSelected();
            boolean useSpecialCharacters = specialCharactersCheck.isSelected();

            String password = PasswordGenerator.generatePassword(length, useUppercase, useLowercase, useNumbers, useSpecialCharacters);
            passwordArea.setText(password);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for length", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
