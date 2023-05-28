# Cell Society
## TEAM 3
## Sophie Williams, Andy Wang, Shriya Challam


This project implements a cellular automata simulator.

### Timeline

 * Start Date: Jan 26th, 2023

 * Finish Date: Feb 13th, 2023

 * Hours Spent: 120 - 150 hours in total



### Attributions

 * Resources used for learning (including AI assistance): 
   * Assignments from different universities and wikipedia specifying rules for different model. 
   * JavaFX GUIs (sections 4-5)
 
 * Resources used directly (including AI assistance): 
   * TwoDArrayIterator (can be used in the future) by ChatGPT


### Running the Program

 * Main class: The Main class is essentially a scenecontroller that generates a simulation scene including
every front-end feautures. 

 * Data files needed: XML File as an input, Property file, style file, and images files. 

 * Interesting data files: N/A

 * Key/Mouse inputs: Mouse is needed for clicking on buttons & cells.



### Notes/Assumptions

 * Assumptions or Simplifications:
   * Segregation Model: Each person
   * Foraging Ant Model: An ant will only goes up and right when foraging, down and left when returning to the nest.
   The nest is always at the left bottom corner. 
   * Other Models may all have some natural simplification to real life.

 * Known Bugs:
   * Foraging Ant is not working as supposed, pheromone never updated, and ant never moving upward

 * Features implemented:
   * 7 Models: seven models: Foraging Ants, Tumor (An detailed explanation is on the NetLogo website, it tries to simulate a tumor in human body), Game of Life, Spreading of Fire, Percolation, Schelling's model of segregation,
     and waTor Predator and Prey Model.
   * Allow users to run any number of simulations at the same time so they can compare the results side by side
   * Allow any number of different Views of a simulation at the same time
   * Allow users to interact with any simulation values dynamically such that each change takes immediate effect on the current simulation
   * Error checking for incorrect file data, such as (but definitely not limited to) 
   * Allow the initial configuration of the cell states to be set in different ways
   * Allow any aspect of a simulation to be "styled"

 * Features unimplemented:
   * Support any kind of neighbours in the model
   * Support infinite grid (grid without edges)
   * Several Models are left unimplemented, including FallingSand, SugarScape, and Langton's loop.
   * Remark: Above features can be implemented without changing the front-end.
     * Changing neighbours can be instantiated in xml file and properties file. The model will switch to the particular kind of neighbour
     after receiving the parameter. However, certain rules in controlling the model should also change.
     * Infinite grid can be realized by changing the back-end data structure from 2D grid into list of lists.
     * More models can be easily added given the level of abstraction. 

 * Noteworthy Features:
   * Support the user to change the color of cells.
   * Support the user to change the state of each cell.
   * Support the user to update parameter by providing a parameter
   * Support checking current Statistics
   * Including seven models: Foraging Ants, Tumor (An detailed explanation is on the NetLogo website, it tries to simulate a tumor in human body), Game of Life, Spreading of Fire, Percolation, Schelling's model of segregation,
   and waTor Predator and Prey Model.
   * Support the user to upload/save the initial/current states of the cell.
   * Support the user to play and pause animation at any time, and move one step further at any stage. 
   * Support the user to manipulate the speed of the animation. 

### Assignment Impressions


