package com.ram.hmrc.calc

import com.ram.hmrc.model.Fruit

object CalculateFruitCost {
  def fullPrice(fruits: List[Fruit]): BigDecimal = fruits.map(_.price).fold(0.0)(_ + _)
}
