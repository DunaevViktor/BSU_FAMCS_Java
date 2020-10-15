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
class SessionString
{
    String subjName;
    int hours;
    int type;
    int sessionNum;
    String teacherName;
}
public class Session {
    
    int n=0;static int maxSize =3;
    SessionString[] Sstring = new SessionString[maxSize];
    Session(int SN)
    {
        for(int i=0;i<maxSize;i++)
        {
            Sstring[i]=new SessionString();
            Sstring[i].sessionNum = SN;
        }
        
    }
    public void sessionConstantsInput(Subject[] S)
    {
        
        for(int i =0 ;i<S.length;i++)
        {
            if(S[i].sessionNum == Sstring[n].sessionNum)
            {
                Sstring[n].hours=S[i].hours;
                Sstring[n].sessionNum = S[i].sessionNum;
                Sstring[n].subjName = S[i].name;
                Sstring[n].type = S[i].type;
                
                n++;
            }
        }
    }
    public void sessionCopy(Session S)
    {
        for(int i=0;i<S.n;i++)
        {
            Sstring[i].hours=S.Sstring[i].hours;
            Sstring[i].sessionNum=S.Sstring[i].sessionNum;
            Sstring[i].subjName=S.Sstring[i].subjName;
            Sstring[i].type=S.Sstring[i].type;
        }
    }
   
}
