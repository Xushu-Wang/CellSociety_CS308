# Rock Paper Scissors Lab Discussion
#### Names and NetIDs

Andy, xw214
Sophie, smw96
Shriya, sc746


### High Level Design Goals

* Make an interactive game and auto game of rock paper scissors.



### CRC Card Classes

This class's purpose or value is to represent a customer's order:

| Player             |         |
|--------------------|---------|
| element makeMove() | element |
| int displayScore() |         |
| int setScore()     |         |
| int score          |         |
| element getMove()  |         |

| MachinePlayer extends Player |         |
|------------------------------|---------|
| element makeMove()           | element |
| int displayScore()           |         |

| element                         |     |
|---------------------------------|-----|
| boolean beat(element e)         |     |
| String name;                    |     |
| boolean tie(element e)          |     |

| Game                      |     |
|---------------------------|-----|
| Game()                    |     |
| startGame()               |     |
| private Player myPlayer   |     |
| private Player myOpponent |     |
| void step()               |     |
| boolean compare()         |     |
| private int round         |     |
| private int[][] score     |     |
| void reset()              |     |
| private int numPlayers    |     |

This class's purpose or value is to represent a Player:
```java
public abstract class Player {
     // take an action
     public element makeMove ();
     // display the score for player
     public String displayScore ();
 }
 ```

This class's purpose or value is to represent elements (rock paper scissors):
```java
public class Element {
     String name;
     // sums the numbers in the given data
     public element(String name);
	 // creates an order from the given data
     public boolean beat(Element e);
     public boolean tie(Element e);    
 }
```


### Use Cases

* A new game is started with five players, their scores are reset to 0.
 ```java
List<Player> playerList = new ArrayList<>();

for(int i=0; i<numPlayers; i++){
    Player p = new Player();
    p.setScore(0);
    playerList.add(p);
}
 ```

* A player chooses his RPS "weapon" with which he wants to play for this round.
 ```java
playerList(0).makeMove();
 ```

* Given three players' choices, one player wins the round, and their scores are updated.
 ```java
List<Element> moveList = new ArrayList<>();

for(Player p: playerList){
    Element e = p.getMove();
    for(Element otherMove: moveList){
        if(e.beat(otherMove)){
            p.setScore(p.getScore() + 1);
        }
    }
}
 ```

* A new choice is added to an existing game and its relationship to all the other choices is updated.
 ```java
 We update the beat & tie relationship for element and a new class extends Element class. 
 ```

* A new game is added to the system, with its own relationships for its all its "weapons".
 ```java
 Game anotherGame = new Game();
 ```
