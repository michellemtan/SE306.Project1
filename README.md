# SE306.Project1 A* Scheduling Problem

## Run from the Command Line
1. Move all resources/input files into the same directory as where `scheduler-final-T4.jar` exists
2. Open up terminal/command line
3. Run `cd <path to where scheduler-final-T4.jar is located> `
4. Run `java -jar scheduler-final-T4.jar <INPUT.dot> <P> [OPTIONS]`

## Run from IntelliJ
1. Keep .dot files on the top project directory.
2. Change run configuration to include command line inputs to your liking
3. Run Main.main()
4. The output file should be in your top level directory of project

## Team:
| Name | UPI | ID no. | GitHub Username |
|---|---|---|---|
| Allen Nian | ania716 | 958920712 | anian100 |
| Dinith Wannigama | dwan609 | 834713594 | Dinith1 |
| Hong Shi | hshi952 | 314381442 | HongShi10 |
| Michelle Tan | mtan264 | 186674282 | michellemtan |
| Richard Ng | rng448 | 169182120 | Richardng12 |
| Vanessa Ciputra | vcip451 | 804079209 | vee-christella |


## Overview:
This program takes in an input graph via a .dot file, this directed acyclic graph has nodes and edges with weights that represent processing time and communication costs between processors respectively. Each node represents a task which can be scheduled on a processor. This scheduler will find a valid schedule to return.

- Run JAR: `java -jar scheduler-final-T4.jar <INPUT.dot> <P> [OPTIONS]`

| Required | Description | 
|---|---|
| `<INPUT.dot>` | A task graph with integer weights in dot format |
| `<P>` | Number of processors to schedule the INPUT graph on |

| Options | Description |
|---|---|
| `-p <NUMBER-OF-CORES>` | Use the specified number of cores to compute schedule in parallel |
| `-v` | Visualize the search |
| `-o <OUTPUT.dot>` | Name of file to save output schedule to |

- To get help:
  - `java -jar scheduler-final-T4.jar --help`
  - This will prints information on how to use the JAR file

## Build Maven project

1. Run `mvn package`. This should generate a target folder on top directory
2. Open up a terminal and cd to the target folder
3. Run `scheduler-final-T4.jar`
4. It should run fine, if not, run `mvn clean` and try again.
5. The output file should be in the same directory as your jar. i.e top level directory in target folder

## For IntelliJ or eclipse users

Make sure to enable auto imports, as a maven project might mess with importing otherwise.
