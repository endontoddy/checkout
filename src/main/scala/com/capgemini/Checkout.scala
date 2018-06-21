package com.capgemini

import com.capgemini.Domain.Result

class Checkout {

  def apply(products: List[String]): Result[BigDecimal] =
    products.foldLeft(Right(0): Result[BigDecimal]) {
      case (totalResult, nextProduct) =>
        for {
          total         <- totalResult
          productPrice  <- getPrice(nextProduct)
        } yield total + productPrice
    }



  private def getPrice(product: String): Result[BigDecimal] =
    product match {
      case "Apple" => Right(0.60)
      case "Orange" => Right(0.25)
      case unknown => Left(s"Product: '$unknown' is unknown")
    }

}
