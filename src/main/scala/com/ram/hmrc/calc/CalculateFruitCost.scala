package com.ram.hmrc.calc

import com.ram.hmrc.model.{Apple, Fruit, Orange}
import com.ram.hmrc.offer.OfferOnFruit.Offer

object CalculateFruitCost {
  def fullPrice(fruits: List[Fruit]): BigDecimal = fruits.map(_.price).fold(0.0)(_ + _)
  def apply(fruits: List[Fruit], offers: Seq[Offer]): BigDecimal = applyOffers(fruits, offers).fold(fullPrice(fruits))(identity)
  def applyOffers(fruits: List[Fruit], offers: Seq[Offer]): Option[BigDecimal] = for {
    orange <- offers.find(f => isAnOrange(f._1))
    apple <- offers.find(f => isAnApple(f._1))
  } yield orange._2(oranges(fruits)) + apple._2(apples(fruits))

  def buyOneGetOneFree(fruits: List[Fruit]): BigDecimal = fruits match {
    case Nil                               => 0.0
    case a :+ _ if fruits.length % 2 == 0 => halfPrice(fruits)
    case a :+ _                            => halfPrice(fruits.drop(1)) + fruits.head.price
    case _                                 => fullPrice(fruits)
  }

  def buyThreePayTwo(fruits: List[Fruit]): BigDecimal = if(fruits.isEmpty) 0.0 else threeForThePriceOfTwo(fruits)
  private def threeForThePriceOfTwo(fruits: List[Fruit]): BigDecimal =
    fullPrice(fruits) - fullPrice(fruits.zip (Stream from 1).filter(f => f._2 % 3 == 0).map(_._1))

  private def isAnApple(fruit: Fruit) = fruit.name.equals(Apple().name)
  private def isAnOrange(fruit: Fruit) = fruit.name.equals(Orange().name)
  private def apples(fruits: List[Fruit]) = fruits.filter(isAnApple)
  private def oranges(fruits: List[Fruit]) = fruits.filter(isAnOrange)
  private def halfPrice(fruits: List[Fruit]): BigDecimal = fullPrice(fruits) / 2

}
