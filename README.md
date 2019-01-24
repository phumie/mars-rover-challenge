# mars-rover-challenge

## Problem 

Rovers have been sent to Mars to survey the terrain and you have been charged with creating
their navigation system. The specifications of the challenge are listed below.

Mars’s surface can be thought of as a zone that is itself a two-dimensional grid of square areas.The zones have been very carefully surveyed ahead of time and are deemed safe for exploration within the landing terrain bounds, as represented by single cartesian oordinate - for example: (5, 5).

  * The rover understands the cardinal points and can face either East (E), West (W), North (N) or South (S) at any given time.
  
  * The rover understands three commands:
  
    - M - Move one space forward in the direction it is facing
    
    - R - rotate 90 degrees to the right
    
    - L - rotate 90 degrees to the left
 
    
  * Due to the transmission delay in communicating with the rover on Mars, you are only able to send the rover a single list of commands.
  
  * These commands will be executed by the rover and its resulting location sent back to HQ. This is an example of the list of commands sent to the rover:
  
    - 8 10
    
    - 12 E
    
    - MMLMRMMRRMML
    
This is how the rover will interpret the above commands:

 - The first line describes how big the current zone is. This zone’s boundary is at the Cartesian coordinate of 8,10 and the zone comprises 80 blocks.
  
  - The second line describes the rover’s starting location and orientation.
  
  - This rover would start at position 1 on the horizontal axis, position 2 on the vertical axis and would be facing East (E). The third line is the list of commands (movements and rotations) to be executed by the rover.
  
  - As a result of following these commands, a rover starting at **1 2 E** in this zone would land up at **3 3 S**.
  
You are to design a program which takes a text in the format as described above and then
displays its resulting rover location to the console.

## Installation and Tests

## Important notes

The code is based on the assumption that:

* The data will be read from a text file.
* There will only be one rover at a time.
* The rover coordinates and direction will in this format (**12 E**) or this formart (**1 2 E**).
