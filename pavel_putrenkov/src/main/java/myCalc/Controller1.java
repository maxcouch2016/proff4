package myCalc;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Controller1 implements Initializable {

	@FXML
	private TextField txtDisplay;
	@FXML
	private TextField txtDisplay2;
	private int decimalClick = 0;
	private String generalOperationObject;
	private double firstDoubleCalc;
	private double secondDoubleCalc;
	private double firstDoubleDisp;
	private double secondDoubleDisp;
	private boolean ferSec = false;
	private double resultAll;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	private void handlerGeneralAction(ActionEvent event) {
		sizeTextFilt();
		generalOperationObject = ((Button) event.getSource()).getText();
		System.out.println(generalOperationObject);
		switch (generalOperationObject) {
		case "AC":
			txtDisplay.setText("0");
			txtDisplay2.setText("0");
			firstDoubleDisp = 0;
			secondDoubleDisp = 0;
			firstDoubleCalc = 0;
			secondDoubleCalc = 0;
			decimalClick = 0;
			break;
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":

			String currentText = txtDisplay.getText();
			System.out.println(currentText);
			txtDisplay2.setText(generalOperationObject);
			if (generalOperationObject != "+/-") {
			//	System.out.println(currentText);
				if (ferSec == false ) {
					// firstDoubleCalc =
					// Double.parseDouble(removeDecimalTrailingZeroes(currentText));
					
					firstDoubleDisp = firstDoubleCalc;
					System.out.println("firstDoubleDisp ="+firstDoubleDisp);
					txtDisplay.setText("");
					txtDisplay2.setText(dblFormatNum(firstDoubleDisp) + generalOperationObject);
					decimalClick = 0;
					System.out.println("firstDoubleDisp =" + firstDoubleDisp );
					ferSec = true;
				} else if (resultAll!= 0 ) {
					//secondDoubleCalc = Double.parseDouble(removeDecimalTrailingZeroes(currentText));
					System.out.println(secondDoubleCalc);
					secondDoubleDisp = secondDoubleCalc;
					System.out.println("secondDoubleDisp ="+secondDoubleDisp);
					txtDisplay.setText("");
					txtDisplay2.setText(dblFormatNum(secondDoubleDisp) + generalOperationObject);
					decimalClick = 0;
					ferSec = false;
				} else {
					//resultAll = Double.parseDouble(removeDecimalTrailingZeroes(currentText));
					System.out.println(resultAll);
					System.out.println("secondDoubleDisp ="+resultAll);
					secondDoubleDisp = resultAll;
					txtDisplay.setText("");
					txtDisplay2.setText(dblFormatNum(resultAll) + generalOperationObject);
					decimalClick = 0;
					ferSec = false;
				}
				ferSec = true;
				break;
			}
		default:
		}

	}

	@FXML
	private void handlerDigitAction(ActionEvent event) {
		sizeTextFilt();
		System.out.println(txtDisplay.getLength());
		String digitObject = ((Button) event.getSource()).getText();
		String oldText = txtDisplay.getText();
		if (txtDisplay.getText().equals("0")) {
			oldText = "";
		}
		String newText = oldText + digitObject;
		if (ferSec == false) {
			firstDoubleCalc = +Double.parseDouble(newText);
			System.out.println("firstDoubleCalc ="+firstDoubleCalc);
		} else if (ferSec == true) {
			secondDoubleCalc = +Double.parseDouble(newText);
			System.out.println("firstDoubleCalc ="+firstDoubleCalc);
		} else if (resultAll != 0) {
			resultAll = +Double.parseDouble(newText);
			System.out.println("resultAll ="+resultAll);
		}
		txtDisplay.setText(newText);
		
	}

	@FXML
	private void handlerDecimalAction(ActionEvent event) {
		sizeTextFilt();
		if (decimalClick == 0) {
			String decimalObject = ((Button) event.getSource()).getText();
			String oldText = txtDisplay.getText();
			String newText = oldText + decimalObject;
			txtDisplay.setText(newText);
			if (generalOperationObject != null & firstDoubleDisp != 0 & secondDoubleDisp != 0) {
				secondDoubleDisp = 0;
				txtDisplay2.setText(dblFormatNum(firstDoubleDisp) + generalOperationObject + newText
						+ dblFormatNum(secondDoubleDisp));
			} else if (firstDoubleDisp != 0 & secondDoubleDisp != 0) {
				secondDoubleDisp = 0;
				txtDisplay2.setText(dblFormatNum(firstDoubleDisp) + newText + dblFormatNum(secondDoubleDisp));
				decimalClick = 1;
			}
		}
	}

	@FXML
	private void handlerEqualAction(ActionEvent event) {
		sizeTextFilt();
		secondDoubleDisp = 0;
		resultAll = 0;
		// secondDoubleCalc = 0;
		double result = 0;
		String secondText = txtDisplay.getText();
		secondText = removeDecimalTrailingZeroes(secondText);

		try {
			// secondDoubleCalc = Double.parseDouble(secondText);

		} catch (NumberFormatException e) {
			System.out.println("addNumber" + " чет не");
		}
		try {
			switch (generalOperationObject) {
			case "+":
				result = firstDoubleCalc + secondDoubleCalc;
				resultAll = result;
				break;
			case "-":
				result = firstDoubleCalc - secondDoubleCalc;
				resultAll = result;
				break;
			case "*":
				result = firstDoubleCalc * secondDoubleCalc;
				resultAll = result;
				break;
			case "/":
				result = firstDoubleCalc / secondDoubleCalc;
				resultAll = result;
				break;
			default:
			}
		} catch (NullPointerException e) {
			System.out.println("null");
		}
		String format;
		// format = String.format("%.6f",result);
		// format = toCalculatorString(result);

		format = dblFormatNum(result);

		txtDisplay.setText(format);
		System.out.println(format);
		txtDisplay2.setText("(" + dblFormatNum(firstDoubleCalc).replaceAll(" ", "") + ")" + generalOperationObject + "("
				+ dblFormatNum(secondDoubleCalc).replaceAll(" ", "") + ")" + " = ");

		decimalClick = 1;
		ferSec = true;
		// secondDoubleCalc=0;
	}

	// private static String removeDecimalTrailingZeroes(String s) {
	// return s.indexOf(".") < 0 ? s : s.replaceAll("0*$",
	// "").replaceAll("\\.$", "");
	// }
	private static String removeDecimalTrailingZeroes(String s) {
		return s.indexOf(",") < 0 ? s : s.replaceAll(",", ".");
	}
	//
	// private static String toCalculatorString(double input) {
	// return input == (int) input ? Integer.toString((int) input)
	// : removeDecimalTrailingZeroes(String.format("%.6f", input));
	// }

	@FXML
	private void handlerBasicAction(ActionEvent event) {
		System.out.println(txtDisplay.getLength());
		txtDisplay.setText("-");
		if (String.valueOf(txtDisplay.getText()) == "-") {
			double plusMinus = Double.parseDouble(String.valueOf(txtDisplay.getText()));
			System.out.println(plusMinus);
			plusMinus = (-1) * plusMinus;
			txtDisplay.setText(strFormatNum(plusMinus));
			txtDisplay2.setText(strFormatNum(plusMinus));
		}
	}

	@FXML
	private void handlerSqrtAction(ActionEvent event) {
		if (txtDisplay2.getText() != "") {
			txtDisplay2.setText("√");
			double rootP = Double.parseDouble(String.valueOf(txtDisplay.getText()));
			double rootA = Math.sqrt(rootP);
			resultAll = rootA;
			txtDisplay.setText(strFormatNum(rootA));
			txtDisplay2.setText("√" + strFormatNum(rootP));
		}
	}

	private String dblFormatNum(double numA) {
		return NumberFormat.getInstance().format(numA);
	}

	private String strFormatNum(double numB) {
		return String.valueOf(NumberFormat.getInstance().format(numB));
	}

	private void sizeTextFilt() {
		if (txtDisplay.getLength() > 9) {
			txtDisplay.setFont(Font.font("Courier", 20));
		}

		else if (txtDisplay.getLength() < 9) {
			txtDisplay.setFont(Font.font("Courier", 42));
		}
	}

}
