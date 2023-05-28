# Cell Society Design Lab Discussion
#### Shriya Challam - sc746, Andy Wang - xw214, Sophie Williams - smw92


### Simulations

 * Commonalities
 
 * Variations



### Discussion Questions

 * How does a Cell know what rules to apply for its simulation?

    * state object -> dead, alive, etc.

    * through methods in the cell class which are dependent on the state, neighbors, etc.

    * all these methods should be within a step function to update everything continuously

 * How does a Cell know about its neighbors?

    * using the cell's x and y coordinates, we can get the neighboring cells from the grid

 * How can a Cell update itself without affecting its neighbors update?

    * two passes
        
        * the first pass just stores what the cell should become rather than making the change

        * the second pass is to actually make the change 

 * What behaviors does the Grid itself have?

    * boundaries/size

    * background color/design

    * shape

 * How can a Grid update all the Cells it contains?

    * iterate through all the cells

    * the cells should be in an array as an instance variable within the grid

 * What information about a simulation needs to be in the configuration file?

    * simulation type it represents
    
    * title for this configuration
    
    * author of this configuration
    
    * description of this simulation
    
    * width and height of the grid
    
    * initial configuration of the states for the cells in the grid
    
    * parameter values specific to the simulation

 * How is configuration information used to set up a simulation?

    * the configuration information will be used to create the first state that will begin the simulation

 * How is the graphical view of the simulation updated after all the cells have been updated?

    * with the cells new states



### Alternate Designs

#### Design Idea #1

 * Data Structure #1 and File Format #1

 * Data Structure #2 and File Format #2


#### Design Idea #2

 * Data Structure #1 and File Format #1

 * Data Structure #2 and File Format #2
 
 

### High Level Design Goals



### CRC Card Classes

This class's purpose or value is to represent a customer's order:
![Order Class CRC Card](images/order_crc_card.png "Order Class")


This class's purpose or value is to represent a customer's order:

|Order| |
|---|---|
|boolean isInStock(OrderLine)         |OrderLine|
|double getTotalPrice(OrderLine)      |Customer|
|boolean isValidPayment (Customer)    | |
|void deliverTo (OrderLine, Customer) | |


This class's purpose or value is to represent a customer's order:
```java
public class Order {
     // returns whether or not the given items are available to order
     public boolean isInStock (OrderLine items)
     // sums the price of all the given items
     public double getTotalPrice (OrderLine items)
     // returns whether or not the customer's payment is valid
     public boolean isValidPayment (Customer customer)
     // dispatches the items to be ordered to the customer's selected address
     public void deliverTo (OrderLine items, Customer customer)
 }
 ```


This class's purpose or value is to manage something:
```java
public class Something {
     // sums the numbers in the given data
     public int getTotal (Collection<Integer> data)
	 // creates an order from the given data
     public Order makeOrder (String structuredData)
 }
```


### Use Cases

* Apply the rules to a middle cell: set the next state of a cell to dead by counting its number of neighbors using the Game of Life rules for a cell in the middle (i.e., with all its neighbors)
```java
 Something thing = new Something();
 Order o = thing.makeOrder("coffee,large,black");
 o.update(13);
```

* Apply the rules to an edge cell: set the next state of a cell to live by counting its number of neighbors using the Game of Life rules for a cell on the edge (i.e., with some of its neighbors missing)
```java
 Something thing = new Something();
 Order o = thing.makeOrder("coffee,large,black");
 o.update(13);
```

* Move to the next generation: update all cells in a simulation from their current state to their next state and display the result graphically
```java
 Something thing = new Something();
 Order o = thing.makeOrder("coffee,large,black");
 o.update(13);
```

* Set a simulation parameter: set the value of a parameter, probCatch, for a simulation, Fire, based on the value given in a data file
```java
 Something thing = new Something();
 Order o = thing.makeOrder("coffee,large,black");
 o.update(13);
```

* Switch simulations: load a new simulation from a data file, replacing the current running simulation with the newly loaded one
```java
 Something thing = new Something();
 Order o = thing.makeOrder("coffee,large,black");
 o.update(13);
```