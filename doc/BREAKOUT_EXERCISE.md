# Breakout Abstractions Lab Discussion
#### Sophie, Andy, Shriya


## Princple Slogans

* Single Responsibility

* Open Closed



### Block

This superclass's purpose as an abstraction:
```java
 public abstract class Block {
     public int Block();
     public abstract void changeColor();
     public abstract void destroyBlock();
     public boolean checkCollision();
     public int getHits();
     // abstract class used as the basis for all other block types 
 }
```

#### Subclasses

This subclass's high-level behavorial differences from the superclass:
```java
 public abstract class RegBlock extends Block {
     public int Block();
     // regular block which inherits from block class
 }
```
```java
 public abstract class PowerUpBlock extends Block {
     public int Block();
     public void releasePowerUp();
     // power up block has extra functionality of releasing power up after destruction
 }
```
```java
 public abstract class StrongBlock extends Block {
     public int Block();
     public void decrementHits();
     // strong block has extra functionality taking additional hits to deteriorate 
 }
```


#### Affect on Game/Level class
It allows for less duplication of the code and allows for a variety of bricks to be quickly implemented.

### Power-up

This superclass's purpose as an abstraction:
```java
 public abstract class PowerUp {
     public void PowerUp();
     public void step();
     
     // no implementation, just a comment about its purpose in the abstraction 
 }
```

#### Subclasses

This subclass's high-level behavorial differences from the superclass:
```java
 public class MultiBalls extends PowerUp {
     public void MultiBalls(int x, int y); 
     public void generateEffect();
 }
```
```java
 public class PaddleGrower extends PowerUp {
     public void PaddleGrower(Paddle paddle);
     public void generateEffect();
     // no implementation, just a comment about what it does differently 
 }
```
```java
 public class NextLevel extends PowerUp {
     public void NextLevel(Level currentLevel);
     // no implementation, just a comment about what it does differently 
 }
```
#### Affect on Game/Level class
It allows for less duplication of the code and new power ups can be quickly added.



### Level

This superclass's purpose as an abstraction:
```java
 public class Level {
    private int score;
    private int lives;
    private int ballSpeed;
    private int paddleSpeed;
    
     public Level();
     public void setUpBricks(String filename);
     // no implementation, just a comment about its purpose in the abstraction 
 }
```

#### Subclasses

This subclass's high-level behavorial differences from the superclass:
```java
 public class EasyLevel extends Level {
     public EasyLevel();
     // passes the appropriate brick layout filename and parameters to the super() constructor to create the appropriate level
 }
```
```java
 public class MediumLevel extends Level {
     public int MediumLevel();
    // passes the appropriate brick layout filename and parameters to the super() constructor to create the appropriate level
 }
```
```java
 public class HardLevel extends Level {
     public HardLevel();
    // passes the appropriate brick layout filename and parameters to the super() constructor to create the appropriate level
 }
```

#### Affect on Game class
Allows changes made to one level to go into effect for all levels which will make debugging easier.



### Others?