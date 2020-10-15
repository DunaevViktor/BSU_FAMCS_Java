package personagecomparator;

class Person implements Comparable<Person>{
String name;
int age;

public Person(String p, int a){
        name=p;
        age = a;
    }

public int compareTo(Person P){
        return this.name.compareTo(P.name);
    }

}