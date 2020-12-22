# GraalVM JDK11 Helloworld


## Install GraalVM


Get graalvm https://github.com/graalvm/graalvm-ce-builds/releases !


```
tar zxvf graalvm-ce-java11-<xxx>.tar.gz

export PATH=<graalvm>/bin:$PATH
export JAVA_HOME=<graalvm>
```

## Install WASM


```
<graalvm>/bin/gu install wasm
```

## Native image

```
sudo apt-get install build-essential libz-dev zlib1g-dev

<graalvm>/bin/gu install native-image
```

## Run maven clean install


```
cd <graalvm_maven_project>
export JAVA_HOME=<graalvm>
mvn clean install
```

## Execute

```
target/example
```

You see "Hello World!" ? Well Done !