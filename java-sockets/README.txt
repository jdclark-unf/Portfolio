AUTHORS

Marcus Hagans
Justin Clark
Sam Lockwood
Jason Reim


DESCRIPTION

A multithreaded, socket-based client-server pair


INSTRUCTIONS

To quickly and automatically build both the client and the server, open a terminal, navigate to the project root directory, and execute the build script with:

  $ sh build.sh

Alternatively, the individual components can be compiled from the src directory with:

  $ javac server.jar
  $ javac client.jar

To run server in terminal, navigate to bin directory and execute

  $ java -jar server.jar 8080

The client can be likewise invoked with 

  $ java -jar client.jar [HOST]

where [HOST] is the host name or IPv4 address of the computer on which server is running.
