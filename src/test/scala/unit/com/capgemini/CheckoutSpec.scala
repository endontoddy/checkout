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
        "Orange" ::
        "Orange" ::
        "Apple" ::
        Nil
      ) must_=== Right(1.95)
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
  }

}
