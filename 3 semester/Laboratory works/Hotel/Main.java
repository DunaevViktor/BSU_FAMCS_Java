package main;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("Введите имя файла с информацией: ");
        String name = io.next();
        HotelBase crafter = new HotelBase();
        try {
            crafter.createBase(name);
        }catch(Exception e){
            System.out.println("НЕТ ТАКОГО ФАЙЛА!!!");
        }

        System.out.println("Введите ИМЯ ГОРОДА и получите все отели?");
        name = io.next();
        crafter.createIndexCity();
        System.out.println("Ваши итоги: ");
        crafter.ShowHotelByCity(name);

        System.out.println("Введите ИМЯ ОТЛЕЛЯ и узнаете где он есть?");
        name = io.next();
        crafter.createIndexHotel();
        System.out.println("Ваши итоги: ");
        crafter.ShowCitiesByHotel(name);


        System.out.println("Введите ИМЯ ГОРОДА и ЗВЕЗДЫ и получите все отели?");
        name = io.next();
        int stars = io.nextInt();
        crafter.createIndexCityWithStars(stars);
        System.out.println("Ваши итоги: ");
        crafter.ShowHotelByCityWithStars(name);

    }
    
}
