Class


| Cell extends Polygon (Circle)                     |   |
|---------------------------------------------------|---|
| private int state (0, 1, 2)                       |   |
| private double radius (whether polygon or circle) |   |
| private Point2D myPosition                        |   |
| private Paint myColor                             |   |
|                                                   |   |
|                                                   |   |
| Cell()                                            |   |
| public boolean neighbour(Cell c)                  |   |
| public void switchColor(Paint c)                  |   |
| public int getState()                             |   |
|                                                   |   |



| Grid    |   |
|--------------------------------------|---|
| private int state (0, 1, 2)          |   |
| double getTotalPrice(OrderLine)      |   |
| boolean isValidPayment (Customer)    |   |
| void deliverTo (OrderLine, Customer) |   |
|                                      |   |
|                                      |   |
|                                      |   |
|                                      |   |
| public int getState()                |   |
|                                      |   |


| Main                                    |   |
|--------------------------------------|---|
| private int state (0, 1, 2)          |   |
| double getTotalPrice(OrderLine)      |   |
| boolean isValidPayment (Customer)    |   |
| void deliverTo (OrderLine, Customer) |   |
|                                      |   |
|                                      |   |
|                                      |   |
|                                      |   |
| public int getState()                |   |
|                                      |   |

| GUI                                  |   |
|--------------------------------------|---|
| private int state (0, 1, 2)          |   |
| double getTotalPrice(OrderLine)      |   |
| boolean isValidPayment (Customer)    |   |
| void deliverTo (OrderLine, Customer) |   |
|                                      |   |
|                                      |   |
|                                      |   |
|                                      |   |
| public int getState()                |   |
|                                      |   |

| Scene                                |   |
|--------------------------------------|---|
| private int state (0, 1, 2)          |   |
| double getTotalPrice(OrderLine)      |   |
| boolean isValidPayment (Customer)    |   |
| void deliverTo (OrderLine, Customer) |   |
|                                      |   |
|                                      |   |
|                                      |   |
|                                      |   |
| public int getState()                |   |
|                                      |   |


multiple extension of cells

easy: fire, flooding, Conway's Game of Life

hard: cancer, plague, 