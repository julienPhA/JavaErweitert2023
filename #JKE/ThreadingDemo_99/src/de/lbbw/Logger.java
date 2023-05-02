package de.lbbw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class Logger implements Runnable {

	@Override
	public void run() {
		File file = new File("log_"+Thread.currentThread().getName()+".txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < 5; i++) {
				writer.write(Instant.now()+" message from thread "+Thread.currentThread().getName());
				writer.newLine();
				System.out.println("Line written on thread "+Thread.currentThread().getName());
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
