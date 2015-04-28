# rock-paper-scissors
Command line implementation of Rock - Paper - Scissors game.

Allowed modes:
* Computer vs Computer
* Computer vs Human

### Installation & Running

```
mvn clean install
mvn exec:exec
```

OR

```
mvn assembly:assembly
java -jar target/rps-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Other
* Getting users figures is done in parallel to model real life behaviour
