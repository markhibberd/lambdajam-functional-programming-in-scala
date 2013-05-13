package workshop
package parser

import org.scalacheck.Properties
import org.scalacheck.Prop._
import NotationAwesomeArbitrary._
import NotationAwesome._

object NotationAwesomeSpecification extends Properties("NotationAwesome") {
  property("append is associative") = forAll(
    (w: NotationAwesome) =>
      (awesomeP parse w.toString).exists(w == _)
  )

}
