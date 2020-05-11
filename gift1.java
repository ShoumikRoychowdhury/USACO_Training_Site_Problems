/*
ID: shoumik3
LANG: JAVA
TASK: gift1
PROG: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

import java.util.*;

public class gift1 {

	class Person {
		String name;
		int amount ;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public void updateAmount(int amount) {
			this.amount += amount;
		}

		Person(String name, int amount) {
			this.name = name;
			this.amount = amount;
		}
		Person(String name) {
			this.name = name;
			this.amount = 0;
		}
		public String toString() {
			return this.name + " " + this.amount;
		}
		
		public void print() {
			System.out.println(toString());
		}

		public void updateAmountAsReceiver(int distAmount) {
			this.amount += distAmount;
		}

		public void updateAmountAsGiver(int origAmount, int leftAmount) {
			this.amount -= origAmount;
			this.amount += leftAmount;
		}
	}
	
	
	public void readData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		ArrayList<Person> persons = new ArrayList<Person>();
		int numPersons = Integer.valueOf(br.readLine());
		for (int i = 0; i < numPersons; i++) {
			persons.add(new Person(br.readLine()));
		}

		boolean moreLines  = true;
		while (moreLines) {
			String line = br.readLine();
			if (line == null) {
				//System.out.println("No more lines to read");
				moreLines = false;
			}
			//System.out.println("line: " + line);
			
			Person giver = findPerson(line, persons);
			if (giver != null) {
				String amountToPersons = br.readLine();
				StringTokenizer stz = new StringTokenizer(amountToPersons);
				int origAmount = Integer.valueOf(stz.nextToken());
				int numReceivers = Integer.valueOf(stz.nextToken());
				int distAmount = 0;
				int leftAmount = 0;
				if (numReceivers > 0) {
					distAmount = origAmount / numReceivers;
					leftAmount = origAmount - (distAmount * numReceivers);
				}
				else {
					distAmount = origAmount;
					leftAmount = origAmount;
				}
				
				for (int i = 0; i < numReceivers; i++) {
					String receiver = br.readLine();
					Person receiverPerson = findPerson(receiver, persons);
					if (receiverPerson != null) {
						receiverPerson.updateAmountAsReceiver(distAmount);
					}
				}
				giver.updateAmountAsGiver(origAmount, leftAmount);
				//System.out.println("---------------------");
				//for (Person person : persons) {
				//	person.print();
				//}
			}
		}
		for (Person person : persons) {
			out.println(person.toString());
		}
		out.close();
	}
	

	private Person findPerson(String line, ArrayList<Person> persons) {
		for (Person person: persons) {
			if (person.getName().equals(line)) {
				return person;
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		gift1 gift2ref = new gift1();
		gift2ref.readData();
	}
}
