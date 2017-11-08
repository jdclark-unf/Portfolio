AUTHORS

Marcus Hagans
Sam Lockwood
Jason Reim
Justin Clark


DESCRIPTION

A multithreaded, RMI-based client-server pair


INSTRUCTIONS

To build application, open a terminal, navigate to the project root directory, and execute the build script with:

  $ sh build.sh

To run the server, execute the following commands (assuming the server will be running on host 192.168.100.65):

  $ cd bin/server
  $ rmiregistry 15432 &
  $ java -Djava.rmi.server.hostname=192.168.100.65 -Djava.security.policy=policy.txt RMIServer

To run the client:

  $ cd bin/client
  $ java -Djava.security.policy=policy.txt RMIClient 192.168.100.65

