package calculator.model


class Calculator() {

  var lhs: Double = 0.0
  var rhs: Double = 0.0
  var leftStr: String = ""
  var rightStr: String = ""
  var result : Double = 0.0
  var displayNum : Double = lhs
  var state: State = new leftSide(this)
  var mode: String = "rad"

  def displayNumber(): Double = {
    this.state.displayNumber()
  }

  def displayMode(): String = {
    this.state.displayMode()
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

  def dividePressed(): Unit = {
    this.state.dividePressed()
  }

  def multiplyPressed(): Unit = {
    this.state.multiplyPressed()
  }

  def subtractPressed(): Unit = {
    this.state.subtractPressed()
  }

  def addPressed(): Unit = {
    this.state.addPressed()
  }

  def equalsPressed(): Unit = {
    this.state.equalsPressed()
  }

  def decimalPressed(): Unit = {
    this.state.decimalPressed()
  }

  def negatePressed(): Unit = {
    this.state.negatePressed()
  }

  def cosPressed(): Unit = {
    this.state.cosPressed()
  }

  def sinPressed(): Unit = {
    this.state.sinPressed()
  }

  def radDegPressed(): Unit = {
    this.state.radDegPressed()
  }

}
