# DistributedSystems-RMI

 To run the application open a terminal and run the command:
{% include "/intro_to_command_line/open_instructions.md" %}
{% filename %}riga di comando  java -jar main.jar {% endfilename %}

This will execute the server and 3 clients as different threads
in the same process, so the output will be in the same terminal.

To execute every application in a different process open a terminal
and run the command:
java -jar server.jar
then open one terminal for every client needed (at least 3) and run
the command:
java -jar client.jar
in every terminal.

Otherwise open the project in Eclipse and run Main to execute
server and clients as different processes, or run Server and Client
separately to execute them as different processes.

Javadoc documentation can be found in the folder Prodotti/doc.
