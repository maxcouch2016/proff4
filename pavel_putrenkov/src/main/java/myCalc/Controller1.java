package myCalc;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Controller1 implements Initializable {

	@FXML
	private TextField txtDisplay;
	@FXML
	private TextField txtDisplay2;
	private int decimalClick = 0;
	private String generalOperationObject = "";
	private double firstDoubleCalc = 0;
	private double secondDoubleCalc = 0;
	private double firstDoubleDisp = 0;
	private double secondDoubleDisp = 0;
	private boolean ferSec = false;
	private double resultAll = 0;
	private byte i = 0;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	private void handlerDigitAction(ActionEvent event) {
		try {
			if (txtDisplay.getLength() > 14) {
				return;
			}
			System.out.println("медот: handlerDigitAction");
			Annimation(event);
			sizeTextFilt();
			System.out.println("txtDisplay=" + txtDisplay.getLength());
			String digitObject = ((Button) event.getSource()).getText();
			String oldText = txtDisplay.getText();

			if (txtDisplay.getText().equals("0")) {
				oldText = "";
			}

			System.out.println("digitObject =" + digitObject);
			String newText = oldText + digitObject;

			System.out.println("newText =" + newText);
			System.out.println("generalOperationObject=" + generalOperationObject);
			if (resultAll != 0) {
			}

			if (ferSec == false) {
				firstDoubleCalc = +Double.valueOf(newText);
				firstDoubleDisp=firstDoubleCalc;
				System.out.println("generalOperationObject =" + generalOperationObject);
				System.out.println("firstDoubleCalc =" + firstDoubleCalc);
				System.out.println("secondDoubleCalc =" + secondDoubleCalc);
			} else if (ferSec == true) {
				secondDoubleCalc = +Double.parseDouble(newText);
				System.out.println("firstDoubleCalc =" + firstDoubleCalc);
				System.out.println("secondDoubleCalc =" + secondDoubleCalc);
				secondDoubleDisp=secondDoubleCalc;
			}

			txtDisplay.setText(newText);
			System.out.println("decimalClick" + decimalClick);
		} catch (NumberFormatException e) {
			AllClean();
			System.out.println("Введите число");
		}
	}

	@FXML
	private void handlerGeneralAction(ActionEvent event) {
		System.out.println("медот: handlerGeneralAction");
		Annimation(event);

		sizeTextFilt();
		generalOperationObject = ((Button) event.getSource()).getText();
		System.out.println(generalOperationObject);
		System.out.println("i=" + i);
		if (i == 1) {
			txtDisplay2.setText(dblFormatNum(firstDoubleCalc) + generalOperationObject);
		}
		switch (generalOperationObject) {
		case "AC":
			AllClean();
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
				txtDisplay2.setText(txtDisplay.getText());

				if (ferSec = true & resultAll == 0) {
					firstDoubleDisp = firstDoubleCalc;
					System.out.println("firstDoubleDisp =" + firstDoubleDisp);
					txtDisplay.setText("");
					txtDisplay2.setText(dblFormatNum(firstDoubleDisp) + generalOperationObject);

					System.out.println("firstDoubleDisp =" + firstDoubleDisp);
					ferSec = true;
					System.out.println("firstDoubleCalc =" + firstDoubleCalc);
					System.out.println("secondDoubleCalc =" + secondDoubleCalc);
					System.out.println("1----");

				} else if (ferSec = false & resultAll == 0) {

					System.out.println(secondDoubleCalc);
					secondDoubleDisp = secondDoubleCalc;
					System.out.println("secondDoubleDisp =" + secondDoubleDisp);
					txtDisplay.setText("");
					System.out.println("firstDoubleCalc =" + firstDoubleCalc);
					System.out.println("secondDoubleCalc =" + secondDoubleCalc);
					txtDisplay2.setText(dblFormatNum(secondDoubleDisp) + generalOperationObject);

					ferSec = false;
					System.out.println("2-------");
				} else if (resultAll != 0) {
					System.out.println(resultAll);
					System.out.println("secondDoubleDisp =" + resultAll);
					firstDoubleCalc = resultAll;
					txtDisplay.setText("");
					txtDisplay2.setText(txtDisplay2.getText() + generalOperationObject);
					resultAll = 0;
					decimalClick = 0;
					System.out.println("decimalClick" + decimalClick);
					ferSec = true;
					System.out.println("firstDoubleCalc =" + firstDoubleCalc);
					System.out.println("secondDoubleCalc =" + secondDoubleCalc);
					System.out.println("3--------");
				}
				i = 1;
				System.out.println("decimalClick" + decimalClick);
				decimalClick = 0;
				break;
			}
		}

	}

	@FXML
	private void handlerEqualAction(ActionEvent event) {
		if (txtDisplay.getLength() > 30) {
			AllClean();
		}
		System.out.println("медот: handlerEqualAction");
		if (firstDoubleCalc == 0 | secondDoubleCalc == 0)
			return;
		Annimation(event);
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

			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		System.out.println(generalOperationObject);
		String format = dblFormatNum(result);

		txtDisplay.setText(format);
		System.out.println("format =" + format);
		txtDisplay2.setText("(" + dblFormatNum(firstDoubleCalc) + ")" + generalOperationObject + "("
				+ dblFormatNum(secondDoubleCalc) + ")" + " = ");
		if (txtDisplay.getLength() > 8) {
			sizeTextFilt();
		}
		firstDoubleCalc = resultAll;

		System.out.println("decimalClick" + decimalClick);
		ferSec = false;
		i = 0;
		// String text = txtDisplay.getText();
		//
		// System.out.println("text=" + text + (char) ' ');
		// txtDisplay.setText(text);
	}

	@FXML
	private void handlerDecimalAction(ActionEvent event) {

		try {
			System.out.println("медот: handlerDecimalAction");
			Annimation(event);

			System.out.println("handlerDecimalAction, decimalClick=" + decimalClick);
			sizeTextFilt();
			String decimalObject = ((Button) event.getSource()).getText();
			String oldText = txtDisplay.getText();
			if (firstDoubleCalc < 0) {
				oldText = String.valueOf(firstDoubleDisp).replaceAll(".0", "");
			}

			oldText = oldText.toString().replaceAll(" ", "");
			System.out.println("oldText= " + oldText);
			if (decimalClick == 0 & Double.parseDouble(txtDisplay.getText()) % 1 == 0) {

				String newText = oldText + decimalObject;
				txtDisplay.setText(newText);
				oldText = "";

				decimalClick = 1;

				if (generalOperationObject != null & secondDoubleDisp != 0 & firstDoubleCalc % 1 == 0) {
					if (resultAll % 1 != 0) {
					}
					secondDoubleDisp = 0;
					txtDisplay2.setText(dblFormatNum(firstDoubleDisp) + generalOperationObject + newText
							+ dblFormatNum(secondDoubleDisp));

					decimalClick = 1;

					System.out.println("decimalClick" + decimalClick);
				} else if (firstDoubleDisp != 0 ^ secondDoubleDisp == 0 & secondDoubleCalc % 1 == 0) {
					secondDoubleDisp = 0;
					if (secondDoubleDisp != 0) {
						txtDisplay2.setText(dblFormatNum(firstDoubleDisp) + newText + dblFormatNum(secondDoubleDisp));
					}
					System.out.println("decimalClick" + decimalClick);
					// secondDoubleCalc = 0;
					if (secondDoubleDisp % 1 == 0)
						decimalClick = 1;

				}
			}
		} catch (NumberFormatException e) {
			System.err.println("ошибка");
			e.printStackTrace();
		}
		if (firstDoubleCalc != 0) {
			ferSec = false;
		}
		if (secondDoubleCalc != 0) {
			ferSec = true;
		}
		System.out.println("generalOperationObject =" + generalOperationObject);
		System.out.println("firstDoubleCalc =" + firstDoubleCalc);
		System.out.println("secondDoubleCalc =" + secondDoubleCalc);

	}

	@FXML

	private void handlerBasicAction(ActionEvent event) {

		System.out.println("медот: handlerBasicAction");
		sizeTextFilt();
		Annimation(event);
		System.out.println(txtDisplay.getLength());

		if (firstDoubleCalc == 0 | generalOperationObject != "" ^ secondDoubleCalc != 0) {
			return;
		}

		if (ferSec = true & resultAll == 0 & secondDoubleCalc == 0) {
			firstDoubleCalc = (-1) * firstDoubleCalc;
			firstDoubleDisp = firstDoubleCalc;

			txtDisplay.setText(dblFormatNum(firstDoubleDisp));
			System.out.println("firstDoubleDisp" + firstDoubleDisp);
			System.out.println("firstDoubleCalc =" + firstDoubleCalc);
			System.out.println("secondDoubleCalc =" + secondDoubleCalc);
		} else if (ferSec = true & resultAll == 0 & firstDoubleCalc != 0) {

			secondDoubleCalc = (-1) * secondDoubleCalc;
			secondDoubleDisp = secondDoubleCalc;
			txtDisplay.setText(dblFormatNum(secondDoubleDisp));

			System.out.println("secondDoubleDisp" + secondDoubleDisp);
			System.out.println("firstDoubleCalc =" + firstDoubleCalc);
			System.out.println("secondDoubleCalc =" + secondDoubleCalc);
		} else if (resultAll != 0) {
			resultAll = (-1) * resultAll;
			txtDisplay.setText(dblFormatNum(resultAll));
			System.out.println("resultAll" + resultAll);
		}
		if (txtDisplay.getLength() > 8) {
			sizeTextFilt();
		}
		System.out.println("generalOperationObject =" + generalOperationObject);

	}

	@FXML
	private void handlerSqrtAction(ActionEvent event) {
		sizeTextFilt();
		Annimation(event);
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

				AllClean();
				txtDisplay.setText("Ошибка");
				if (txtDisplay.getLength() < 8) {
					sizeTextFilt();
				}
				return;
			}
			double rootA = Math.sqrt(rootP);
			resultAll = rootA;
			txtDisplay.setText(dblFormatNum(rootA));
			txtDisplay2.setText("√" + dblFormatNum(rootP));

			if (firstDoubleCalc != 0) {
				secondDoubleCalc = rootA;
				if (firstDoubleDisp != 0 & resultAll != 0) {
					txtDisplay2.setText(
							dblFormatNum(firstDoubleCalc) + generalOperationObject + "√" + dblFormatNum(rootP));
				} else {
					txtDisplay2.setText("√" + dblFormatNum(rootP));
				}
			}
		} else {
			System.out.println("Введите число");
		}
	}

	private void AllClean() {
		firstDoubleDisp = 0;
		secondDoubleDisp = 0;
		firstDoubleCalc = 0;
		secondDoubleCalc = 0;
		decimalClick = 0;
		generalOperationObject = "";
		ferSec = false;
		resultAll = 0;
		i = 0;
		txtDisplay.setText("0");
		txtDisplay2.setText("0");
		System.out.println("i=" + i);
	}


	private String dblFormatNum(double numB) {
	//	String numA = "";
		try {
			String numA=String.valueOf(numB).replaceAll(",", ".");
			Double.parseDouble((NumberFormat.getInstance(Locale.ROOT).format(numA)));

			return (NumberFormat.getInstance(Locale.ROOT).format(numA));
		} catch (Exception e) {

			return String.valueOf(numB);
		}

	}

	private void sizeTextFilt() {

		if (txtDisplay.getLength() > 9 & txtDisplay.getLength() < 21) {
			txtDisplay.setFont(Font.font("Courier", 20));
			txtDisplay2.setFont(Font.font("Courier", 16));
		} else if (txtDisplay.getLength() < 9) {
			txtDisplay.setFont(Font.font("Courier", 45));
			txtDisplay2.setFont(Font.font("Courier", 16));
		} else if (txtDisplay.getLength() > 21) {
			txtDisplay.setFont(Font.font("Courier", 15));
			txtDisplay2.setFont(Font.font("Courier", 13));
		}
	}

	private void Annimation(ActionEvent event) {
		System.out.println("... Annimation ...");
		ScaleTransition st = new ScaleTransition(Duration.millis(150), (Button) event.getSource());
		System.out.println("generalOperationObject =" + generalOperationObject);
		st.setFromX(0.9);
		st.setFromY(0.9);
		st.setToX(1);
		st.setToY(1);
		st.play();
	}
}
