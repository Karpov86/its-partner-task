#Web application "Rooms with light bulbs".

### Task solution for ITS Partner by [Karpov Valery][1].

By accessing a web page, the user is able to:
- create a room by specifying its name and country from the list. 
The country is needed to restrict users access to the room.
- view the list of created rooms (including rooms created 
by other users)
- “enter” one of the rooms and turn on / off 
the light bulb located in it.

If the user's country is different from the country of the room, 
then an error is display to the user when trying to enter the room.
The country is determine by the user's IP address.
A change in the status of the light should be displayed to 
all users in the room (as quickly as possible without 
reloading the page)

Login \ registration is not need.

**Implementation Requirements:**
- Server side programming language - Java
- UI can be trivial
- Unit / Integration tests
- State preservation between application restarts should be implemented
- It is very desirable to be able to run as a 
single console command without installing third-party dependencies.

If you really want to use docker / docker-compose.

###Instruction to start.

- Clone a project from a 
[github repository][2].
- Open a project in IntelliJ IDEA.
- Create DB in MySQL (>v.8) with sql script [here](./sql)
and you can population then.
- Important! Don't forget change MySQL properties.
Set your user name and password for MySQL [here][3].
- Finally. Run ItsPartnerTaskApplication ![image][] and open browser.
Insert URL address ***localhost:8080*** (also, you needed [Apache Tomcat][])

You are breathtaking.

[1]: https://www.linkedin.com/in/valery-karpov/ "My LinkedIn page"
[2]: https://github.com/Karpov86/its-partner-task.git "Repo with solution"
[3]: ./src/main/resources/application.properties
[image]: ./src/main/resources/Screenshot_4.png
[Apache Tomcat]: https://tomcat.apache.org/download-80.cgi
