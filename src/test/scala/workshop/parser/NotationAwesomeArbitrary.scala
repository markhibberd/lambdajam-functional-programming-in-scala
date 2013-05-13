package workshop
package parser

import org.scalacheck.{Arbitrary, Gen}, Arbitrary._, Gen._

object NotationAwesomeArbitrary {
  implicit def ArbitraryNotationAwesome: Arbitrary[NotationAwesome] = {
    def bool: Gen[NotationAwesome] = arbitrary[Boolean] map {
      case true => AwesomeTrue
      case false => AwesomeFalse
    }

    def string: Gen[NotationAwesome] = arbitrary[String] map AwesomeString

    def totally: Gen[NotationAwesome] =
      for {
        n <- choose(0, 9)
        t <- listOfN(n, awesome)
      } yield TotallyAwesome(t)

    def awesome: Gen[NotationAwesome] =
      frequency((2, bool), (2, string), (1, totally))

    Arbitrary(awesome)
  }
}
