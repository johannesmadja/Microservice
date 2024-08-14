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