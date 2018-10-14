Dragons game backend java implementation
=============================

This application is solving a problem presented on https://www.dragonsofmugloar.com/

## Implementation ##
Application is implemented using springboot. It has one main api:
/playGame - run game and return current game score.

## Game logic ##
1) Finds the easiest messages and tries to solve them.
2) Purchases new items from store if the player has enough money.
3) Repeats the first and the second steps until finds an item, which increases lives. 
4) Repeats the first step, but in the second step always purchases an item found in the third step, not letting to increase lives up to seven.


## Setup ##
* Clone the repo
* mvn spring-boot:run
* Enter your URL (Default: http://localhost:8080/playGame)


