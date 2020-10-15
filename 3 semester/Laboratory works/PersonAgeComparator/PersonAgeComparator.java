package personagecomparator;
import java.util.*;



class PersonAgeComparator implements Comparator <Person>{
public int compare(Person P1, Person P2){
        if (P1.age == P2.age)
            return -(P1.name.compareTo(P2.name));
            return (P1.age - P2.age);
}


public static void main(String[] args) {
    PersonAgeComparator agecomp = new PersonAgeComparator();
    ArrayList<Person> ppllist = new ArrayList<Person>();
    
    ppllist.add(new Person("Viktor", 18));
    ppllist.add(new Person("Lev",19));
    ppllist.add(new Person("Dimas",17));
    ppllist.add(new Person("Nubas",1));
    
    ppllist.sort(agecomp);
    for(Person p : ppllist){
        System.out.println(p.name + " - " + p.age);
        }           
    }

}