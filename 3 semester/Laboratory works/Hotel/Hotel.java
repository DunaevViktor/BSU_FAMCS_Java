package main;
public class Hotel implements Comparable<Hotel>{
    int code;
    private String city;
    String hotel;
    int stars;
    Hotel(int code, String name, int stars, String city){
        this.city = city;
        this.hotel = name;
        this.stars = stars;
        this.code = code;
    }
    public String getName(){
        return hotel;
    }
    public String getCity(){
        return city;
    }
    public int getStars(){
        return stars;
    }
    public int getCode(){
        return code;
    }

    @Override
    public int compareTo(Hotel h){//Object obj
        return this.code - h.code; //-((Hotel)obj.code)
    }
    
}
