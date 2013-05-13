package workshop
package warmup

/*
Warm-up exercises to remember Scala. Usually helpful before getting dirty with the heavy stuff.
*/
object Warmup {
  /*
  Exercise 1w
  -----------
  Append two lists to produce a new list.

  ~~~ Use foldRight
  */
  def append[A](x: List[A], y: List[A]): List[A] =
    sys.error("todo")

  /*
  Exercise 2w
  -----------
  Reverse a list to produce a new list.

  ~~~ Use foldLeft
  */
  def reverse[A](x: List[A]): List[A] =
    sys.error("todo")

  /*
  A pretend configuration structure consisting of a host and port.
  */
  case class Configuration(host: String, port: Int)

  /*
  A configuration reader on type A is a structure that reads a
  Configuration value and then produces a value of type A.
  */
  case class ConfigurationReader[A](read: Configuration => A) {
    /*
    Exercise 3w
    -----------
    Map a function across this configuration reader.
    Two laws must satisfy:
      1) r.map(z => z) == r
      2) r.map(z => f(g(z))) == r.map(g).map(f)
    Ensure these laws are satisfied in the implementation by code review.
    */
    def map[B](f: A => B): ConfigurationReader[B] =
      sys.error("todo")

    /*
    Exercise 4w
    -----------
    FlatMap a function across this configuration reader.
    One law must satisfy:
      * r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
    Ensure this law is satisfied in the implementation by code review.
    */
    def flatMap[B](f: A => ConfigurationReader[B]): ConfigurationReader[B] =
      sys.error("todo")
  }

  object ConfigurationReader {
    /*
    Exercise 5w
    -----------
    Return a configuration reader that always produces the given value.
    */
    def value[A](a: => A): ConfigurationReader[A] =
      sys.error("todo")

    /*
    Exercise 6w
    -----------
    Given a list of configuration readers, return a configuration reader of list.
    This can be done by "sequencing"; look at the configuration reader on the list head,
    and sequence its value to the tail.

    ~~~ Use flatMap and map with explicit recursion.
    */
    def sequence[A](a: List[ConfigurationReader[A]]): ConfigurationReader[List[A]] =
      sys.error("todo")
  }

  /*
  A configuration updater on A is a function that takes a configuration,
  then produces a value of type A and a new (potentially updated) configuration.
  */
  case class ConfigurationUpdater[A](update: Configuration => (A, Configuration)) {
    /*
    Exercise 7w
    -----------
    Map a function across this configuration updater.
    Two laws must satisfy:
      1) r.map(z => z) == r
      2) r.map(z => f(g(z))) == r.map(g).map(f)
    Ensure these laws are satisfied in the implementation by code review.
    */
    def map[B](f: A => B): ConfigurationUpdater[B] =
      sys.error("todo")

    /*
    Exercise 8w
    -----------
    FlatMap a function across this configuration updater.
    One law must satisfy:
      * r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
    Ensure this law is satisfied in the implementation by code review.
    */
    def flatMap[B](f: A => ConfigurationUpdater[B]): ConfigurationUpdater[B] =
      sys.error("todo")
  }

  object ConfigurationUpdater {
    /*
    Exercise 9w
    -----------
    Return a configuration updater that always produces the given value and leaves the configuration unmodified.
    */
    def value[A](a: => A): ConfigurationUpdater[A] =
      sys.error("todo")

    /*
    Exercise 10w
    ------------
    Given a list of configuration updaters, return a configuration updater of list.
    This can be done by "sequencing"; look at the configuration updater on the list head,
    and sequence its value to the tail.

    ~~~ Use flatMap and map with explicit recursion.
    */
    def sequence[A](a: List[ConfigurationUpdater[A]]): ConfigurationUpdater[List[A]] =
      sys.error("todo")
  }
}
