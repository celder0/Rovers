# Rover Project

Project is setup as a standard gradle project for brevity use gradlew in excahnge for .gradlew if on PC
## Setup
```shell script
.gradlew build
```
This should install all dependencies

## Run Tests
```shell script
.gradlew test
```

## Usage
To run:
```shell script
java -jar build/libs/<Jarfile> <Path to config file>
```

Config file should look like below

First Line: X size then Y size of plateau

Subsequent 2 line groupings for each rover
* Starting X Y and Heading
* Instructions L(Left), R(Right), M(Move forward)

Ex. 
```text
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM 
```

Then you should see an output for each rover with its final position and heading

For the above it should be
```text
1 3 N
5 1 E
```