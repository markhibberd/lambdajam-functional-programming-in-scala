package workshop
package warmup

import org.scalacheck.Properties
import org.scalacheck.Prop._

object WarmupSpecification extends Properties("Warmup") {
  import Warmup._

  property("append is associative") = forAll(
    (x: List[Int], y: List[Int], z: List[Int]) =>
      append(append(x, y), z) == append(x, append(y, z))
  )

  property("append then span recovers") = forAll(
    (x: List[Int], y: List[Int]) =>
      append(x, y).splitAt(x.length) == (x, y)
  )

  property("reverse each then append is same as append then reverse") = forAll(
    (x: List[Int], y: List[Int]) =>
      append(x, y).reverse == append(reverse(y), reverse(x))
  )
}
