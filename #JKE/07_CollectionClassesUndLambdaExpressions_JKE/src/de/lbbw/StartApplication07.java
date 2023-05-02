package de.lbbw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class StartApplication07 {

	public static void demoArrayListStrings() {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("Stroustrup");
		strings.add("Ritchie");
		strings.add("Gosling");
		System.out.println("Strings unsortiert");
		for(String s : strings) {
			System.out.println(s);
		}
		Collections.sort(strings);
		System.out.println("Strings sortiert");
		for(String s : strings) {
			System.out.println(s);
		}

	}
	/**
	 * demonstriert den Umgang mit einer ArrayList
	 */
	public static void demoArrayListPerson() {
		// Eine ArrayList kapselt ein herkömmliches Array als privates Attribut
		// -> alle Elemente des Arrays stehen dabei hintereinander im Speicher
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person(101, "Stroustrup"));
		persons.add(new Person(100, "Ritchie"));
		persons.add(new Person(102, "Gosling"));
		System.out.println("Personen unsortiert");
		for(Person p : persons) {
			System.out.println(p);
		}
		Collections.sort(persons);
		System.out.println("Personen 'natuerlich' sortiert");
		for(Person p : persons) {
			System.out.println(p);
		}
		// #1 sortiere mit einer PersonNameComparator Klasse
		Collections.sort(persons,new PersonNameComparator());
		System.out.println("Personen nach Name sortiert");
		for(Person p : persons) {
			System.out.println(p);
		}
		// #2 sortiere mit einer anonymen Klasse
		Collections.sort(persons,new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getNr()-o2.getNr();
			}
		});
		System.out.println("Personen nach Nr sortiert");
		for(Person p : persons) {
			System.out.println(p);
		}
		// #3 sortiere mit einer Lambda expression 
		// ( = anonymes Methodenobjekt)
		Collections.sort(persons,(Person o1, Person o2)->{return o1.getName().compareTo(o2.getName());});
		System.out.println("Personen nach Name sortiert");
		for(Person p : persons) {
			System.out.println(p);
		}
		// #4 sortiere mit einer verkürzten Lambda expression 
		// ( = anonymes Methodenobjekt)
		Collections.sort(persons,(o1, o2) -> o1.getNr() - o2.getNr() );
		System.out.println("Personen nach Nr sortiert");
		for(Person p : persons) {
			System.out.println(p);
		}
	
	}
	
	public static void demoHashMap() {
		// Eine Hashmap speicher key-value Paare
		HashMap<Integer,Person> personMap = new HashMap<>();
		Person p1 = new Person(101, "Stroustrup");
		Person p2 = new Person(100, "Ritchie");
		Person p3 = new  Person(102, "Gosling");
		personMap.put(p1.getNr(),p1);
		personMap.put(p2.getNr(),p2);
		personMap.put(p3.getNr(),p3);
		// Eine Hashmap ist besonders performant, wenn nach dem Key gesucht wird:
		int keyToFind = 999;
		System.out.println("Suche nach Person mit Nr= "+keyToFind);
		Person p = personMap.get(keyToFind);
		if(p==null) {
			System.out.println("Person mit Nr  = "+keyToFind+" nicht gefunden");
		} else {
			System.out.println("Gefunden: "+p);
		}
		System.out.println("Alle keys und values der HashMap");
		for(Integer key : personMap.keySet()) {
			System.out.println("Key: "+key+" value "+personMap.get(key));
		}
		
	}
	
	public static void demoSplitMethode() {
		String s = "ALPHA;BETA;GAMMA";
		// trenne den String s mit Hilfe des Trennzeichens ;
		String[] spalten = s.split(";");
		for(String spalte : spalten) {
			System.out.println(spalte);
		}
	}
	
	public static void main(String[] args) {
		// demoArrayListPerson();
		// demoArrayListStrings();
		// demoHashMap();
		demoSplitMethode();
	}

}
