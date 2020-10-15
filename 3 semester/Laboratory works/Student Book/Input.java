package lab4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public Input() {
    }

    public String stringTake() { //throws IOException {
        String a = new String();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            a = br.readLine();
        } catch (IOException var5) {
            System.out.println("Ошибка чтения с клавиатуры");
        }

        return a;
    }

    public int intTake() {
        int a = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            String e = br.readLine();
            a = Integer.parseInt(e);
        } catch (NumberFormatException var5) {
            System.out.println("Не целое число");
        } catch (IOException var6) {
            System.out.println("Ошибка чтения с клавиатуры");
        }

        return a;
    }
}
