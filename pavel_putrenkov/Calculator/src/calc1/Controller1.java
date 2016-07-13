package calc1;

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
			txtDisplay.setText("");
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
				System.out.println(currentText);
				firstDouble = Double.parseDouble(currentText);
			} catch (NumberFormatException e) {
				System.out.println("¬ведите числоdfsdf");
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
			System.out.println("¬ведите действие");
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
			System.out.println("¬ведите число");
			result=+firstDouble;
			
		}
		String format = String.format("%.1f", result);		
		txtDisplay.setText(format);
	}



}
