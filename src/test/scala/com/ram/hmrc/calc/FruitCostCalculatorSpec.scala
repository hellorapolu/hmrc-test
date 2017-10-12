package com.ram.hmrc.calc

import com.ram.hmrc.model.{Apple, Orange}
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FruitCostCalculatorSpec extends FunSuite{

  test("calculate the total fruit cost at full price-no offer") {
    val fruits = Apple() :: Apple() :: Orange() :: Apple() :: Nil

    assert(CalculateFruitCost.fullPrice(fruits) == 2.05)
  }
}
