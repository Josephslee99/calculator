package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFourFunctions extends FunSuite{

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  test("Test Functions"){
    val calculator1 : Calculator = new Calculator()
    val calculator2 : Calculator = new Calculator()
  // case1
    calculator1.numberPressed(5)
    calculator1.multiplyPressed()
    calculator1.numberPressed(4)
    calculator1.equalsPressed()

    assert(equalDoubles(calculator1.displayNumber(), 20.0), calculator1.displayNumber())

  // case 2
    calculator2.numberPressed(3)
    calculator2.addPressed()
    calculator2.numberPressed(4)
    calculator2.decimalPressed()
    calculator2.numberPressed(3)
    calculator2.equalsPressed()

    assert(equalDoubles(calculator2.displayNumber(), 7.3), calculator2.displayNumber())

  }
}
