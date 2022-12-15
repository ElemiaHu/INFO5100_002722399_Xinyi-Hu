package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private Label resultText;
    @FXML
    private Label operator;
    @FXML
    private TextField firstNumber;
    @FXML
    private TextField secondNumber;

    private int operation = 0;

    @FXML
    protected void onCalculateButtonClick() {
        int num1 = 0, num2 = 0;
        num1 = Integer.parseInt(firstNumber.getText());
        num2 = Integer.parseInt(secondNumber.getText());
        int result = 0;
        double divisionResult;
        switch (operation) {
            case 0:
                result = num1 + num2;
                resultText.setText(Integer.toString(result));
                break;
            case 1:
                result = num1 - num2;
                resultText.setText(Integer.toString(result));
                break;
            case 2:
                result = num1 * num2;
                resultText.setText(Integer.toString(result));
                break;
            case 3:
                divisionResult = num1 * 1.0 / (num2 * 1.0);
                resultText.setText(String.format("%.3f",divisionResult));
                break;
        }
    }

    @FXML
    protected void onClearButtonClick() {
        firstNumber.setText("");
        secondNumber.setText("");
        operator.setText("+");
        resultText.setText("");
    }

    @FXML
    protected void onPlus() {
        operator.setText("+");
        operation = 0;
    }
    @FXML
    protected void onMinus() {
        operator.setText("-");
        operation = 1;
    }
    @FXML
    protected void onMultiply() {
        operator.setText("x");
        operation = 2;
    }
    @FXML
    protected void onDivide() {
        operator.setText("÷");
        operation = 3;
    }
}