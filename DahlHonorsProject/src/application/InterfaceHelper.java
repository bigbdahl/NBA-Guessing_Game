package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;

public class InterfaceHelper {
	public static void quickSortByName(ArrayList<Player> players) { // quick sort method for sorting the arrayList
		if (players.size() <= 1) {
			return;
		}
		int pivotIndex = players.size() / 2;
		Player pivot = players.get(pivotIndex);
		ArrayList<Player> smaller = new ArrayList<>();
		ArrayList<Player> greater = new ArrayList<>();
		for (int i = 0; i < players.size(); i++) {
			if (i == pivotIndex) {
				continue;
			}
			Player player = players.get(i);
			if (player.getName().compareTo(pivot.getName()) < 0) {
				smaller.add(player);
			} else {
				greater.add(player);
			}
		}
		quickSortByName(smaller);
		quickSortByName(greater);
		players.clear();
		players.addAll(smaller);
		players.add(pivot);
		players.addAll(greater);
	}

	public static ArrayList<Player> playerReader() { // this method reads fullFile.txt, a mandatory file for file
														// reading
		ArrayList<Player> playerList = new ArrayList<>();
		try {
			String line;
			FileReader fr = new FileReader("fullFile.txt"); // sets file reader
			BufferedReader inFile = new BufferedReader(fr); // sets buffered reader
			line = inFile.readLine();
			while (line != null) // following loops prints file contents, while the next line has text
			{
				String[] array = line.split(",");
				int num = Integer.parseInt(array[4]);
				int height = Integer.parseInt(array[5]);
				int weight = Integer.parseInt(array[6]);
				int pref = Integer.parseInt(array[8]);
				playerList.add(
						new Player(array[0], array[1], array[2], array[3], num, height + 2, weight, array[7], pref));
				line = inFile.readLine();
			}
			inFile.close(); // closes file reader
		} catch (NotSerializableException e) { // catches NotSerializable exception
			System.out.println("Not serializable exception\n");
		} catch (IOException e) { // catches IO exception
			System.out.println("Data file read exception\n");
		}
		return playerList;
	}

	public static ArrayList<Player> starterReader() { // this method reads fullFile.txt, a mandatory file for file
		// reading
		ArrayList<Player> starterList = new ArrayList<>();
		try {
			String line;
			FileReader fr = new FileReader("fullFile.txt"); // sets file reader
			BufferedReader inFile = new BufferedReader(fr); // sets buffered reader
			line = inFile.readLine();
			while (line != null) // following loops prints file contents, while the next line has text
			{
				String[] array = line.split(",");
				int num = Integer.parseInt(array[4]);
				int height = Integer.parseInt(array[5]);
				int weight = Integer.parseInt(array[6]);
				int pref = Integer.parseInt(array[8]);
				if (pref == 1) {
					starterList.add(new Player(array[0], array[1], array[2], array[3], num, height + 2, weight,
							array[7], pref));
				}
				line = inFile.readLine();
			}
			inFile.close(); // closes file reader
		} catch (NotSerializableException e) { // catches NotSerializable exception
			System.out.println("Not serializable exception\n");
		} catch (IOException e) { // catches IO exception
			System.out.println("Data file read exception\n");
		}
		return starterList;
	}
}
