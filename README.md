# Fiery Dragons Game
Welcome to Fiery Dragons Game! This is a simple Java game project where you can enjoy a fun dragon-themed game.
## Introduction
Fiery Dragons is a Java game developed using Swing for GUI. It involves exploring a tile-based world filled with various creatures and objects. The game panel displays the game environment and allows interaction through mouse clicks.

Purpose: Instructions on how to build and run the executable of this software prototype.
Target Platform(s): the executable is using Java, all platforms are able to run the file
as long as an appropriate JDK is installed on the user's machine.

## Getting Started
To run the game, you need to have Java installed on your system. Follow these steps:

### Prerequisites
Java Development Kit (JDK) installed on your system.
if JDK is unavailable on device follow below to download:

### Download JDK
1. Install JDK21 on whichever machine that will be running the software.

   Linux: https://www.oracle.com/au/java/technologies/downloads/#java21
   macOS: https://www.oracle.com/au/java/technologies/downloads/#jdk21-mac
   Windows: https://www.oracle.com/au/java/technologies/downloads/#jdk21-windows

2. Complete the installation of the Java JDK by following the steps of the installer

Note: URLs provided are for reference and may change. You can navigate to the respective Oracle JDK download page for your platform.

### SDK Set up
1. Set up the SDK for the file by going to:
   "File -> Project Structure..." [shortcut "Ctrl + Alt + Shift + S"]
   Click on the "Project" Tab

2. Under project, click on the drop-down bar next to the sub-heading SDK
3. Click on "+ ADD SDK" then "JDK...", find the directory of the downloaded JDK and click
   on the whole file to add the JDK to the project
4. Click on "Apply" then "OK" to finish the SDK set up

## Build Executable
1. Set up the SDK for the file by going to:
   "File -> Project Structure..." [shortcut "Ctrl + Alt + Shift + S"]
   Click on the "Artifacts" Tab
2. On the top left of the window, a "+" symbol will be present, add a new artifact by clicking this
3. Click on the JAR title
4. Then click on the "From modules with dependenices..." title, a new window will appear
5. Next to the title "Main Class:" click on the folder icon and either search the main class
   however it should appear on the window "Main (main)". Click ok after selecting the main class
6. Click on "Apply" then "OK" to finish making an artifact set up
7. After navigate to the "Build" tab on the top
8. Once it has been found, click on the tab and find the "Build Artifacts.." and click on that option
9. A pop-up will appear, and click build
10. An executable as been created it will be located in the out folder:
    📦fieryDragons
    ┗ 📂out
    ┗ 📂artifacts
    ┗ 📂fieryDragonsGame_jar
    ┗ 📜fieryDragonsGame.jar

## Run Executable
Option 1:
1. Locate the jar file and double click to open the executable

Option 2:
1. Change directory in the terminal to where the jar file is being kept write in the terminal
   "cd C:\Users\annie\IdeaProjects\CL_Monday06pm\out\artifacts\fieryDragonsGame_jar"
   change based on where the user has saved the jar file
2. In the terminal write " java -jar fieryDragonsGame.jar"


## How to Play
- Upon launching the game, you will see the game window titled "Fiery Dragons."
- The window will let you know which player's turn it is.
- Flip cards to try and match the image on the next tile.
- Flip them back after your turn is done. 
- Dragons cannot be on the same tile.
- Complete a round around the game board first to win.

## Features
- Tile-based world generation.
- Dynamic object rendering.
- Mouse interaction for gameplay.
- Simple game loop implementation for updates and rendering.

## Dependencies
- Java Swing library

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



