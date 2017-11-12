# Desafio 1: Strings

## Pré-requisitos:
- Java 8
- Maven >= 3.5


## Instalação
```sh
$ export stringsPath=/path/para/o/desafio/strings
$ cd $stringsPath
$ mvn clean install
```


## Execução
```sh
$ java -jar $stringsPath/target/strings.desafios-deploy.jar 30 true 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor...'
```

ou:

```sh
$ java -jar $stringsPath/target/strings.desafios-deploy.jar 30 true 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor...' > output.txt
```

onde:
  - **30**: Número de caracteres máximo por linha.
  - **true**: Flag para justificação do texto.
  - **Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor...**: Texto a ser formatado.
  - **output.txt**: Arquivo de saída onde será salvo o texto formatado (opcional).

-------
Carlos Henrique Severino

caiik@live.com
