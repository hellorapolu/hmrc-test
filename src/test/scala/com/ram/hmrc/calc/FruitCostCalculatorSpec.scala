package com.ram.hmrc.calc

import com.ram.hmrc.model.{Apple, Orange}
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import com.ram.hmrc.offer.OfferOnFruit._

@RunWith(classOf[JUnitRunner])
class FruitCostCalculatorSpec extends FunSuite{

  test("calculate the total fruit cost at full price-no offer") {
    val fruits = Apple() :: Apple() :: Orange() :: Apple() :: Nil

    assert(CalculateFruitCost.fullPrice(fruits) == 2.05)
  }

  test("when buy one get one free offer is applied") {
    val apples = Apple() :: Apple() :: Nil

    assert(CalculateFruitCost(apples,offers) == 0.6)
  }

  test("3 for the price of 2 on Oranges applied") {
    val oranges = Orange() :: Orange() :: Orange() :: Nil

    assert(CalculateFruitCost(oranges, offers) == 0.5)
  }

  test("calculate the offer when 4 apples and 1 oranges is bought and total should be 1.45") {
    val apples4Oranges1 = Apple() :: Apple() :: Orange() :: Apple() :: Apple() :: Nil

    assert(CalculateFruitCost(apples4Oranges1, offers) == 1.45)
  }
}
