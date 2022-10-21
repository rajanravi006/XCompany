@echo off

:: .\gradlew clean build -x test --no-daemon
:: java -jar build\libs\example.jar sample_input\input1.txt OUTPUT_FILE=out.txt

:: or
.\gradlew run -q --args="INPUT_FILE=sample_input\input1.txt OUTPUT_FILE=out.txt" 