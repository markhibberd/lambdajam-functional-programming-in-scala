package workshop
package parser

case class ParseFail[A](m: String) extends ParseResult[A]
case class ParseValue[A](v: A) extends ParseResult[A]
/*
A ParseResult[A] is either a fail String or value A.
*/
sealed trait ParseResult[A] {
  /*
  Exercise 1
  ----------
  Return whether or not this value is a fail.
  */
  def isFail: Boolean =
    sys.error("todo")

  /*
  Exercise 2
  ----------
  Return whether or not this value is a fail.
  ~~~ use isFail.
  */
  def isValue: Boolean =
    sys.error("todo")

  /*
  Exercise 3
  ----------
  Map a function across this parse result.
  Two laws must satisfy:
    1) r.map(z => z) == r
    2) r.map(z => f(g(z))) == r.map(g).map(f)
  Ensure these laws are satisfied in the implementation by code review.
  */
  def map[B](f: A => B): ParseResult[B] =
    sys.error("todo")

  /*
  Exercise 4
  ----------
  FlatMap a function across this parse result.
  One law must satisfy:
    * r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
  Ensure this law is satisfied in the implementation by code review.
  */
  def flatMap[B](f: A => ParseResult[B]): ParseResult[B] =
    sys.error("todo")

  def ap[B](f: ParseResult[A => B]): ParseResult[B] =
    for {
      ff <- f
      aa <- this
    } yield ff(aa)

  /*
  Exercise 5
  ----------
  Zip this parse result with the given parse result to produce a parse result of pair.
  There are several ways of achieving this:
  ~~~ Use flatMap and map.
  ~~~ Use ap and map.
  */
  def zip[B](b: ParseResult[B]): ParseResult[(A, B)] =
    sys.error("todo")

  /*
  Exercise 6
  ----------
  Return the possible fail message held by this parse result.
  */
  def message: Option[String] =
    sys.error("todo")

  /*
  Exercise 7
  ----------
  Return the possible value held by this parse result.
  */
  def value: Option[A] =
    sys.error("todo")

  /*
  Exercise 8
  ----------
  Return if all values of type A satisfy the predicate.
  */
  def forall(p: A => Boolean): Boolean =
    sys.error("todo")

  /*
  Exercise 9
  ----------
  Return if any values of type A satisfy the predicate.
  */
  def exists(p: A => Boolean): Boolean =
    sys.error("todo")

}

object ParseResult {
  /*
  Exercise 10
  -----------
  Given a list of parse results, return a parse result of list.
  This can be done by "sequencing"; look at the parse result on the list head,
  and sequence its value to the tail.

  ~~~ Use flatMap and map with explicit recursion.
  ~~~ Alternatively, use ap and map with explicit recursion.
  */
  def sequence[A](a: List[ParseResult[A]]): ParseResult[List[A]] =
    sys.error("todo")

}
