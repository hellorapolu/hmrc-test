package com.ram.hmrc.model

trait Fruit {
  val name: String
  val price: Double
}
case class Apple(name: String = "Apple", price : Double = 0.60) extends Fruit
case class Orange(name: String = "Orange", price : Double = 0.25) extends Fruit
