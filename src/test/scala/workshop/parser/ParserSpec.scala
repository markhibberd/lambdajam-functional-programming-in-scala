package workshop
package parser

object ParserSpec extends Spec {
  import NotationAwesome._
  "parser" should {
    "sole true" in {
      awesomeP parse "true" must_== ParseValue(AwesomeTrue)
    }

    "list with single value" in {
      awesomeP parse "[false]" must_== ParseValue(TotallyAwesome(List(AwesomeFalse)))
    }

    "empty list" in {
      awesomeP parse "[]" must_== ParseValue(TotallyAwesome(List()))
    }

    "sole string" in {
      awesomeP parse "\"awesome\"" must_== ParseValue(AwesomeString("awesome"))
    }

    "sole string containing brackets" in {
      awesomeP parse "\"awe[some]\"" must_== ParseValue(AwesomeString("awe[some]"))
    }

    "list with several top-level values" in {
      awesomeP parse "[\"awesome\", false, true]" must_== ParseValue(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, AwesomeTrue)))
    }

    "list with embedded values" in {
      awesomeP parse "[\"awesome\", false, [ true, false, \"more awesome\"]]" must_== ParseValue(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, TotallyAwesome(List(AwesomeTrue, AwesomeFalse, AwesomeString("more awesome"))))))
    }

    "list with values interspersed with whitespace" in {
    awesomeP parse " [ \"awesome\" , false, [ true , false, \"more awesome\"] ] " must_== ParseValue(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, TotallyAwesome(List(AwesomeTrue, AwesomeFalse, AwesomeString("more awesome"))))))
    }

    "arbitrary characters fail" in {
      awesomeP.parse("awesome").isFail
    }

    "unbalanced quotes fail" in {
      awesomeP.parse("\"awesome").isFail
    }

    "unbalanced left bracket fail" in {
      awesomeP.parse("[ true").isFail
    }

    "unbalanced right bracket fail" in {
      awesomeP.parse("], ").isFail
    }

    "misplaced comma fail" in {
      awesomeP.parse(", ").isFail
    }
  }
}
