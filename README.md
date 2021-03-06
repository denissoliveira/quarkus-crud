![GitHub package version](https://img.shields.io/github/package-json/v/denissoliveira/quarkus-crud.svg)
[![GitHub pull requests](https://img.shields.io/github/issues-pr-raw/denissoliveira/quarkus-crud.svg)](https://github.com/denissoliveira/quarkus-crud/pulls)
[![GitHub issues](https://img.shields.io/github/issues/denissoliveira/quarkus-crud.svg)](https://github.com/denissoliveira/quarkus-crud/issues?q=is%3Aopen+is%3Aissue)
![GitHub last commit](https://img.shields.io/github/last-commit/denissoliveira/quarkus-crud.svg)
[![GitHub issue/pull request author](https://img.shields.io/github/issues/detail/u/denissoliveira/quarkus-crud/1.svg)](https://github.com/denissoliveira/quarkus-crud/pulls)
![GitHub contributors](https://img.shields.io/github/contributors/denissoliveira/quarkus-crud.svg)
![GitHub top language](https://img.shields.io/github/languages/top/denissoliveira/quarkus-crud.svg)
[![GitHub](https://img.shields.io/github/license/denissoliveira/quarkus-crud.svg)](https://github.com/denissoliveira/quarkus-crud)
[![GitHub All Releases](https://img.shields.io/github/downloads/denissoliveira/quarkus-crud/total.svg)](https://github.com/denissoliveira/quarkus-crud/archive/master.zip)
[![Conventional Commits](https://img.shields.io/badge/Conventional%20Commits-1.0.0-yellow.svg)](https://conventionalcommits.org)

# quarkus-crud Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-crud-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

OBS.: PARA COMPILAR NATIVO COM GRAALVM, USAR JAVA 11.

### Criando uma imagem

```sh
./mvnw package -Pnative
docker build -f src/main/docker/Dockerfile.native-distroless -t quarkus/quarkus-crud .
docker run -i --rm -p 8080:8080 quarkus/quarkus-crud
```

Use `--network host` para rodar local:
`docker run --network host -i --rm -p 8080:8080 quarkus/quarkus-crud`

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

## Tests

Use [testContainers](https://www.testcontainers.org/) e [Database-rider](https://github.com/database-rider/database-rider)

## Conventional Commits

[Conventional Commits](https://www.conventionalcommits.org/)

## ChangeLogs

[standard-version](https://www.npmjs.com/package/standard-version)

* Test `npm run release -- --dry-run`
* `npm run release -- --release-as 0.0.1-SNAPSHOT --dry-run`

## Versionamento

[semver](https://semver.org/)
