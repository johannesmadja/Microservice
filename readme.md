**Pour démarrer le projet spring**

```shell
mvn spring-boot:run
```

**Pour mettre à jour les dépendances du projet**
```shell
mvn clean install -U
```

**Pour exécuter Liquibase**
*Si la configuration se trouve dans le pom.xml*
```shell
mvn liquibase:update
```
*Si la configuration se trouve dans un fichier liquibase.properties à la racine du projet*
```shell
mvn liquibase:update -Dliquibase.properties=liquibase.properties
```
*Installation locale du jar 
```shell
mvn install:install-file -Dfile=path/to/jar/utils-1.0.0.jar -DgroupId="com.microservice.common" -DartifactId=utils -Dversion="1.0.0" -Dpackaging=jar
```

**Désactiver la connexion automatique à une base de donnée**
*Option 1 : Dans la classe principale*
```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}

```

*Option 2 : Dans le application properties*
```properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

```

*Option 3 : Désactiver le spring.config.import*
```properties
spring.config.import=optional:configserver:
```