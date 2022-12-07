package calculator.model

import scala.math.{cos, sin}

class leftSideDeg(calc: Calculator) extends State(calc) {
  override def displayNumber(): Double = {
    calc.displayNum = calc.lhs
    calc.displayNum
  }

  override def displayMode(): String = {
    calc.mode
  }

  override def clearPressed(): Unit = {
    calc.lhs = 0.0
    calc.leftStr = ""
  }

  override def numberPressed(number: Int): Unit = {
    calc.leftStr += number.toString
    calc.lhs = calc.leftStr.toDouble

  }

  override def dividePressed(): Unit = {
    calc.rhs = 1.0
    calc.state = new divideDeg(calc)
  }

  override def multiplyPressed(): Unit = {
    calc.rhs = 1.0
    calc.state = new multiplyDeg(calc)
  }

  override def subtractPressed(): Unit = {
    calc.state = new subtractDeg(calc)
  }

  override def addPressed(): Unit = {
    calc.state = new addDeg(calc)
  }

  override def equalsPressed(): Unit = {
    println("No operations used. Same double.")
  }

  override def decimalPressed(): Unit = {
    calc.leftStr += "."
    calc.state = new leftDecDeg(calc)
  }

  override def radDegPressed(): Unit = {
    calc.mode = "rad"
    calc.state = new leftSide(calc)
  }

  override def negatePressed(): Unit = {
    calc.leftStr = "-" + calc.leftStr
    calc.lhs = calc.leftStr.toDouble
  }

  override def cosPressed(): Unit = {
    calc.lhs = cos(calc.lhs.toRadians)
    calc.leftStr = calc.lhs.toString
  }

  override def sinPressed(): Unit = {
    calc.lhs = sin(calc.lhs.toRadians)
    calc.leftStr = calc.lhs.toString
  }
}
