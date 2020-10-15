/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZachetnayaKnijka;

/**
 *
 * @author Лев
 */
public class Gradebook {
    String studentName;
    int admissionYear;
    int groop;
    int gradebookNumber;
    Session[] SessionMass;
    public static int NUMofSessions = 2;
    Gradebook(String nameS, int bookNum)
    {
        studentName = nameS;
        gradebookNumber = bookNum;
        SessionMass = new Session[NUMofSessions];
        for(int i=0;i<NUMofSessions;i++)
        {
            SessionMass[i] = new Session(i);
        }
    }
    public int returnNUM()
    {
        return NUMofSessions;
    }
    public void getGroop(int groop1)
    {
        groop = groop1;
    }
    public void getgradebookNumber (int gbN1)
    {
        gradebookNumber = gbN1;
    }
    public void getSessions(Session[]S)
    {
        if(S.length != NUMofSessions)
        {
            System.out.println("Неправильное количество сессий!!!");
            return;
        }
        for(int i=0;i<NUMofSessions;i++)
        {
            SessionMass[i].sessionCopy(S[i]);
        }
    }
    public void getTeacherName(TeacherClass[] T)
    {
        
    }
    public void findTeachersName(TeacherClass[] T)
    {
        for(int i=0;i<NUMofSessions;i++)
        {
            for(int j=0;j<this.SessionMass[i].n;j++)
            {
                TeacherClass temp = new TeacherClass();
                this.SessionMass[i].Sstring[j].teacherName = temp.returnName(T, 
                        SessionMass[i].Sstring[j].subjName,
                        SessionMass[i].Sstring[j].sessionNum,
                        SessionMass[i].Sstring[j].type,groop);
            }
        }
        
    }
    public void print()
    {
        for(int i=0;i<NUMofSessions;i++)
        {
            for(int j=0;j<this.SessionMass[i].n;j++)
            {
            System.out.print(SessionMass[i].Sstring[j].subjName + " = subjName, " );
            System.out.print(SessionMass[i].Sstring[j].sessionNum + " = sessionName, ");
            System.out.print(SessionMass[i].Sstring[j].type + " = type, " + groop + " = groop");
            }
            
        }
    }
}
