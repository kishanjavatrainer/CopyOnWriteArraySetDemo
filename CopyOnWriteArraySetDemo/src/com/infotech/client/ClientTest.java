package com.infotech.client;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * This program demonstrates how a CopyOnWriteArraySet works in multi-threading
 * context.
 */
public class ClientTest {

	public static void main(String[] args) {
		Set<Integer> set = new CopyOnWriteArraySet<Integer>();
		// Adding 5 elements to the set
		for (int i = 1; i <= 5; i++) {
			set.add(i);
		}
		// Creating new thread
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// introducing some delay
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				// add new element to the set
				set.add(6);
				System.out.println("" + set);
			}

		}).start();

		// get an iterator
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			Integer i = itr.next();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// itr.remove();
			System.out.println("" + i);
		}
	}
}
