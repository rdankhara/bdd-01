### MVN cucumber project
> To Run using command line try `mvn test or mvn test -Dcucumber.filter.tags="@smoke"`
#MVN cucumber project

1. check your java version, this project is configured to run on java 16, if you are running different version then change it in pom.xml
```
    <maven.compiler.source>16</maven.compiler.source>
    <maven.compiler.target>16</maven.compiler.target>
```

2. Open pom file and press `Ctrl + Shift + O`, Keyboard shortcut to update maven dependency is `Ctrl+Shift+O`
3. To Run using command line try `mvn test or mvn test -Dcucumber.filter.tags="@smoke"`
4. refer cucumber [expression](https://github.com/cucumber/cucumber-expressions#readme)

```bash
mvn test
```
5. create md5 hash `echo "your-string" | md5sum`

> running test via command line
``mvn test -Dcucumber.filter.tags="@calculator"``
> for all available options refer https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-core
> 
