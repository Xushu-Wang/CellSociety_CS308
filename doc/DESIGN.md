# Cell Society Design Final
### 03
### Shriya Challam, Andy Wang, Sophie Williams

IMAGE ICONS:
<a href="https://www.flaticon.com/free-icons/play" title="play icons">Play icons created by Freepik - Flaticon</a>
<a href="https://www.flaticon.com/free-icons/pause" title="pause icons">Pause icons created by inkubators - Flaticon</a>
<a href="https://www.flaticon.com/free-icons/upload" title="upload icons">Upload icons created by Ilham Fitrotul Hayat - Flaticon</a>
<a href="https://www.flaticon.com/free-icons/download" title="download icons">Download icons created by Debi Alpa Nugraha - Flaticon</a>
<a href="https://www.flaticon.com/free-icons/save" title="save icons">Save icons created by Yogi Aprelliyanto - Flaticon</a>
<a href="https://www.flaticon.com/free-icons/start" title="start icons">Start icons created by Freepik - Flaticon</a>

## Team Roles and Responsibilities

 * Team Member #1 - Andy Wang: Backend

 * Team Member #2 - Shriya Challam: Configuration and XML Files

 * Team Member #3 - Sophie Williams: Frontend



## Design goals

The goal of this project is to create a program that can simulate various kinds of cellular autonoma. 
The primary architecture design will allow a user to input a configuration file that contains the initial positions and states of different cells. Then depending on the type of simulation, the game will iterate through the progression of how the cells change over time.
The design should be flexible in allowing for a variety of rule sets to be applied to each cell as these rules are what will change from simulation to simulation.
This can be achieved by creating abstractions for each simulation class.
To ensure that the requirement for model-view separation is met, the backend will contain a model of cells and each of their statuses that is updated over time and the frontend will be updated to reflect these changes visually.

## High-level Design

#### Core Classes

Abstract

- Cell
- Grid
- Simulator
- StatisticsView

Not Abstract

- CellState
- CellView
- SimulationGenerator
- SceneController
- SplashScene
- SimulationScene

## Assumptions that Affect the Design

#### Features Affected by Assumptions

- Some of the assumptions we made are made by the different models:

    - Fire: when the tree has multiple burning neighbors, the chance of probability doesn't add up
    - Tumor: change of symmetric mitosis is much higher than biological probability
    - Foraging Ant: when the ant is foraging, the ant will always go away from the nest and when the ant is returning, it is always moving towards the nest. The ant never wanders
    - 


## Significant differences from Original Plan

- We didn't have many differences from the original plan. Because we thoroughly discussed the limitations and features of our current design, we were able to stick to it when implementing our project.

## New Features HowTo

#### Easy to Add Features

- adding multiple languages
- adding more cell shapes
- adding more customization through the config files -> ie: colors for cell type
- different kinds of neighbors

#### Other Features not yet Done

- adding language options: have to add a frontend element to select language, and then have different versions of the text.properties for various languages
- different neighbors
- different grid shape
- infinite grid

