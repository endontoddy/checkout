package com.capgemini

import com.capgemini.Domain.Result
import scala.math._

class Checkout {

  def apply(products: List[String]): Result[BigDecimal] = {
    val productsWithQuantities: Map[String, Int] = products.groupBy(x => x).mapValues(_.length)
    productsWithQuantities.foldLeft(Right(0): Result[BigDecimal]) {
      case (totalResult, (nextProduct, quantity)) =>
        for {
          total         <- totalResult
          productPrice  <- getPrice(nextProduct, quantity)
        } yield total + productPrice
    }
  }


  private val applePrice: BigDecimal = 0.60
  private val orangePrice: BigDecimal = 0.25

  private def getPrice(product: String, quantity: Int): Result[BigDecimal] =
    product match {
      case "Apple" => Right(buyOneGetOneFree(quantity, applePrice))
      case "Orange" => Right(orangePrice * quantity)
      case unknown => Left(s"Product: '$unknown' is unknown")
    }

  private def buyOneGetOneFree(quantity: Int, price: BigDecimal): BigDecimal = {
    val bogofQuantity = ceil(quantity.toFloat / 2)
    bogofQuantity * price
  }


}
