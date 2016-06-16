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
	private String generalOperationObject = "";
	private double firstDoubleCalc;
	private double secondDoubleCalc;
	private double firstDoubleDisp;
	private double secondDoubleDisp;
	private boolean ferSec = false;
	private double resultAll = 0;
	private byte i = 0;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

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
		if (resultAll != 0) {
		}
		if (ferSec == false) {
		
			firstDoubleCalc = +Double.valueOf(removeDecimalTrailingZeroes(newText));

			System.out.println("firstDoubleCalc =" + firstDoubleCalc);
		} else if (ferSec == true) {
			secondDoubleCalc = +Double.parseDouble(removeDecimalTrailingZeroes(newText));

			System.out.println("secondDoubleCalc =" + secondDoubleCalc);
		}
		txtDisplay.setText(newText);
		
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
			generalOperationObject = "";
			ferSec = false;
			resultAll = 0;
			if (txtDisplay.getLength() < 8) {
				sizeTextFilt();
			}
			break;
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
			if (i == 0) {
				if (resultAll != 0) {
					txtDisplay2.setText(generalOperationObject);
				}
				{
					txtDisplay2.setText(txtDisplay.getText());
				}
				if (generalOperationObject != "+/-") {
					if (ferSec = true & resultAll == 0) {
						firstDoubleDisp = firstDoubleCalc;
						System.out.println("firstDoubleDisp =" + firstDoubleDisp);
						txtDisplay.setText("");
						txtDisplay2.setText(dblFormatNum(firstDoubleDisp) + generalOperationObject);
						decimalClick = 0;
						System.out.println("firstDoubleDisp =" + firstDoubleDisp);
						ferSec = true;
						System.out.println("1");

					} else if (ferSec = false & resultAll == 0) {

						System.out.println(secondDoubleCalc);
						secondDoubleDisp = secondDoubleCalc;
						System.out.println("secondDoubleDisp =" + secondDoubleDisp);
						txtDisplay.setText("");
						txtDisplay2.setText(dblFormatNum(secondDoubleDisp) + generalOperationObject);
						decimalClick = 0;
						ferSec = false;
						System.out.println("2");
					} else if (resultAll != 0) {
						System.out.println(resultAll);
						System.out.println("secondDoubleDisp =" + resultAll);
						firstDoubleCalc = resultAll;
						txtDisplay.setText("");
						txtDisplay2.setText(txtDisplay2.getText() + generalOperationObject);
						resultAll = 0;
						decimalClick = 0;
						ferSec = true;
						System.out.println("3");
					}
					i = 1;
					break;
				}
			}
		default:
		}

	}

	@FXML
	private void handlerEqualAction(ActionEvent event) {
		if (String.valueOf(txtDisplay.getText()) == "Ошибка") {
			return;
		}
		sizeTextFilt();
		secondDoubleDisp = 0;
		resultAll = 0;

		double result = 0;

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
			e.printStackTrace();
		}
		System.out.println(generalOperationObject);
		String format = dblFormatNum(result);
		txtDisplay.setText(format);
		System.out.println(format + "format");
		txtDisplay2.setText("(" + dblFormatNum(firstDoubleCalc) + ")" + generalOperationObject + "("
				+ dblFormatNum(secondDoubleCalc) + ")" + " = ");
		if (txtDisplay.getLength() > 8) {
			sizeTextFilt();
		}
		firstDoubleCalc = resultAll;
		decimalClick = 1;
		ferSec = false;
		i = 0;
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

	private void handlerBasicAction(ActionEvent event) {
		sizeTextFilt();
		System.out.println(txtDisplay.getLength());
		
		if (String.valueOf(txtDisplay.getText()).equals(0)) {
			txtDisplay.setText("");
			
		}
		if (ferSec = true & resultAll == 0 ^ generalOperationObject != "") {
			System.out.println(String.valueOf(txtDisplay.getText()));
			firstDoubleCalc = (-1) * firstDoubleCalc;
			firstDoubleDisp = firstDoubleCalc;
			txtDisplay.setText(dblFormatNum(firstDoubleDisp));
		} else if (ferSec = false & resultAll == 0 | generalOperationObject != "") {
			secondDoubleCalc = (-1) * secondDoubleCalc;
			secondDoubleDisp = secondDoubleCalc;
			txtDisplay.setText(dblFormatNum(secondDoubleDisp));
		} else if (resultAll != 0) {
			resultAll = (-1) * resultAll;
			txtDisplay.setText(dblFormatNum(resultAll));
		} else {
			resultAll = 0;
		}
		
	}

	@FXML
	private void handlerSqrtAction(ActionEvent event) {
		double rootP = 0;
		if (!txtDisplay.getText().isEmpty() & !txtDisplay2.getText().isEmpty()) {
			txtDisplay2.setText("√");
			if (resultAll != 0) {
				rootP = resultAll;
			} else if (ferSec = false & resultAll == 0 | generalOperationObject != "") {
				rootP = secondDoubleCalc;
			} else if (ferSec = true & resultAll == 0 ^ generalOperationObject != "") {
				rootP = firstDoubleCalc;
			}

			if (rootP < 0) {
				txtDisplay.setText("Ошибка");
				firstDoubleDisp = 0;
				secondDoubleDisp = 0;
				firstDoubleCalc = 0;
				secondDoubleCalc = 0;
				decimalClick = 0;
				generalOperationObject = "";
				ferSec = false;
				resultAll = 0;
				if (txtDisplay.getLength() < 8) {
					sizeTextFilt();
				}
				return;
			}
			double rootA = Math.sqrt(rootP);
			resultAll = rootA;
			txtDisplay.setText(strFormatNum(rootA));
			txtDisplay2.setText("√" + strFormatNum(rootP));

			if (firstDoubleCalc != 0) {
				secondDoubleCalc = rootA;
				if (firstDoubleDisp != 0) {
					txtDisplay2.setText(
							strFormatNum(firstDoubleDisp) + generalOperationObject + "√" + strFormatNum(rootP));
				} else {
					txtDisplay2.setText("√" + strFormatNum(rootP));
				}
			}
		} else {
			System.out.println("Введите число");
		}
	}

	private static String removeDecimalTrailingZeroes(String s) {
		return s.indexOf(",") < 0 ? s : s.replaceAll(",", ".");
	}

	private String dblFormatNum(double numA) {
		return NumberFormat.getInstance().format(numA);
	}

	private String strFormatNum(double numB) {
		return String.valueOf(NumberFormat.getInstance().format(numB));
	}

	private void sizeTextFilt() {

		if (txtDisplay.getLength() > 9 & txtDisplay.getLength() < 21) {
			txtDisplay.setFont(Font.font("Courier", 20));
		} else if (txtDisplay.getLength() < 9) {
			txtDisplay.setFont(Font.font("Courier", 45));
		} else if (txtDisplay.getLength() > 21) {
			txtDisplay.setFont(Font.font("Courier", 15));
		}
	}

}
