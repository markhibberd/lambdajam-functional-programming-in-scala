package workshop

object Tests {
  val tests: List[(String, Option[NotationAwesome], String)] =
    List(
      (
        "sole true"
      , Some(AwesomeTrue)
      , "true"
      )
    , (
        "list with single value"
      , Some(TotallyAwesome(List(AwesomeFalse)))
      , "[false]"
      )
    , (
        "empty list"
      , Some(TotallyAwesome(List()))
      , "[]"
      )
    , (
        "sole string"
      , Some(AwesomeString("awesome"))
      , "\"awesome\""
      )
    , (
        "sole string containing brackets"
      , Some(AwesomeString("awe[some]"))
      , "\"awe[some]\""
      )
    , (
        "list with several top-level values"
      , Some(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, AwesomeTrue)))
      , "[\"awesome\", false, true]"
      )
    , (
        "list with embedded values"
      , Some(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, TotallyAwesome(List(AwesomeTrue, AwesomeFalse, AwesomeString("more awesome"))))))
      , "[\"awesome\", false, [ true, false, \"more awesome\"]]"
      )
    , (
        "list with values interspersed with whitespace"
      , Some(TotallyAwesome(List(AwesomeString("awesome"), AwesomeFalse, TotallyAwesome(List(AwesomeTrue, AwesomeFalse, AwesomeString("more awesome"))))))
      , "  [  \"awesome\"  , false, [ true   , false, \"more awesome\"]  ]  "
      )
      // failures
    , (
        "arbitrary characters fail"
      , None
      , "awesome"
      )
    , (
        "unbalanced quotes fail"
      , None
      , "\"awesome"
      )
    , (
        "unbalanced left bracket fail"
      , None
      , "[ true"
      )
    , (
        "unbalanced right bracket fail"
      , None
      , "],  "
      )
    , (
        "misplaced comma fail"
      , None
      , ",  "
      )
    )
}

object Workshop {
  import NotationAwesome.awesomeP
  import Tests.tests

  val q = tests map {
    case (name, result, in) => {
      val r = awesomeP parse in
      result match {
        case None => r match {
          case ParseFail(_) => "✔ " + name
          case ParseValue(v) => "✖ " + name + " > Expected parser failure, but succeeded with " + v
        }
        case Some(w) => r match {
          case ParseFail(_) => "✖ " + name + " > Expected parser to succeed with " + w + ", but failed"
          case ParseValue(v) => if(w == v) "✔ " + name else "✖ " + name + " Expected parser to succeed with " + w + ", but succeeded with " + v
        }
      }
    }
  }

  def main(args: Array[String]) {
    q foreach println
  }
}
