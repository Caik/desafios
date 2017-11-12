# Desafio 2: Crawlers

## Pré-requisitos:
- Java 8
- Maven >= 3.5


## Instalação
```sh
$ export crawlersPath=/path/para/o/desafio/crawlers
$ cd $crawlersPath
$ mvn clean install
```


## Execução
 - Desafio parte 1:

```sh
$ java -jar $crawlersPath/target/crawlers.desafios-deploy.jar subReddit1[;suReddit2;subReddit3...] [minScore]
```

onde:
  - **subRedditX**: *Subreddits* a serem consultados (pelo menos 1) separados por ponto-e-vírgula (`;`).
  - **minScore**: Pontuação mímina da *Thread* a ser retornada (opcional: por padrão o valor é 5000).

---

- Desafio parte2:

```sh
$ java -jar $crawlersPath/target/crawlers.desafios-bot-deploy.jar
```
A partir daí, interagir com o BOT via Talegram.

Para parar a execução do BOT:

```sh
$ ctrl+c
```

#### Dados do BOT:
 - ***Username***: @IDWallCrawler_Bot


---

Carlos Henrique Severino

caiik@live.com
