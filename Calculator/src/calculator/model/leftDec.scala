package calculator.model

import scala.math.{cos, sin}

class leftDec(calc: Calculator) extends State(calc) {
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
    calc.state = new leftSide(calc)
  }

  override def numberPressed(number: Int): Unit = {
    calc.leftStr += number.toString
    calc.lhs = calc.leftStr.toDouble

  }

  override def dividePressed(): Unit = {
    calc.rhs = 1.0
    calc.state = new divide(calc)
  }

  override def multiplyPressed(): Unit = {
    calc.rhs = 1.0
    calc.state = new multiply(calc)
  }

  override def subtractPressed(): Unit = {
    calc.state = new subtract(calc)
  }

  override def addPressed(): Unit = {
    calc.state = new add(calc)
  }

  override def equalsPressed(): Unit = {
    println("No operations used. Same double.")
  }

  override def decimalPressed(): Unit = {
    println("Already in use")
  }

  override def radDegPressed(): Unit = {
    calc.mode = "deg"
    calc.state = new leftDecDeg(calc)
  }

  override def negatePressed(): Unit = {
    calc.leftStr = "-" + calc.leftStr
    calc.lhs = calc.leftStr.toDouble
  }

  override def cosPressed(): Unit = {
    calc.lhs = cos(calc.lhs)
    calc.leftStr = calc.lhs.toString
  }

  override def sinPressed(): Unit = {
    calc.lhs = sin(calc.lhs)
    calc.leftStr = calc.lhs.toString
  }
}
