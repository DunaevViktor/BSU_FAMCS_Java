package ZachetnayaKnijka;


public class ZachetnayaKnijka {

   
    public static void main(String[] args) {
     
        Subject[] S;Subject G = new Subject();
        InputFile I1 = new InputFile("a.txt");
        S = G.getSubject(I1);
       for(int i=0;i<(S.length);i++)
       {
           S[i].outFunc();
       }
       TeacherClass[] T; TeacherClass F = new TeacherClass();
       InputFile I2 = new InputFile("teacherList.txt");
       T = F.getTeacherList(I2);
       for(int i=0;i<(T.length);i++)
       {
           T[i].outFunc();
       }
        Gradebook GB = new Gradebook("prof",1);
    
    
        //Session[] Sess = new Session[ GB.NUMofSessions];
        for(int i=0;i<GB.returnNUM();i++)
        {
           GB.SessionMass[i].sessionConstantsInput(S);
           GB.findTeachersName(T);
           //GB.SessionMass[i]. //?
        }
        
        for(int i=0;i<GB.returnNUM();i++)
        {
            
            for(int j=0;j<GB.SessionMass[i].n;j++)
            {
                System.out.println(GB.SessionMass[i].Sstring[j].hours + " " + i + " " + j +" "+ GB.SessionMass[i].Sstring[j].subjName
                + " " + GB.SessionMass[i].Sstring[j].teacherName);
            }
        }
        //GB.SessionMass[0].sessionConstantsInput(S);
    
    }
   
    
    /*
    */
}
