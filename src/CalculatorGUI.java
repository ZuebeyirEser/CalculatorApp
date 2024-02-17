import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI{
    private JFrame frame = new JFrame("Calculator");
    private JTextField textField;

    public void startGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        textField = new JTextField(26);
        // make it uneditable the text field
        textField.setEditable(false);

        // creating each corresponding button objects
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton comma = new JButton(",");
        JButton equal = new JButton("=");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("÷");
        JButton modulus = new JButton("%");
        JButton negativePositive = new JButton("+/-");
        JButton AC = new JButton("AC");

        // add the buttons to button panel

        buttonPanel.add(textField);
        buttonPanel.add(AC);
        buttonPanel.add(negativePositive);
        buttonPanel.add(modulus);
        buttonPanel.add(divide);
        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);
        buttonPanel.add(multiply);
        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(minus);
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(plus);
        buttonPanel.add(zero);
        buttonPanel.add(comma);
        buttonPanel.add(equal);


        // add text field to main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);
        frame.setSize(350,235);
        frame.setVisible(true);









    }

}
