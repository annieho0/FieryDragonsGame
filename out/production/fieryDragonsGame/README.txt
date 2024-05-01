//Instructions on how to run the file //
------------------------
author: Annie Ho
studentId: 33156581
------------------------

Purpose: Instructions on how to build and run the executable of this software prototype.
Target Platform(s): the executable is using Java, all platforms are able to run the file
as long as an appropriate JDK is installed on the user's machine.

************ INSTRUCTIONS ************
##Download JDK
1. Install JDK21 on whichever machine that will be running the software.

    Linux: https://www.oracle.com/au/java/technologies/downloads/#java21
    macOS: https://www.oracle.com/au/java/technologies/downloads/#jdk21-mac
    Windows: https://www.oracle.com/au/java/technologies/downloads/#jdk21-windows

    (was used to download on Windows machine:
    https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe)

2. Complete the installation of the Java JDK by following the steps of the installer

## SDK Set up
3. Set up the SDK for the file by going to:
    "File -> Project Structure..." [shortcut "Ctrl + Alt + Shift + S"]
    Click on the "Project" Tab

4. Under project, click on the drop-down bar next to the sub-heading SDK
5. Click on "+ ADD SDK" then "JDK...", find the directory of the downloaded JDK and click
on the whole file to add the JDK to the project
6. Click on "Apply" then "OK" to finish the SDK set up

## Build Executable
7. Set up the SDK for the file by going to:
       "File -> Project Structure..." [shortcut "Ctrl + Alt + Shift + S"]
       Click on the "Artifacts" Tab
8. On the top left of the window, a "+" symbol will be present, add a new artifact by clicking this
9. Click on the JAR title
10. Then click on the "From modules with dependenices..." title, a new window will appear
11. Next to the title "Main Class:" click on the folder icon and either search the main class
however it should appear on the window "Main (main)". Click ok after selecting the main class
12. Click on "Apply" then "OK" to finish making an artifact set up
13. After navigate to the "Build" tab on the top
14. Once it has been found, click on the tab and find the "Build Artifacts.." and click on that option
15. A pop-up will appear, and click build
16. An executable as been created it will be located in the out folder:
📦fieryDragons
 ┗ 📂out
   ┗ 📂artifacts
     ┗ 📂fieryDragonsGame_jar
        ┗ 📜fieryDragonsGame.jar

## Run Executable
Option 1:
17. Locate the jar file and double click to open the executable

Option 2:
18. Change directory in the terminal to where the jar file is being kept write in the terminal
    "cd C:\Users\annie\IdeaProjects\CL_Monday06pm\out\artifacts\fieryDragonsGame_jar"
    change based on where the user has saved the jar file
19. In the terminal write " java -jar fieryDragonsGame.jar"

************************************************

WOOOOOOOO you did it!!

The executable should be able to run now. BYE FOR NOW!

