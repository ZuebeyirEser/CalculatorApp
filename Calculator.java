import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    // our instance variables
    private JFrame frame = new JFrame("Calculator");
    private JTextField textField;
    private JPanel mainPanel, buttonPanel;
    private JButton zero, one, two, three, four, five, six, seven, eight, nine;
    private JButton comma, equal, plus, minus, multiply, divide, modulus, negativePositive, AC;

    private String currentOperator = "";
    private double num1, num2, result;


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
        divide = new JButton("/");
        comma = new JButton(".");
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
        minus.addActionListener(this);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    // assigned and declared two String array to help override method
    String[] numberButton = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] functionalOperator = {"+","-","*","/",".","=","%","+/-","AC"};

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource(); // Get the button that was clicked
        String buttonText = clickedButton.getText();
        // here i am trying to concat if number clicked without any functional operator

        for (int i = 0; i < 10; i++) {
            if (buttonText.equals(numberButton[i])) {
                textField.setText(textField.getText() + numberButton[i]);
            }
        }
        // also need to consider decimal first if checks if "." clicked check if there is no prior "."
        // if not then concat the textfield with "." operator
        if (buttonText.equals(functionalOperator[4])) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText().concat(functionalOperator[4]));
            }
        }
        // handle + - / * operator. when button clicked my number1 is saved and text field got emptied for num2
        if (buttonText.equals(functionalOperator[0])) {
            num1 = Double.parseDouble(textField.getText());
            currentOperator = functionalOperator[0];
            textField.setText("");
        }
        if (buttonText.equals(functionalOperator[1])) {
            num1 = Double.parseDouble(textField.getText());
            currentOperator = functionalOperator[1];
            textField.setText("");
        }
        if (buttonText.equals(functionalOperator[2])) {
            num1 = Double.parseDouble(textField.getText());
            currentOperator = functionalOperator[2];
            textField.setText("");
        }
        if (buttonText.equals(functionalOperator[3])) {
            num1 = Double.parseDouble(textField.getText());
            currentOperator = functionalOperator[3];
            textField.setText("");
        }
        // num2 will be stored only if we have pressed = in our GUI
        if (buttonText.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            if (currentOperator.equals("+")) {
                result = (num1 + num2);
                textField.setText(String.valueOf(result));
                num1 = result;
            } else if (currentOperator.equals("-")) {
                result = (num1-num2);
                textField.setText(String.valueOf(result));
                num1 = result;
            } else if (currentOperator.equals("*"))
                result = (num1 * num2);
                textField.setText(String.valueOf(result));
                num1 = result;
            } else if (currentOperator.equals("/")) {
                result = (num1 / num2);
                textField.setText(String.valueOf(result));
                num1 = result;
        }
        if (buttonText.equals("%")) {
            num1 = (Double.parseDouble(textField.getText()))/100;
            textField.setText(String.valueOf(num1));
        }

        if (buttonText.equals("+/-")) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(-1 * num1));
        }

        if (buttonText.equals("AC")) {
            currentOperator = "";
            textField.setText("");
        }
    }
}
