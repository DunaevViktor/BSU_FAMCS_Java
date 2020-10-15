
package lab4;


class Exam
{
    String subj;
    int hours;
    int zachet;
    String teacher;
    int result;
    
    Exam(){
        subj = "";
        hours = 0;
        zachet = 0;
        teacher = "";
        result = -1;
    }
}
public class Session {
    int number=0; 
    int maxSize = 4;
    Exam[] exam = new Exam[maxSize];
    Subject s = new Subject();
    Teacher t = new Teacher();
    int year;
    
    Session(){
        for(int i=0;i<maxSize;i++){
            exam[i] = new Exam();
        }
    }
            
    Session(int n){
        number=n;
    }
    Session(int n,int m){
        number=n;
        maxSize = m;
        Exam[] exam= new Exam[maxSize];
        for(int i=0;i<maxSize;i++){
            exam[i] = new Exam();
        }
    }
    
    void create(Subject[]S, Teacher[]T){
        Subject[] ressubj;
        Teacher restea;
        ressubj = s.searchSession(S,number);
        maxSize = ressubj.length;
        for(int i=0;i<maxSize;i++){
            exam[i] = new Exam();
        }
        //System.out.println("Maxsize =  "+ maxSize);
        for(int i=0;i<ressubj.length;i++){
            exam[i].hours=ressubj[i].hours;
            exam[i].subj=ressubj[i].name;
            exam[i].zachet=ressubj[i].zachet;
            //System.out.println("For search =  "+ exam[i].subj + ", " + number);
            restea = t.search(T, exam[i].subj, number);
            //System.out.println("Teacher =  "+ restea.name);
            exam[i].teacher = restea.name;
        }
    }
    void giveMark(String subj, int mark){
        for(int i=0;i<maxSize;i++){
            if(exam[i].subj.compareTo(subj)==0)
            exam[i].result = mark;
        }
    }
    void giveYear(int year1){
        year = year1;
    }
    void outFunc(){
        System.out.println("Номер = " + (number) + ", Год = " + year + ", Экзамен: ");
        for(int i=0;i<maxSize;i++){
            System.out.println("Предмет = "+exam[i].subj + ", Часы = "+exam[i].hours + ", Тип = "+exam[i].zachet +
                    ", Учитель = "+exam[i].teacher + ", Результат = "+exam[i].result);
        }
    }
    
}
