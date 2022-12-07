package calculator.model

import scala.math.{cos, sin}

class subtractDeg(calc: Calculator) extends State(calc) {
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
    calc.state = new leftSideDeg(calc)
  }

  override def numberPressed(number: Int): Unit = {
    calc.rightStr += number.toString
    calc.rhs = calc.rightStr.toDouble
    calc.displayNum = calc.rhs
  }

  override def dividePressed(): Unit = {
    calc.lhs -= calc.rhs
    calc.leftStr = ""
    calc.rhs = 1.0
    calc.rightStr = ""
    calc.state = new divideDeg(calc)
  }

  override def multiplyPressed(): Unit = {
    calc.lhs -= calc.rhs
    calc.leftStr = ""
    calc.rhs = 1.0
    calc.rightStr = ""
    calc.state = new multiplyDeg(calc)
  }

  override def subtractPressed(): Unit = {
    calc.lhs -= calc.rhs
    calc.leftStr = ""
    calc.rhs = 0.0
    calc.rightStr = ""
    calc.state = new subtractDeg(calc)
  }

  override def addPressed(): Unit = {
    calc.lhs -= calc.rhs
    calc.leftStr = ""
    calc.rhs = 0.0
    calc.rightStr = ""
    calc.state = new addDeg(calc)
  }

  override def equalsPressed(): Unit = {
    calc.result = calc.lhs - calc.rhs
    calc.lhs = calc.result
    calc.leftStr = ""
    calc.rhs = 0.0
    calc.rightStr = ""
    calc.state = new leftSideDeg(calc)
  }

  override def decimalPressed(): Unit = {
    calc.rightStr += "."
    calc.state = new subtractDecDeg(calc)
  }

  override def radDegPressed(): Unit = {
    calc.mode = "rad"
    calc.state = new subtract(calc)
  }

  override def negatePressed(): Unit = {
    calc.rightStr = "-" + calc.rightStr
    calc.rhs = calc.rightStr.toDouble
    calc.displayNum = calc.rhs
  }

  override def cosPressed(): Unit = {
    calc.rhs = cos(calc.rhs.toRadians)
    calc.displayNum = calc.rhs
    calc.rightStr = calc.rhs.toString
  }

  override def sinPressed(): Unit = {
    calc.rhs = sin(calc.rhs.toRadians)
    calc.displayNum = calc.rhs
    calc.rightStr = calc.rhs.toString
  }
}