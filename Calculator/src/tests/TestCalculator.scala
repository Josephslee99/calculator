package tests

import calculator.model.Calculator
import org.scalatest._

class TestCalculator extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  test("Tests the missing objs of autolab for the calculator") {
    // Obj1
    val calc1: Calculator = new Calculator
    calc1.numberPressed(6)
    calc1.numberPressed(6)
    calc1.numberPressed(3)
    calc1.decimalPressed()
    calc1.numberPressed(8)
    calc1.numberPressed(9)
    assert(equalDoubles(calc1.displayNumber(), 663.89))
    // Obj2
    val calc2: Calculator = new Calculator
    calc2.numberPressed(4)
    calc2.numberPressed(9)
    calc2.dividePressed()
    calc2.numberPressed(7)
    calc2.equalsPressed()
    assert(equalDoubles(calc2.displayNumber(), 7))
    calc2.subtractPressed()
    calc2.numberPressed(3)
    calc2.decimalPressed()
    calc2.numberPressed(5)
    calc2.equalsPressed()
    assert(equalDoubles(calc2.displayNumber(), 3.5))

    calc1.clearPressed()
    calc2.clearPressed()
    calc1.numberPressed(4)
    calc1.multiplyPressed()
    calc1.numberPressed(9)
    calc1.decimalPressed()
    calc1.numberPressed(6)
    calc1.equalsPressed()
    calc2.numberPressed(9)
    calc2.decimalPressed()
    calc2.numberPressed(6)
    calc2.multiplyPressed()
    calc2.numberPressed(4)
    calc2.equalsPressed()
    assert(equalDoubles(calc1.displayNumber(), calc2.displayNumber()))
    // Obj3

  }
}
