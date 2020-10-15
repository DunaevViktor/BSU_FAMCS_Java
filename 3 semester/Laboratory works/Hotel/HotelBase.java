package main;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.*;



public class HotelBase {
    private List<Hotel> arr;
    private Map <String, ArrayList<Integer>>   indx1;//string - город, array - массив
    private Map <String, ArrayList<String>>   indx2;

    public void createBase(String filename) throws FileNotFoundException{
        Scanner in = new Scanner(new File(filename));
        int code = 1;
        arr = new ArrayList<Hotel>();
        while(in.hasNextLine()){
            String t = in.nextLine();
            StringTokenizer st = new StringTokenizer(t," -");
            String name = st.nextToken();
            int stars = Integer.parseInt(st.nextToken());
            String city = st.nextToken();
            arr.add(new Hotel(code,name,stars,city));
            code++;
        }
    }

    public void createIndexCity(){
        ArrayList<Integer> temp, temp2;
        Iterator<Hotel> it = arr.iterator();
        indx1 = new TreeMap<String, ArrayList<Integer>>();
        while(it.hasNext()){
            Hotel tempH = (Hotel)it.next();
            String name = tempH.getCity();
            temp2 = indx1.get(name);
            if(temp2==null){
                temp = new ArrayList<Integer>();
                temp.add(tempH.getCode());
                indx1.put(name,temp);
            }
            else{
               // temp2.add(tempH.getCode());
                indx1.get(name).add(tempH.getCode());
            }
        }
    }
    public void ShowHotelByCity(String s){
        try{
        ArrayList<Integer> show = findCity(s);
        for(int i=0; i< show.size();i++){
            Hotel H = findByCode(show.get(i));
            System.out.println(H.getName() + " " + H.getStars() + " " + H.getCity());
        }
        }
        catch(NullPointerException e){
            System.out.println("Ошибка, нет такого города!");
        }
    }
    public Hotel findByCode(int code){
        Hotel temp = new Hotel(code,null,0,null);
        int i = Collections.binarySearch(arr, temp);
        return arr.get(i);
    }
    public ArrayList<Integer> findCity(String name){
        return indx1.get(name);
    }



    public void ShowHotelByCityWithStars(String s){
        try{
        ArrayList<Integer> show = findCity(s);
        for(int i=0; i< show.size();i++){
            Hotel H = findByCode(show.get(i));
             System.out.println(H.getName() + " " + H.getStars() + " " + H.getCity());
        }
        }
        catch (NullPointerException e){
            System.out.println("Нет такого!");
        }
    }
    public void createIndexCityWithStars(int stars){
        ArrayList<Integer> temp, temp2;
        Iterator<Hotel> it = arr.iterator();
        indx1 = new TreeMap<String, ArrayList<Integer>>();
        while(it.hasNext()) {

                Hotel tempH = (Hotel) it.next();
            if (tempH.getStars()==stars) {
                String name = tempH.getCity();
                temp2 = indx1.get(name);
                if (temp2 == null) {
                    temp = new ArrayList<Integer>();
                    temp.add(tempH.getCode());
                    indx1.put(name, temp);
                } else {
                    // temp2.add(tempH.getCode());
                    indx1.get(name).add(tempH.getCode());
                }
            }
        }
    }

    public void createIndexHotel(){
        ArrayList<String> temp, temp2;
        Iterator<Hotel> it = arr.iterator();
        indx2 = new TreeMap<String, ArrayList<String>>();
        while(it.hasNext()){
            Hotel tempH = (Hotel)it.next();
            String name = tempH.getName();
            temp2 = indx2.get(name);
            if(temp2==null){
                temp = new ArrayList<String>();
                temp.add(tempH.getCity());
                indx2.put(name,temp);
            }
            else{
                // temp2.add(tempH.getCode());
                indx2.get(name).add(tempH.getCity());
            }
        }
    }
    public void ShowCitiesByHotel(String s){
        try{
        ArrayList<String> show = findHotels(s);
        for(int i=0; i< show.size();i++){
            System.out.println(show.get(i));
        }
    }
        catch(NullPointerException e){
            System.out.println("Нет такого!");
        }
    }
    public ArrayList<String> findHotels(String name){
        return indx2.get(name);
    }
}
