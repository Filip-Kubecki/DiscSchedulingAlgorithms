# Disc Scheduling Algorithms
A university project designated to test disc scheduling algorithms based on different types of loads.
Algorithms implemented in this project:
- FCFS
- SSTF
- SCAN
- C-SCAN
- EDF
- FD-SCAN

Project also contains graphical interface allowing user to see path of the disc head along different algorithms.\
In GUI u can choose what algorithm u want to test and specify the number of requests given to algorithm and the size of the disc along which it will move. 
Each simulation of the algorithm returns:
- Total time of simulation (given in pseudo-time units),
- Sum of all head movements,
- Number of killed requests (only for real-time algorithms: EDF and FD-Scan),

To create simulation, you set the parameters located at the bottom of the window and press the button with the name of the algorithm that you want to test.
If u want to test all algorithms with the same data, you have to press the box "Pre generate" which is located on the right side of the window under the simulation results. 
It will also display a comparison of the sum of all head movements of all algorithms in the table under the checkbox.\
\
![image](https://github.com/Filip-Kubecki/DiscSchedulingAlgorithms/assets/117228148/69aa27c2-516f-450c-99a7-b9e1a6a51701)
