# JavaFish

## Description

JavaFish was a project built on-top of a problem statement where a design was developed based on object orientated principles. An understanding of SOLID was used to aid in the development of the following designs utilised in the construction of the software artefact. The application was initialised with IntelliJ IDEA and developed using this IDE. JavaFish was also built depending on a Simulation Framework which is named JFF2 and can be found [here](/src/libraries/). A coding standard was also applied to the development of the application to aid in good practices.

## Design Documentation

Initially the problem was analysed initially by identifying requirements and then producing CRC Cards &  Use Case Descriptions.

### Problem Analysis

#### Requirements Analysis

Initially requirements were analysed to refine them to possess no ambiguities ensuring they are clear and can be worked on later in the design process.

**Functional Requirements:**
1.	The aquarium must have 20 pets with no interactions/collisions including 5 “JavaFish”, 5 “Seahorse”, 5 “Urchin” and 5 “Piranhas”.
2.	The “JavaFish” and “Piranha” should swim horizontally facing their direction and changing direction when colliding with the edge of the aquarium. The speed should be randomly chosen between 0.002 and 0.003 at startup.
3.	The “Seahorse” should swim diagonally with a random speed between 0.002 and 0.003 chosen at startup. It should change direction to stay within bounds of the aquarium and the starting position should be randomly chosen within the aquarium at startup.
4.	Each “Urchin” should appear to move along the bottom third of the aquarium with a speed chosen at startup between 0.002 and 0.003. The “Urchin” should begin with a random position in the bottom third of the aquarium and change direction when they hit the edge.
5.	The “JavaFish” should have a 0.25% chance to emit a bubble. Bubbles should move vertically upwards.

**Non-Functional Requirements:**
1.	The software must be built on the “Blank JavaFish Project” software project provided.
2.	The coding standard should be followed.

#### Use Case Analysis

Based off of the requirements use cases can be developed in order to further understand what is required for the application to function and meet the client's requirements. The following example represents this:

Name: UC01
Actor: App
Context: The highest-level class which aims to set up the scene.
Preconditions: The User has begun executing the program.
Main Flow:
1.	The App instantiates the Scene
2.	The App instantiates the AssetManager
3.	The App requests 5 JavaFish from AssetManager
4.	The App requests 5 SeaHorse from AssetManager
5.	The App requests 5 Urchin from AssetManager
6.	The App requests 5 Piranha from AssetManager
7.	The App adds all instantiated DisplayObjects to the Scene.
Alternative Flows: None
Exceptional Flows: None
Post Conditions: The App has now added all of the required Assets to the Scene.

### OO Software Design

#### UML Class Diagram

Following on from the initial problem analysis, UML designs can now be produced in order to display the system. UML diagrams such as Class Diagrams & Sequence Diagrams were used to showcase this. 

![UML Class Diagram](/docs/UML%20Class%20Diagram.png)

#### UML Sequence Diagram

A UML Sequence Diagram was also utilised in otder to design the system which can be viewed:

![A UML Sequence Diagram](/docs/UML%20Sequence%20Diagram.png) 