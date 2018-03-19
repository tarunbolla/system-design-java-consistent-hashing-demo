package com.sd.hasing.consistent;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	private static List<CacheMachine> cacheMachines = new ArrayList<CacheMachine>();
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Welcome to Cache Machine!");
		DataInputStream din = new DataInputStream(System.in);
		
		while(true) {
			System.out.println("1. Add Machine");
			System.out.println("2. Remove Machine");
			System.out.println("3. List Machines");
			System.out.println("4. Cache Item");
			System.out.println("5. Retrive Item");
			System.out.println("Enter Choice: ");
			String command = din.readLine();
			
			CacheMachine machine = null;
			String input;
			
			switch(command) {
			case "1":
				System.out.println("Machine Name, position: ");
				input = din.readLine();
				String[] data = input.split(",");
				machine = new CacheMachine(Integer.parseInt(data[1]), data[0]);
				cacheMachines.add(machine);
				System.out.println("Added machine: " + machine.getName());
				Collections.sort(cacheMachines, new Comparator<CacheMachine>() {

					@Override
					public int compare(CacheMachine o1, CacheMachine o2) {
						return o1.getPosition() - o2.getPosition();
					}

				});
				break;
			case "2":
				System.out.println("Position: ");
				input = din.readLine();
				for(CacheMachine m : cacheMachines) {
					if(m.getPosition() == Integer.parseInt(input)) {
						machine = m;
						break;
					}
				}
				cacheMachines.remove(machine);
				System.out.println("Removed machine: " + machine.getName());
				break;
			case "3":
				for(CacheMachine m : cacheMachines) {
					System.out.println(m.getPosition() + "\t" + m.getName());
				}
				break;
			case "4":
				System.out.println("Enter key, Item: ");
				input = din.readLine();
				data = input.split(",");
				int key = Integer.parseInt(data[0]);
				for(CacheMachine m : cacheMachines) {
					if(m.getPosition() >= key) {
						m.putItem(key, data[1]);
						System.out.println("Item cached in machine: " + m.getName());
						break;
					}
				}
				break;
			case "5":
				System.out.println("Enter key: ");
				input = din.readLine();
				key = Integer.parseInt(input);
				for(CacheMachine m : cacheMachines) {
					if(m.getPosition() >= key) {
						System.out.println("Item retrieved: " + m.getCache().get(key));
						break;
					}
				}
				break;
			}
		}
	}
}
