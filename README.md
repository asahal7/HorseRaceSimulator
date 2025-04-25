HorseRaceSimulator

Java coursework for a horse race simulation game.

Description

The Horse Race Simulator is an interactive Java application that simulates a horse racing game with customizable horses, interactive track design, betting functionality, and race statistics.

The application is divided into two parts:

Part 1 (Text-based Simulator): Simulates a horse race in the console.
Part 2 (Graphical Simulator): Full-featured GUI version with interactive controls and visuals using Java Swing.

Features

Interactive Track Design
Horse Customization
Race Simulation
Betting System
Statistics and Analytics
Countdown Timer before the race starts
Finish Line Display
Installation and Setup Instructions

Prerequisites

Java JDK 8 or higher
No additional libraries required — only core Java (including Java Swing)
Step-by-Step Setup

Download or clone the project: git clone https://github.com/<your-username>/HorseRaceSimulator.git
Or unzip the provided .zip file.
Navigate to the project folder: cd HorseRaceSimulator
How to Compile and Run

You can use an IDE (like IntelliJ, Eclipse, or VS Code) or the command line.

Part 1: Text-Based Simulator
Compile:
javac Part1/*.java
Run:
java Part1.Main

(Main.java should call the startRace() method.)

Part 2: Graphical Simulator (GUI)
Compile:
javac Part2/*.java
Run:
java Part2.MainGUI

(MainGUI.java should call the startRaceGUI() method.)

Methods of Interest

startRace() — Used in Part 1 to start the console-based race.
startRaceGUI() — Used in Part 2 to start the GUI-based race.
These methods should be invoked from Main.java and MainGUI.java respectively.

File Structure Overview (Part2 folder unless stated otherwise)

BettingPanel.java — Betting interface and logic
GUIUtils.java — Utility/helper methods for GUI
HorseCustomizer.java — Customize horse attributes
HorseGUI.java — Display horse details and stats
HorsePanel.java — Visual representation of horses
MainGUI.java — Entry point for the GUI
RaceGUI.java — Race animation logic
RaceResultDialog.java — Displays results
StatisticsPanel.java — Race statistics
TrackCustomizer.java — Customize the race track
TrackPanel.java — Displays race track
Troubleshooting

Make sure Java is installed:
java -version
If using the command line, compile and run from the root HorseRaceSimulator directory.
If using an IDE, set Main.java or MainGUI.java as the main class.
No external tools or dependencies are needed. The program runs using standard Java.


