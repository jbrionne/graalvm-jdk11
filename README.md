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
$JAVA_HOME/bin/gu install wasm
```

## Native image

```
sudo apt-get install build-essential libz-dev zlib1g-dev

$JAVA_HOME/bin/gu install native-image
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


# Read WASM with GraalVM


Install Emscripten Compiler Frontend (emcc)

https://emscripten.org/docs/tools_reference/emcc.html


```

git clone https://github.com/emscripten-core/emsdk.git

cd emsdk

# Fetch the latest version of the emsdk (not needed the first time you clone)
git pull

# Download and install the latest SDK tools.
./emsdk install latest

# Make the "latest" SDK "active" for the current user. (writes .emscripten file)
./emsdk activate latest

# Activate PATH and other environment variables in the current terminal
source ./emsdk_env.sh

```

Create the wasm file !

```
emcc -o floyd.wasm src/test/resources/floyd.c
```

## Run a WASM file with GraalVM

```
$JAVA_HOME/bin/wasm --Builtins=wasi_snapshot_preview1 src/main/resources/floyd.wasm
```

## GraalVM, read WASM from java with polyglot

See the AppWasm class
