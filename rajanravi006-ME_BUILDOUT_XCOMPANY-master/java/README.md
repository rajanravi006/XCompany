# Pre-requisites
* Java 1.8/1.11/1.15
* Gradle 6

# How to run the code

We have provided scripts to execute the code. 

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows.  Both the files run the commands silently and results output in `out.txt` from the input file `sample_input/input1.txt`. You are supposed to add the input commands in the file from the appropriate problem statement.

Internally both the scripts run the following commands.

 * `./gradlew run -q --args="INPUT_FILE=sample_input/input1.txt OUTPUT_FILE=out.txt"` - This will compile all the .java files in the `src` directory and execute the Main - Class as specified below in build.gradle
 ```
 application {
    // Define the main class for the application.
    mainClass = 'com.example.App'
}
 ```
 We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.


 or another alternative


Internally both the scripts run the following commands 

 * `./gradlew clean build -x test --no-daemon` - This will create a jar file `example.jar` in the `build/libs` folder.
 * `java -jar build/libs/example.jar INPUT_FILE=sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

 We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

 Use the build.gradle file provided along with this project. Please change the main class entry under the `jar` task

 ```
 manifest {
        attributes 'Main-Class' : 'com.example.App' //Change this to the main class of your program which will be executed
    }
```
in the build.gradle if your main class has changed.



 # Running the code for multiple test cases


 Please fill `input1.txt` and `input2.txt` with the input commands and use those files in `run.bat` or `run.sh`. Replace `./gradlew run -q --args="INPUT_FILE=sample_input/input1.txt OUTPUT_FILE=out.txt"` with `./gradlew run -q --args="INPUT_FILE=sample_input/input2.txt OUTPUT_FILE=out.txt"` to run the test case from the second file. 


 or another alternative


 Please fill `input1.txt` and `input2.txt` with the input commands and use those files in `run.bat` or `run.sh`. Replace `java -jar build/libs/example.jar INPUT_FILE=sample_input/input1.txt OUTPUT_FILE=out.txt` with `java -jar build/libs/example.jar INPUT_FILE=sample_input/input2.txt OUTPUT_FILE=out.txt` to run the test case from the second file. 


 # How to execute the unit tests

 `./gradlew clean test --no-daemon` will execute the unit test cases.