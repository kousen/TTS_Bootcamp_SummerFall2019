# TTS_Bootcamp_SummerFall2019
Java project for TTS Bootcamp

Source and tests in usual location (`src/main/java`, `src/test/java`).

Added .gitignore file for Java projects.

Includes Gradle wrapper. To use it, run `gradlew build` from command line (on Un*x flavors and Macs use `./gradlew build`).
That will:

* Download Gradle
* Install it in the directory `~/.gradle/wrapper/dists`
* Download project dependencies (only JUnit 4 at the moment but that will likely grow)
* Compile all the code
* Run all the tests
* Produce an HTML test report in the directory `build/reports/tests/test/index.html`.

The downloads will only happen once.

Ken Kousen

ken.kousen@kousenit.com
