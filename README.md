## Jormungand(r)

A microservice discord bot consisting of following parts:

* Mouth: Receives all the discord messages and feeds them into the messagebroker (body)
* Body: A message broker that provides updates for all other services
* Tail: Sends messages to discord depending on the messages it receives from the message broker
* Ragnarok: Error logging
* Runestone: database
* Hermoor: database interface

For more info relate to the single repos

## Deploy
TODO: Docker-compose setup

