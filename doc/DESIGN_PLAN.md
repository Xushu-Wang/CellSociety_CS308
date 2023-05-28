# Cell Society Design Plan
### Team 3
### Sophie Williams, Andy Wang, Shriya Challam


## Overview
The goal of this project is to create a program that can simulate various kinds of cellular autonoma. 
The primary architecture design will allow a user to input a configuration file that contains the initial positions and states of different cells. Then depending on the type of simulation, the game will iterate through the progression of how the cells change over time.
The design should be flexible in allowing for a variety of rule sets to be applied to each cell as these rules are what will change from simulation to simulation. 
This can be achieved by creating abstractions for each simulation class. 
To ensure that the requirement for model-view separation is met, the backend will contain a model of cells and each of their statuses that is updated over time and the frontend will be updated to reflect these changes visually.

## User Interface
![splashscreen.png](images%2Fsplashscreen.png)
![simscreen.png](images%2Fsimscreen.png)

The UI will consist of three separate screens. The splash screen will be the first screen in the application and will allow the user to select a starting simulation file. This simulation will need to be checked for erroneous data in several ways. If there is improper formatting of the xml, parameter values that are not numbers but should be, missing tags, empty tags, or grid sizes that do not match the stated height and width, an error message will be shown to the user.

Once selected, the program will move onto the application screen which will display information relevant to the simulation and the simulation itself. To limit erroneous data being inputted by the user, the animation speed will be controlled by a sliding scale (instead of typing in a frame rate). This screen will also contain buttons to upload a new simulation file or save the current configuration. Clicking the save button will pause the simulation and open a save dialog in which the user can edit the title, author, and description. If any of these fields are left empty, an error will be shown to the user. Clicking the save button will return the user to the simulation screen.

## Configuration File Format
```xml
<simulation>
    <simtype>Fire</simtype>
    <title>Shriya’s Game</title>
    <author>Shriya</author>
    <description> Simulation of a forest fire</description>
    <grid>
        <width> 4 </width>
        <height> 4 </height>
        <cells>
            0 1 1 2
            0 2 1 0
            0 0 2 2
            0 1 1 1
        </cells>
    </grid>
    <parameters>
        <probCatch>0.5</probCatch>
    </parameters>
</simulation>
```
```xml
<simulation>
    <simtype>Segregation</simtype>
    <title>Segregation Simulation</title>
    <author>Sophie</author>
    <description> Simulation of Segregation in a Neighborhood</description>
    <grid>
        <width> 6 </width>
        <height> 4 </height>
        <cells>
            0 1 1 2 1 0
            0 2 1 0 2 2
            0 0 2 2 1 1
            0 1 1 1 2 0
        </cells>
    </grid>
    <parameters>
        <satisifedpercent> 0.3 </satisifedpercent>
    </parameters>
</simulation>
```
## Design Overview
One important abstraction that will be created is an abstract Simulation class. The simulation class will contain the information extracted from the XML file. For different simulations this may also include parameters such as "probCatch" in the Fire simulation. The simulation will also require a gridModel which will consist of smaller CellModels. CellModel will need to be abstracted in order to account for the different cell types that each simulation may have. Each simulation abstraction will also require separate update functions that scan the grid and apply the specific simulation’s rules to the cells.

![designoverview.png](images%2Fdesignoverview.png)
## Design Details
Main: This is the start of the program and will be used to create a stage and a SceneController object.

SceneController: The scene controller will control the transitioning between the Splash, Simulation, and Save Scenes.

SplashScene: This will be where the program begins and will have a button that allows the user to select a XML file for uploading a simulation. Once upload, this file will be passed into a SimultionGenerator object to create a Simulation from the XML file and this Simulation will be passed to the sceneController, so that it can use the object in the generation of a SimulationScene

SimulationGenerator: This class will use file parsing to extract relevant information to create a Simulation object

Simulation: This abstract class will hold the simulation parameters and initial configurations. Concrete simulations that extend this class will have a GridModel that contains the state of the simulation and an update function that applies the simulation’s specific rules to the grid model.

GridModel: This will consist of some collection of CellModel objects

CellModel: The abstract cell class will contain a list of neighboring cells. Concrete cells that extend this class will have the current state of the cell, the next state of the cell, as well as other parameters such as “energy levels” in the case of the shark simulation.

SimulationScene: The simulation scene will contain the text nodes holding the simulation information. As well as a GridView that displays the simulation and a button to control the animation. The simulation scene will be in charge of the timeline that is animating the simulation by updating the model and view. Additionally, it will have a file loading button to switch to a different simulations and therefore will need to work with the SimulationGenerator and SceneController to switch simulations. To implement the saving functionality, the Simulation Scene will have a button connected to the SceneController. When pressed, the SimulationScene will use the SceneController to pass the current Simulation into the SaveScene

GridView- Consists of a collection of CellView objects and controls size of the grid

CellView- A node with a set position, size, shape, and color

SaveScene- Consists of text fields that allow the user to edit simulation information. When the “save” button is pressed, the Simulation information will be passed into a XMLFileGenerator

XMLFileGenerator- Converts simulation parameters into an XML file


## Use Cases

### Apply Rules to a Middle Cell:

In the Simulate function will iterate once, the individual cell, based on its type will be changed according to its rules. GameofLifeCellModel that extends the CellModel, the countAliveNeightbors() method will determine how many of the cells
neighbors are alive and this will be used to update the nextState of the cell.
```java
private int countAliveNeighbors(){
    for(Cell c: NeighborList){
        if(cell is alive){
            increment count
        }
    }
    return count

}
updateNextState(){
    countAliveNeighbors()
    if(NeighborCount<2){
        this.nextState = dead
    } else {
        this.nextState = alive
    }
}
```

### Apply Rules to an Edge Cell:

This case will be handled identically to the one above because the count alive neighbor function
does not require a specific number of neighbors.

### Move to the Next Generation:

In the SimulationScene, the animation object will call the step function at a some set rate. This step function will repeatedly call on the simulation to update the model.
If using the observer pattern, each cell view object will be subscribed to a cell model so these changes will be reflected in the view as well.
In the SimulationScene class:
```java
myAnimation.getKeyFrames().add(new KeyFrame(Duration.seconds(Main.SECOND_DELAY), e -> step()));
        ...
step(){
            mySimulation.updateModel();
        }
```

### Switch Simulations:

On pressing the load button, the simulation will pause and the user will be brought to a file explorer to choose a file. This file will be passed to the SimulationGenerator which will parse the file to create a new Simulation object. The Simulation object will then be used by the SceneController to set the stage with a fresh simulation scene.

In the SimulationScene class:
```java
void onButtonPressed(){
    animation.pause()
    file= file from file explorer
    Simulation simulation= SimulationGenerator.createSimulationFromFile(file)
    sceneController.switchSimulationScene(simulation)
}

```

### Set a Simulation Parameter:

Depending on the type of simulation specified in the data file, a different type of simulation object will be generated by the SimulationGenerator class. The SimulationGenerator will parse the datafile, extract the relevant parameters and pass them into the constructor of the FireSimulation class.  The FireSimulation class will then keep the probCatch parameter as an instance variable.
```java
Scanner scan = new Scanner(System.in);
If (scan.hasNextDouble()) {
               double probCatch = scan.nextDouble();
}

```

### Step/Pause Simulation: 
The user should be able to pause the simulation at any stage and step one state for each cell forward.

To accomplish one step behavior, the animation will be paused and the step function will be called at each press of the step button.
```java
animation.setCycleCount(Timeline.INDEFINITE);
      	  animation.getKeyFrames().add(new KeyFrame(Duration.seconds(SECOND_DELAY), e -> step(SECOND_DELAY)));
        	animation.play();
	animation.pause();

```

### Pause/play the simulation when there is no configuration file: 

When the button in pressed and there is no uploaded config file, it should send an error.

The SimulationGenerator will try to parse a file. When it realizes it doesn’t exist, it will send an error that is sent to the Simulation object to display on the scene controller.
```java
	try{
                      XmlParser.parse(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

```
### Config file has an error:
When the button is pressed and there is no uploaded config file, it should send an error.

The SimulationGenerator will try and parse a file. When it realizes there is a bug, it will send an error that is sent to the Simulation object to display on the scene controller.
```java
	try{
                      XmlParser.parse(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

```

### Save Current Simulation Configuration
The current simulation object will be passed to the save screen via the SceneController. Then, an XML file writer object will 
use the simulation information and any edits to info made by the user to create a new simulation file which will be saved in a selected file location.

In SaveScene:
```java
SaveScene(Simulation sim){
    mySim=sim
    text1= new Textfield(sim.getTitle());
    text2= new Textfield(sim.getAuthor());
    text3= new Textfield(sim.getDescription());
    button= new Button()
}

void onButtonPress(){
    file=XMLWriter.generateXMLFile(text1, text2, text3, sim)
        save file
}



```
In XML file writer:
```java

File generateXMLFile(String title, String author, String description, Simulation sim){
        use parameters as well as the current grid configuration from the simulation to generate a new file
        return File
        }

```

### Reset Simulation
To reset the simulation, the Simulation object will replace the state of the current cells with the original state outlined in the configuration file.

In Simulation class:
```java
reset(){
    for(cell c: grid){
        initial state= scan in next state from the original state string
        c.setState(initial state)
        }
}
```

### Read in an XML File to Create Simulation
In the SimulationGenerator, the different attributes of the XML file will be extracted. Based on the simulation type, 
these parameters will be passed into the correct constructor to create a simulation object.

In SimulationGenerator:
```java
Simulation createSimulation(){
    type= scanned in through XMLReader;
    initial_config = scanned in through XMLReader;
    title =scanned in through XMLReader;
    parameters= list of parameters scanned in through XMLReader;
    
    if(type==Game of Life){
        return GameofLifeSim(inital_config, title)
    } else if(type==Fire){
        return FireSim(inital_config,title, parameters)
    }
}

```


## Design Considerations

This design was chosen because it prioritizes the separation between the model and 
view. By having separate Grid View/Model and Cell View/Model objects the frontend will only be responsible for displaying the
results of the simulation while leaving the logic to the models. A pro of this method is that this allows for single reponsibility of classes. 
A con is that it is more difficult to pass information around because information is spread among the different classes. 

One design issue discussed at length was how to communicate effectively between the front and backend. One possible 
option is to use the Observer pattern. Each CellView may subscribe to its corresponding CellModel so a color update is triggered
when the cell model is updated. Another option would be for the Simulation object to create a matrix of Color values that the
SimulationScene can then use to update the colors of each of the cells. One con of this is that it requires the passing around of large data structures.

Another design issues discussed at length was whether we want our design to allow for other shapes or just squares. Assuming a grid formation would be much simpler in terms 
of finding neighbors and creating the visualization. However, it is also less flexible. An alternative would be to create our "grid" as a HashMap instead of a 2D array where each cell is 
identified by a central point and neighbors are found via distances rather than neighboring indices. This would allow for more variety in 
simulations but also more complexity.

Lastly, we are not entirely sure how the simulator should be absolutely controlled by the XML file. Also, we are trying to give users more freedom in joining the simulation by allowing them to set all kinds of parameters. However, that does add ambiguity and uncertainty in designing basic components like cell and grid.


## Team Responsibilities

 * Team Member #1- Sophie
   * Primary: Create frontend consisting of two screens: the splash
   scene and the simulation screen. Simulation screen will display grid, simulation information, and simulation controls.
   * Secondary:  Incorporate simulation switching and saving abilites
 * Team Member #2- Andy
   * Primary: Create backend with the ability to apply simulation rules to a grid of cells
   * Secondary: Creates simulation objects for a variety of simulation types
 * Team Member #3- Shriya
   * Primary: Connect the front and back end so that the user interface is updated to reflect the changes of the model
     Secondary: Create XMLReader to extract info from files, create test files
    
By Friday, we will aim to have a basic Game of Life Simulator operational based on hardcoded simulation data. Then over the weekend, we will aim to have simuation data being read from a XML file and extend the program to other simulation types. Simultaneously we will work on adding
other functionality such as saving and switching simulations.
