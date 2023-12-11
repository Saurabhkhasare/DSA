package hashtable;


import java.util.LinkedList;
import java.util.Scanner;

public class HashTable {
	static class Pair {
		private int key; // key = roll
		private String value; // value = name

		public Pair() {
			key = 0;
			value = "";
		}

		public Pair(int key, String val) {
			this.key = key;
			value = val;
		}

		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}

	}

	private LinkedList<Pair> table[];
	private final int SLOTS = 10;

	public HashTable() {
		// Creating the table with the specified(SLOTS) size
		table = new LinkedList[SLOTS];
		for (int i = 0; i < SLOTS; i++) {
			//To initialize the linkedList pairs
			table[i] = new LinkedList<Pair>();
		}
	}

	public void put(int key, String value) {
		// find slot number by generating hashcode using hashfunction for the particular
		// key
		int slot = hashFunction(key);
		// find the bucket(Linked List) of that slot
		LinkedList<Pair> bucket = table[slot];
		// find the element(key-value) in that bucket (applying linear search)
		for (Pair pair : bucket) {
			// if key is duplicated then replace the value
			if (pair.key == key) {
				pair.value = value;
				return;
			}
		}
		// if key is new then create a pair
		Pair pair = new Pair(key, value);
		// and put it in the bucket(linked list)
		bucket.add(pair);
		System.out.println("ADDED : " + pair);
	}

	public String get(int key) {
		// find slot number by generating hashcode using hashfunction for the particular
		// key
		int slot = hashFunction(key);
		// find the bucket(Linked List) of that slot
		LinkedList<Pair> bucket = table[slot];
		// find the element(key-value) in that bucket (applying linear search)
		for (Pair pair : bucket) {
			if (pair.key == key)
				return pair.value;
		}
		// if key not found return null
		return null;
	}

	private int hashFunction(int key) {
		return key % SLOTS;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashTable ht = new HashTable();
		ht.put(1, "Kshitij");
		ht.put(4, "Arbaj");
		ht.put(5, "Saurabh");
		ht.put(7, "arun");
		ht.put(8, "harshal");
		ht.put(24, "prasad");	//collission for 4
		ht.put(35, "shubham"); //collission for 5
		ht.put(45, "nitin");	//collission for 5
//		ht.put(5, "lala");	//Replacing
		System.out.println("Enter the roll number: ");
		String name = ht.get(sc.nextInt());
		System.out.println("Name found: " + name);
		sc.close();
	}
}
