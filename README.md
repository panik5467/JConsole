# JConsole
The project contains the list of examples used in the complete JConsole Tutorial hosted at [CleanTutorials.](http://www.cleantutorials.com)

## Project Breakdown
* Connecting JConsole    
* Memory Profiling 
* Thread Profiling
* CPU Hotspot Analysis
* MBeans

## Memory Profiling
The memory profiling example demmonstrates how an error in the programming logic can lead to gradual increase in Memory and eventually lead to OutOfMemoryError. The example can be found in the following package.

```
src.main.java.com.cleantutorials.jconsole.memory
```
Either you can import the maven project in your IDE and run the main file in the above package or use the following command.
```
mvn exec:java -Dexec.mainClass="com.cleantutorials.jconsole.memory.DogShelter"
```
After running the Main Class we can connect the JConsole to the Java Process and see the Heap Memory grow and eventually crash.
