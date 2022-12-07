package calculator.model

import scala.math.{cos, sin}

class addDec(calc: Calculator) extends State(calc) {
  override def displayNumber(): Double = {
    calc.displayNum
  }

  override def displayMode(): String = {
    calc.mode
  }

  override def clearPressed(): Unit = {
    calc.lhs = 0.0
    calc.leftStr = ""
    calc.rhs = 0.0
    calc.rightStr = ""
    calc.displayNum = calc.lhs
    calc.state = new leftSide(calc)
  }

  override def numberPressed(number: Int): Unit = {
    calc.rightStr += number.toString
    calc.rhs = calc.rightStr.toDouble
    calc.displayNum = calc.rhs
  }

  override def dividePressed(): Unit = {
    calc.lhs += calc.rhs
    calc.leftStr = ""
    calc.rhs = 1.0
    calc.rightStr = ""
    calc.state = new divide(calc)
  }

  override def multiplyPressed(): Unit = {
    calc.lhs += calc.rhs
    calc.leftStr = ""
    calc.rhs = 1.0
    calc.rightStr = ""
    calc.state = new multiply(calc)
  }

  override def subtractPressed(): Unit = {
    calc.lhs += calc.rhs
    calc.leftStr = ""
    calc.rhs = 0.0
    calc.rightStr = ""
    calc.state = new subtract(calc)
  }

  override def addPressed(): Unit = {
    calc.lhs += calc.rhs
    calc.leftStr = ""
    calc.rhs = 0.0
    calc.rightStr = ""
    calc.state = new add(calc)
  }

  override def equalsPressed(): Unit = {
    calc.result = calc.lhs + calc.rhs
    calc.lhs = calc.result
    calc.leftStr = ""
    calc.rhs = 0.0
    calc.rightStr = ""
    calc.state = new leftSide(calc)
  }

  override def decimalPressed(): Unit = {
    println("Already in use")
  }

  override def radDegPressed(): Unit = {
    calc.mode = "deg"
    calc.state = new addDecDeg(calc)
  }

  override def negatePressed(): Unit = {
    calc.rightStr = "-" + calc.rightStr
    calc.rhs = calc.rightStr.toDouble
    calc.displayNum = calc.rhs
  }

  override def cosPressed(): Unit = {
    calc.rhs = cos(calc.rhs)
    calc.displayNum = calc.rhs
    calc.rightStr = calc.rhs.toString
  }

  override def sinPressed(): Unit = {
    calc.rhs = sin(calc.rhs)
    calc.displayNum = calc.rhs
    calc.rightStr = calc.rhs.toString
  }
}
