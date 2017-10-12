package com.ram.hmrc.offer

import com.ram.hmrc.model.{Apple, Fruit, Orange}
import com.ram.hmrc.calc.CalculateFruitCost._

object OfferOnFruit {

  type Offer = (Fruit, (List[Fruit]) => BigDecimal)

  private val appleOffer: Offer = (Apple(), buyOneGetOneFree)
  private val orangeOffer: Offer = (Orange(), buyThreePayTwo)
  val offers: Seq[(Fruit, (List[Fruit]) => BigDecimal)] = Seq(appleOffer, orangeOffer)
}
