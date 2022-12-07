package calculator.model

abstract class State(calc : Calculator) {

  def displayNumber(): Double

  def displayMode(): String

  def clearPressed(): Unit

  def numberPressed(number : Int): Unit

  def dividePressed(): Unit

  def multiplyPressed(): Unit

  def subtractPressed(): Unit

  def addPressed(): Unit

  def equalsPressed(): Unit

  def decimalPressed(): Unit

  def negatePressed(): Unit

  def cosPressed(): Unit

  def sinPressed(): Unit

  def radDegPressed(): Unit
}
