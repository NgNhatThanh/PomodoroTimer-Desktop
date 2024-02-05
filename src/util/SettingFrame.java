package util;

import main.MainFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingFrame extends JFrame implements ActionListener {
    JLabel focusTimeText = new JLabel("Focus time:");
    JLabel sBreakText = new JLabel("Short break:");
    JLabel lBreakText = new JLabel("Long break:");
    JTextField focusTimeTextField = new JTextField(Integer.toString(TimeLabel.getFocusMins()));
    JTextField sBreakTextField = new JTextField(Integer.toString(TimeLabel.getsBreakMins()));
    JTextField lBreakTextField = new JTextField(Integer.toString(TimeLabel.getlBreakMins()));

    JButton saveButton = new JButton("Save");
    public SettingFrame(){
        setResizable(false);
        setLayout(new MigLayout("", "[][]", "[][][][]"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(170, 200);

        focusTimeText.setFont(new Font("Calibri", Font.BOLD, 20));
        sBreakText.setFont(new Font("Calibri", Font.BOLD, 20));
        lBreakText.setFont(new Font("Calibri", Font.BOLD, 20));

        focusTimeTextField.setPreferredSize(new Dimension(50, 25));
        focusTimeTextField.setFont(new Font("Calibri", Font.BOLD, 20));
        sBreakTextField.setPreferredSize(new Dimension(50, 25));
        sBreakTextField.setFont(new Font("Calibri", Font.BOLD, 20));
        lBreakTextField.setPreferredSize(new Dimension(50, 25));
        lBreakTextField.setFont(new Font("Calibri", Font.BOLD, 20));

        add(focusTimeText);
        add(focusTimeTextField, "wrap");
        add(sBreakText);
        add(sBreakTextField, "wrap");
        add(lBreakText);
        add(lBreakTextField, "wrap");
        add(saveButton, "span, center");
        saveButton.addActionListener(this);
    }
    boolean checkInput(String s){
        for(int i = 0; i < s.length(); ++i){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return !s.isEmpty();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveButton){
            if(checkInput(focusTimeTextField.getText()) && checkInput(sBreakTextField.getText())
            && checkInput(lBreakTextField.getText())){
                JOptionPane.showMessageDialog(null, "Saved successful", "", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                MainFrame.label.setSessionTime(Integer.parseInt(focusTimeTextField.getText()), FunctionButton.FOCUS_TAB);
                MainFrame.label.setSessionTime(Integer.parseInt(sBreakTextField.getText()), FunctionButton.SHORTBREAK_TAB);
                MainFrame.label.setSessionTime(Integer.parseInt(lBreakTextField.getText()), FunctionButton.LONGBREAK_TAB);
            }
            else JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
