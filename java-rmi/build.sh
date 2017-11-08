#!/usr/bin/env bash

if [ ! -d "./bin" ]; then
    mkdir bin
fi

if [ ! -d "./bin/client" ]; then
    mkdir bin/client
fi

if [ ! -d "./bin/server" ]; then
    mkdir bin/server
fi

cp -v src/policy.txt bin/server
cp -v src/policy.txt bin/client
javac -verbose -d bin/server -cp src/RMIserver src/RMIserver/*.java
javac -verbose -d bin/client -cp src/RMIclient src/RMIclient/*.java

echo
echo Done.
echo
