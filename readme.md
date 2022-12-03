#MVN cucumber project

1. check your java version, this project is configured to run on java 16, if you are running different version then change it in pom.xml
```
    <maven.compiler.source>16</maven.compiler.source>
    <maven.compiler.target>16</maven.compiler.target>
```

2. Open pom file and press `Ctrl + Shift + O`, Keyboard shortcut to update maven dependency is `Ctrl+Shift+O`
3. To Run using command line try `mvn test or mvn test -Dcucumber.filter.tags="@smoke"`
