package com.cleantutorials.jconsole.cpu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * A class to demonstrate the CPU usage in the system space and the user space as seen in JConsole.
 * Note: Only to demonstrate an example, manually kill the process if you want to run the example or it can eat up
 * a lot of resources.
 */
public class CPUUsage {
	public static void main(String[] args) throws IOException, InterruptedException {
		GenerateRandomNumner generator = new GenerateRandomNumner();
		generator.setName("Random Generator");
		generator.start();
	}
}

/**
 * Thread that generates random number and write it to a file replacing the older content. Used in demonstrating the 
 * CPU time and User time in JConsole.
 */
class GenerateRandomNumner extends Thread {
	@Override
	public void run() {	
		File file = new File("random_numbers.txt");
 		Random rand = new Random();
 		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
 			while(true) {
 				// Contributes to the time executing calls in user space.
 				String randomNumer = Integer.toString(rand.nextInt());
	 			// Contributes to the time executing calls in kernel space
 				br.write(randomNumer);	 				
 			}
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
