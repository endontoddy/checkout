package com.capgemini

object Domain {
  type Error = String
  type Result[A] = Either[Error, A]
}
