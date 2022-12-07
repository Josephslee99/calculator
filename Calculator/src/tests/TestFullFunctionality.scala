package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFullFunctionality extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }
  test("Test all functionalities"){
    val calculator1 : Calculator = new Calculator()
    val calculator2 : Calculator = new Calculator()
    val calculator3 : Calculator = new Calculator()
    val calculator4 : Calculator = new Calculator()
  // case 1
    calculator1.numberPressed(3)
    calculator1.multiplyPressed()
    calculator1.addPressed()
    calculator1.numberPressed(4)
    calculator1.equalsPressed()

    assert(equalDoubles(calculator1.displayNumber(), 7.0), calculator1.displayNumber())
    assert(!equalDoubles(calculator1.displayNumber(), 12.0), calculator1.displayNumber())

  // case 2
    calculator2.numberPressed(1)
    calculator2.addPressed()
    calculator2.numberPressed(2)
    calculator2.multiplyPressed()
    calculator2.decimalPressed()
    calculator2.numberPressed(8)
    calculator2.equalsPressed()

    assert(equalDoubles(calculator2.displayNumber(), 2.4), calculator2.displayNumber())
    assert(!equalDoubles(calculator2.displayNumber(), 2.6), calculator2.displayNumber())

  // case 3
    calculator3.numberPressed(1)
    calculator3.addPressed()
    calculator3.numberPressed(1)
    calculator3.equalsPressed()
    calculator3.numberPressed(3)

    assert(equalDoubles(calculator3.displayNumber(), 3.0), calculator3.displayNumber())

  // case 4
    calculator4.numberPressed(1)
    calculator4.addPressed()
    calculator4.numberPressed(1)
    calculator4.clearPressed()
    calculator4.numberPressed(2)
    calculator4.addPressed()
    calculator4.numberPressed(3)
    calculator4.equalsPressed()
    calculator4.addPressed()
    calculator4.numberPressed(4)
    calculator4.equalsPressed()

    assert(equalDoubles(calculator4.displayNumber(), 9.0), calculator4.displayNumber())
  }
}
