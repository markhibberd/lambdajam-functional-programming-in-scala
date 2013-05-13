package workshop
package parser

/*
The awesome notation data structure is described by one of four possibilities:
*/
sealed trait NotationAwesome
// 1) A true value, parsed as the string "true"
case object AwesomeTrue extends NotationAwesome
// 2) A false value, parsed as the string "false"
case object AwesomeFalse extends NotationAwesome
// 3) A string value, parsed as any string surrounded by double-quotes
case class AwesomeString(s: String) extends NotationAwesome
// 4) A list of other values, parsed as values surrounded by [square brackets] and separated, by, commas
// e.g. [true, "awesome"]
case class TotallyAwesome(a: List[NotationAwesome]) extends NotationAwesome

object NotationAwesome {
  import Parser._

  /*
  Exercise 26
  -----------
  A parser that consumes the string "true", which corresponds to the AwesomeTrue data constructor.

  ~~~ Use string
  */
  def trueP: Parser[NotationAwesome] =
    string("true") map (_ => AwesomeTrue)

  /*
  Exercise 27
  -----------
  A parser that consumes the string "false", which corresponds to the AwesomeFalse data constructor.

  ~~~ Use string
  */
  def falseP: Parser[NotationAwesome] =
    string("false") map (_ => AwesomeFalse)

  /*
  Exercise 28
  -----------
  A parser that consumes an arbitrary string surrounded by double-quotes.
  The string value corresponds to the AwesomeString data constructor.

  ~~~ Use flatMap, map and other parsers
  ~~~ Alternatively, use ap, map and other parsers
  */
  def stringP: Parser[NotationAwesome] =
    for {
      _ <- is('"')
      c <- satisfyPred(_ != '"').many
      _ <- is('"')
    } yield AwesomeString(c.mkString)

  /*
  Exercise 29
  -----------
  A parser that consumes a list of values surrounded by square brackets and separated by commas.
  The list value corresponds to the TotallyAwesome data constructor.

  ~~~ Use flatMap, map, awesomeP, separation and other parsers
  ~~~ Alternatively, use ap, map, awesomeP, separation and other parsers
  */
  def totallyP: Parser[NotationAwesome] =
    for {
      _ <- is('[')
      _ <- spaces
      a <- awesomeP separation is(',')
      _ <- spaces
      _ <- is(']')
    } yield TotallyAwesome(a)

  /*
  Exercise 30
  -----------
  A parser that consumes the awesome notation.

  ~~~ Use flatMap, map, | and the parsers just written
  ~~~ Alternatively, use ap, map, | and the parsers just written
  */
  def awesomeP: Parser[NotationAwesome] =
    for {
      _ <- spaces
      a <- totallyP | stringP | falseP | trueP
      _ <- spaces
    } yield a

}
