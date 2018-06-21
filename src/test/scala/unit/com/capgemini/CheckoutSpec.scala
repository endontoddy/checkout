package unit.com.capgemini

import com.capgemini.Checkout
import org.specs2.mutable.Specification

class CheckoutSpec extends Specification {

  val checkout = new Checkout

  "Checkout" should {
    "Calculate the total price of a list of valid products" in {
      checkout(
        "Apple" ::
        "Orange" ::
        Nil
      ) must_=== Right(0.85)
    }

    "Return an appropriate error if an unknown product is passed" in {
      checkout(
        "Apple" ::
        "Orange" ::
        "Orange" ::
        "Orange" ::
        "Banana" ::
        Nil
      ) must_=== Left("Product: 'Banana' is unknown")
    }

    "Calculate the total price of a list of valid products, applying a 'Buy one get one free' discount to apples" in {
      checkout(
        "Apple" ::
        "Apple" ::
        "Apple" ::
        "Orange" ::
        Nil
      ) must_=== Right(1.45)
    }

  }

}
