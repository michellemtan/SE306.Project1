# SE306.Project1

## Run from the Command Line
1. Move all resources into the same directory as
2. Open up terminal/command line
3. `cd <path to where scheduler.jar is located> `
4. `java -jar scheduler.jar INPUT.dot P [OPTIONS]`

## Run from IntelliJ
1. Keep .dot files on the top project directory.
2. Change run configuration to include command line inputs to your liking
3. Run Main.main()
4. The output file should be in your top level directory of project

## Team:
| Name | UPI  | ID no.  |
|---|---|---|
| Allen Nian | ania716 | 958920712 |
| Dinith Wannigama | dwan609 | 834713594 |
| Hong Shi | hshi952 | 314381442 |
| Michelle Tan | mtan264 | 186674282 |
| Richard Ng | rng448 | 169182120 |
| Vanessa Ciputra | vcip451 | 804079209 |


## Overview:
This program takes in an input graph via a .dot file, this directed acyclic graph has nodes and edges with weights that represent processing time and communication costs between processors respectively. Each node represents a task which can be scheduled on a processor. This scheduler will find a valid schedule to return.

Inputs: `<INPUT.dot>` `<P>` `<[OPTION]>`
| Name | UPI  | 
|---|---|
| `<INPUT.dot>` | a task graph with integer weights in dot format |
| `<P>` | number of processors to schedule the INPUT graph on |

Optional Flags:

-o &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; OUTPUTNAME &nbsp; &nbsp; Specify output name of choice. Default output name is INPUT-output.dot

-p &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; NUMCORES &nbsp; &nbsp; &nbsp; &nbsp; Number of cores (processes) to use to produce/parallelise the schedule

--help &nbsp; &nbsp; HELP  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Prints usage info

## Build Maven project

1. Run `mvn package`. This should generate a target folder on top directory
2. Open up a terminal and cd to the target folder
3. Run `scheduler.jar`
4. It should run fine, if not, run `mvn clean` and try again.
5. The output file should be in the same directory as your jar. i.e top level directory in target folder

## For IntelliJ or eclipse users

Make sure to enable auto imports, as a maven project might mess with importing otherwise.

