import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements ActionListener {
    // our instance variables
    private JFrame frame = new JFrame("Calculator");
    private JTextField textField;
    private JPanel mainPanel, buttonPanel;
    private JButton zero, one, two, three, four, five, six, seven, eight, nine;
    private JButton comma, equal, plus, minus, multiply, divide, modulus, negativePositive, AC;
    private String currentNumber = "";
    private String currentOperator = "";

    // in start GUI function i am trying to build the front-end my app
    public void startGUI() {
        // first create mainPanel, buttonPanel and text field
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // set size for textfield and make it uneditable
        textField = new JTextField(26);
        // make it uneditable the text field
        textField.setEditable(false);

        // creating each corresponding button objects
        //for numbers
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        // operations
        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("÷");
        comma = new JButton(",");
        equal = new JButton("=");
        modulus = new JButton("%");
        negativePositive = new JButton("+/-");
        AC = new JButton("AC");
        // add action listener to each button

        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        comma.addActionListener(this);
        equal.addActionListener(this);
        plus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        modulus.addActionListener(this);
        negativePositive.addActionListener(this);
        AC.addActionListener(this);


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


        // buttonPanel to our mainPanel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        // set size and visibility and size
        frame.getContentPane().add(mainPanel);
        frame.setSize(350, 235);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton;
        clickedButton = (JButton) e.getSource();

        String buttonText = clickedButton.getText();

        switch (buttonText) {
            // till i encounter with break my currentNumber is going to merge with pressed buttonText
            // and we are reshowing the current value by setText method of currentNumber
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                currentNumber += buttonText;
                textField.setText(currentNumber);
                break;

            case ",":
                if (!currentNumber.contains(".")) {
                    currentNumber += ".";
                    textField.setText(currentNumber);
                }
                break;
            case "+":
            case "-":
            case "*":
            case "÷":
            case "%":
                handleOperator(buttonText);
                break;
            case "+/-":
                changeSign();
                break;
            case "AC":
                currentNumber = "";
                currentOperator = "";
                textField.setText("");
                break;
            case "=":
                calculateResult();
                break;

        }
    }

    private void changeSign() {
        if (!currentNumber.isEmpty()) {
            double num = Double.parseDouble(currentNumber);
            num = -num;
            currentNumber = String.valueOf(num);
            textField.setText(currentNumber);
        }
    }

    public void handleOperator(String operator) {
        if (!currentNumber.isEmpty()) {
            if (!currentOperator.isEmpty()) {
                calculateResult();
            }
            currentOperator = operator;
            currentNumber = "";
        }
    }

    public void calculateResult() {
        if (!currentNumber.isEmpty() && !currentOperator.isEmpty()) {
            double num1 = Double.parseDouble(textField.getText());
            double num2 = Double.parseDouble(currentNumber);

            switch (currentOperator) {
                case "+":
                    currentNumber = String.valueOf(num1 + num2);
                    break;
                case "-":
                    currentNumber = String.valueOf(num1 - num2);
                    break;
                case "*":
                    currentNumber = String.valueOf(num1 * num2);
                    break;
                case "÷":
                    if (num2 != 0) {
                        currentNumber = String.valueOf(num1 / num2);
                    } else {
                        currentNumber = "Error";
                    }
                    break;
                case "%":
                    currentNumber = String.valueOf(num1 % num2);
                    break;
            }

            textField.setText(currentNumber);
            currentOperator = "";
        }
    }
}