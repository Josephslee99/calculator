package tests

import calculator.model.Calculator
import org.scalatest._

class TestEnterNumbers extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  // Example test case
  test("Enter Numbers Test") {
    val calculator1 : Calculator = new Calculator()
    val calculator2 : Calculator = new Calculator()
    val calculator3 : Calculator = new Calculator()
    val calculator4 : Calculator = new Calculator()
  // case 1
    calculator1.numberPressed(4)
    calculator1.numberPressed(1)
    calculator1.numberPressed(7)

    assert(equalDoubles(calculator1.displayNumber(), 417.0), calculator1.displayNumber())

  // case 2
    calculator2.numberPressed(0)
    calculator2.numberPressed(0)
    calculator2.numberPressed(0)
    calculator2.numberPressed(0)
    calculator2.numberPressed(2)
    calculator2.decimalPressed()
    calculator2.numberPressed(3)
    assert(equalDoubles(calculator2.displayNumber(), 2.3), calculator2.displayNumber())

  // case 3
    calculator3.numberPressed(2)
    calculator3.decimalPressed()
    calculator3.decimalPressed()
    calculator3.numberPressed(3)
    calculator3.decimalPressed()
    calculator3.numberPressed(5)

    assert(equalDoubles(calculator3.displayNumber(), 2.35), calculator3.displayNumber())

  // case 4
    calculator4.decimalPressed()
    calculator4.numberPressed(0)
    calculator4.numberPressed(0)
    calculator4.numberPressed(0)
    calculator4.decimalPressed()
    calculator4.numberPressed(5)

    assert(equalDoubles(calculator4.displayNumber(), 0.0005), calculator4.displayNumber())

  }

}
