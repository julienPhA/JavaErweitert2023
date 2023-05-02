package de.lbbw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StartApplication07 {

	public static void demoArrayListPersonen() {
		
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person(111, "NameA", "StrasseZ"));
		persons.add(new Person(105, "NameC", "StrasseC"));
		persons.add(new Person(103, "NameB", "StrasseA"));
		
		System.out.println("Personen unsortiert:");
		
		for(Person p : persons) {
			System.out.println(p);
		}
		
		System.out.println("Personen sortiert:");
		
//		Collections.sort(persons); // nach ID sortiert
			
//		Collections.sort(persons, new PersonNameComparator()); 	//#1 nach Name sortiert (mit extra Klasse)

//		Collections.sort(persons, new Comparator<Person>() {	//#2 nach Name sortiert (mit anonymer Klasse, ohne extra Klasse)
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//						
//		});
		
		//#3 sortiere mit einer Lamda Expression
		
//		Collections.sort(persons, (Person o1, Person o2) -> { return o1.getName().compareTo(o2.getName()); }); 					

		//#4 sortiere mit einer Lamda Expression / verkürzter Code
		
		Collections.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()) );
		
		for(Person p : persons) {
			System.out.println(p);
		}
		
	}
	
	public static void demoArrayListStrings() {
		
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("StrasseB");
		strings.add("StrasseC");
		strings.add("StrasseA");
		
		System.out.println("Strings unsortiert:");
		
		for(String s : strings) {
			System.out.println(s);
		}
		
		System.out.println("Strings sortiert:");
		
		Collections.sort(strings);
		
		for(String s : strings) {
			System.out.println(s);
		}
				
	}
	
	public static void demoHashMap() {
		
		Person p1 = new Person(111, "NameA", "StrasseZ");
		Person p2 = new Person(105, "NameC", "StrasseC");
		Person p3 = new Person(103, "NameB", "StrasseA");
		Person p99 = new Person(111, "NameA", "StrasseZ");
		
		HashMap<Integer, Person> personMap = new HashMap<>();
		
		personMap.put(p1.getNr(), p1);
		personMap.put(p2.getNr(), p2);
		personMap.put(p3.getNr(), p3);
		
		
		if (personMap.containsKey(p99.getNr()) == false) {
			System.out.println("p99");
			personMap.put(p99.getNr(), p99);
		}
		
		int keyToFind = 111;
		
		Person p = personMap.get(keyToFind);
		
		if (p == null) {
			System.out.println("Person NICHT gefunden.");
		} else {
			System.out.println("Person gefunden: " + p.getName());
		}
				
		
	}
	
	public static void main(String[] args) {
		//demoArrayListStrings();
		//demoArrayListPersonen();
		demoHashMap();
	}

}
