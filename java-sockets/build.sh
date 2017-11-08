#!/usr/bin/env bash

# Check for output directory
if [ ! -d "./bin" ]; then
    mkdir bin;
fi

# Compile source
cd ./src
javac *.java -d ../bin

# Archive classes to jar file
cd ../bin
jar cfe client.jar client.SocketClient client/*.class
jar cfe server.jar server.Main server/*.class

# Make jars executable
chmod +x *.jar

# Alert user that build has completed
echo
echo Done.
echo
