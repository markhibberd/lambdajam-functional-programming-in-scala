## introduction to functional programming in scala

__note:__ please test your environment before you arrive so we can get
started quickly on the day.

__note:__ please make sure to grab the latest copy of this repository the day before the course with a `git pull origin master`.


## Getting started

If you have any problems email me via <mark@hibberd.id.au>.

Pre-requisites:

 1. A valid install of java 6+
 2. git
 3. **if you are running windows only** install sbt using the [msi installer](http://scalasbt.artifactoryonline.com/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.12.3/sbt.msi)


Getting scala and validating your environment:

    git clone https://github.com/markhibberd/lambdajam-functional-programming-in-scala.git
    cd lambdajam-functional-programming-in-scala
    ./sbt test   # (or just sbt test under windows)

This may take a few minutes. It will:

 1. Download the sbt build tool.
 2. Download the required versions of scala.
 3. Compile the main and test source code.
 4. Run the tests.


You should see success output, no errors and, an exit code of 0.


## Editors for working with scala.

You should come armed with a good text editor. 

Anything that you can navigate around quickly should be fine, but if you
prefer an IDE, you can use the eclipse based [scala-ide](http://scala-ide.org/) 
or [intellij](http://www.jetbrains.com/idea/) with the scala and sbt plugins installed.

You can generate project files for intellij with:

    ./sbt 'gen-idea no-classifiers'

You can generate project files for eclipse with:

    ./sbt eclipse
