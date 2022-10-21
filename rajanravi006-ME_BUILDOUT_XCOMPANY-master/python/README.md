# Pre-requisites
* Python 3.8/3.9
* Pip

# How to run the code

We have provided scripts to execute the code. 

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows.  Both the files run the commands silently and results output in `out.txt` from the input file `sample_input/input1.txt`. You are supposed to add the input commands in the file from the appropriate problem statement. 

Internally both the scripts run the following commands 

 * `python3 -m app INPUT_FILE=sample_input/input1.txt OUTPUT_FILE=out.txt` - This will run the solution passing in the sample input file as the command line argument

If you are providing a solution without using the build file, we want you to name your Main file as geektrust.py. This is the file that will contain your main method.

 We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

 # Running the code for multiple test cases

 Please fill `input1.txt` and `input2.txt` with the input commands and use those files in `run.bat` or `run.sh`. Replace `python3 -m xcompany INPUT_FILE=sample_input/input1.txt OUTPUT_FILE=out.txt` with `python3 -m xcompany INPUT_FILE=sample_input/input2.txt OUTPUT_FILE=out.txt` to run the test case from the second file.

 # How to execute the unit tests

 `python3 -m unittest -v tests/*.py` will execute all the unit test cases.