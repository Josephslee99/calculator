package calculator.view

import calculator.controller._
import javafx.scene.input.MouseEvent
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.GridPane

object Calculator extends JFXApp {

  val calculatorModel = new calculator.model.Calculator()

  var textField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel;"
    text.value = calculatorModel.displayNumber().toString
  }

  var textField1: TextField = new TextField {
    editable = false
    style = "-fx-font: 15 ariel;"
    text.value = calculatorModel.displayMode()
  }

  stage = new PrimaryStage {
    title = "Calculator"
    scene = new Scene() {
      content = List(
        new GridPane {
          hgap = 0.0
          vgap = 0.0

          add(textField1, 0, 0, 4, 1)
          add(textField, 0, 1, 4, 1)
          add(new CalculatorButton("c", new ClearAction(calculatorModel)), 0, 2)
          add(new CalculatorButton("/", new DivisionAction(calculatorModel)), 1, 2)
          add(new CalculatorButton("*", new MultiplicationAction(calculatorModel)), 2, 2)
          add(new CalculatorButton("-", new SubtractionAction(calculatorModel)), 3, 2)
          add(new CalculatorButton("+/-", new NegateAction(calculatorModel)), 0, 3)
          add(new CalculatorButton("mode", new RadDegAction(calculatorModel)), 1, 3)
          add(new CalculatorButton("cos", new CosAction(calculatorModel)), 2, 3)
          add(new CalculatorButton("sin", new SinAction(calculatorModel)), 3, 3)

          add(new CalculatorButton("+", new AdditionAction(calculatorModel), yScale = 2.0), 3, 4, 1, 2)
          add(new CalculatorButton("=", new EqualAction(calculatorModel), yScale = 2.0), 3, 6, 1, 2)

          add(new CalculatorButton("7", new NumberAction(calculatorModel, 7)), 0, 4)
          add(new CalculatorButton("8", new NumberAction(calculatorModel, 8)), 1, 4)
          add(new CalculatorButton("9", new NumberAction(calculatorModel, 9)), 2, 4)
          add(new CalculatorButton("4", new NumberAction(calculatorModel, 4)), 0, 5)
          add(new CalculatorButton("5", new NumberAction(calculatorModel, 5)), 1, 5)
          add(new CalculatorButton("6", new NumberAction(calculatorModel, 6)), 2, 5)
          add(new CalculatorButton("1", new NumberAction(calculatorModel, 1)), 0, 6)
          add(new CalculatorButton("2", new NumberAction(calculatorModel, 2)), 1, 6)
          add(new CalculatorButton("3", new NumberAction(calculatorModel, 3)), 2, 6)
          add(new CalculatorButton("0", new NumberAction(calculatorModel, 0), xScale = 2.0), 0, 7, 2, 1)

          add(new CalculatorButton(".", new DecimalAction(calculatorModel)), 2, 7)
        }
      )
    }
    addEventFilter(MouseEvent.MOUSE_CLICKED, (event: MouseEvent) => {
      textField.text.value = calculatorModel.displayNumber().toString
      textField1.text.value = calculatorModel.displayMode()

      Math.max(5,6)
    })
  }
}
