package workshop
package parser

object ParserSpec extends Spec {
  import NotationAwesome._
  "parser" should {
    "sole true" in {
      awesomeP parse "true" must_== ParseValue(AwesomeTrue)
    }.pendingUntilFixed

    "list with single value" in {
      awesomeP parse "[false]" must_== ParseValue(TotallyAwesome(List(AwesomeFalse)))
    }.pendingUntilFixed

    "empty list" in {
      awesomeP parse "[]" must_== ParseValue(TotallyAwesome(List()))
    }.pendingUntilFixed

    "sole string" in {
      awesomeP parse "\"awesome\"" must_== ParseValue(AwesomeString("awesome"))
    }.pendingUntilFixed

    "sole string containing brackets" in {
      awesomeP parse "\"awe[some]\"" must_== ParseValue(AwesomeString("awe[some]"))
    }.pendingUntilFixed

    "list with several top-level values" in {
      awesomeP parse "[\"awesome\", false, true]" must_== ParseValue(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, AwesomeTrue)))
    }.pendingUntilFixed

    "list with embedded values" in {
      awesomeP parse "[\"awesome\", false, [ true, false, \"more awesome\"]]" must_== ParseValue(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, TotallyAwesome(List(AwesomeTrue, AwesomeFalse, AwesomeString("more awesome"))))))
    }.pendingUntilFixed

    "list with values interspersed with whitespace" in {
    awesomeP parse " [ \"awesome\" , false, [ true , false, \"more awesome\"] ] " must_== ParseValue(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, TotallyAwesome(List(AwesomeTrue, AwesomeFalse, AwesomeString("more awesome"))))))
    }.pendingUntilFixed

    "arbitrary characters fail" in {
      awesomeP.parse("awesome").isFail
    }.pendingUntilFixed

    "unbalanced quotes fail" in {
      awesomeP.parse("\"awesome").isFail
    }.pendingUntilFixed

    "unbalanced left bracket fail" in {
      awesomeP.parse("[ true").isFail
    }.pendingUntilFixed

    "unbalanced right bracket fail" in {
      awesomeP.parse("], ").isFail
    }.pendingUntilFixed

    "misplaced comma fail" in {
      awesomeP.parse(", ").isFail
    }.pendingUntilFixed
  }
}
