/*
ID: shoumik3
LANG: JAVA
TASK: ride
PROG: ride
*/
import java.io.*;

import java.util.*;

public class ride
{
	ArrayList<Character> charList = new ArrayList<Character>();
	int modedValue = 1;
	
	public ride(String line) {
		for(char character: line.toCharArray()) {
			charList.add(character);
		}
	}
	
	public int solve() {
		for(char character: charList) {
			modedValue = modedValue * (((int)character)-64);
			
		}
		System.out.println(modedValue);
		modedValue = modedValue % 47;
		return modedValue;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String line1 = br.readLine();
		ride YRIH1 = new ride(line1);
		String line2 = br.readLine();
		ride YRIH2 = new ride(line2);
		if(YRIH1.solve() == YRIH2.solve()) {
			out.println("GO");
		}else {
			out.println("STAY");
		}
		out.close();
	}
}
