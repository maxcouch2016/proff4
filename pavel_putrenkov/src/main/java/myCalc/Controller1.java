package myCalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller1 implements Initializable {

	@FXML
	private TextField txtDisplay;
	private int decimalClick = 0;
	private String generalOperationObject;
	private double firstDouble;
	private double secondDouble;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	private void handlerGeneralAction(ActionEvent event) {
		
		generalOperationObject = ((Button) event.getSource()).getText();
		
		
		switch (generalOperationObject) {
		case "AC":
			txtDisplay.setText("0");
			firstDouble=0;
			secondDouble=0;
			decimalClick = 0;
			break;
		case "+/-":
			double plusMinus = Double.parseDouble(String.valueOf(txtDisplay.getText()));
			plusMinus = plusMinus * (-1);
			txtDisplay.setText(String.valueOf(plusMinus));
			
			break;
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
			String currentText = txtDisplay.getText();
			try {
			//	System.out.println(currentText);
				firstDouble = Double.parseDouble(currentText);
			//	System.out.println("firstDouble");
			} catch (NumberFormatException e) {
				System.out.println("������� �����dfsdf");
			}

			txtDisplay.setText("");
			decimalClick = 0;
			break;
		default:
		}
	}

	@FXML
	private void handlerDigitAction(ActionEvent event) {
		String digitObject = ((Button) event.getSource()).getText();
		String oldText = txtDisplay.getText();
		if (txtDisplay.getText().equals("0")) {
		oldText ="";
		}
		String newText = oldText + digitObject;
		txtDisplay.setText(newText);
	}

	@FXML
	private void handlerDecimalAction(ActionEvent event) {
		if (decimalClick == 0) {
			String decimalObject = ((Button) event.getSource()).getText();
			String oldText = txtDisplay.getText();	
			String newText = oldText + decimalObject;
			txtDisplay.setText(newText);
			decimalClick = 1;
		}
	}

	@FXML
	private void handlerEqualAction(ActionEvent event) {
		secondDouble = 0;
		double result = 0;
		String secondText = txtDisplay.getText();
		try {
			secondDouble = Double.parseDouble(secondText);
		} catch (NumberFormatException e) {
			System.out.println("������� ��������");
		}
		try {
			switch (generalOperationObject) {
			case "+":
				
				result = firstDouble + secondDouble;
				break;
			case "-":
				result = firstDouble - secondDouble;
				break;
			case "*":
				result = firstDouble * secondDouble;
				break;
			case "/":
				result = firstDouble / secondDouble;
				break;
			default:
			}
		} catch (NullPointerException e) {
			System.out.println("������� �����");
		}
		String format;
	//	format = String.format("%.6f",result);
		format=toCalculatorString(result);
		txtDisplay.setText(format);
	}
	
	


	private static String removeDecimalTrailingZeroes(String s) {
		return s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
	}

	private static String toCalculatorString(double input) {
		return input == (int) input ? Integer.toString((int) input)
				: removeDecimalTrailingZeroes(String.format("%.6f", input));
	}

}
