package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.*;

public class Main {
    
    public Main() {
    }
    
    public static void main(String[] args) {
        //создаем регулярное выражение для проверки телефонного номера
        //допустимые символы: цифры, пробелы, круглые скобки, дефис
        Pattern p = Pattern.compile("[\\+\\d+\\ *]?[\\(\\d+\\) *]*\\d+[\\d+\\-?\\ *]",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        String input = "";
        //ввод телефонного номера
        System.out.println("Enter phone number: ");
        try {
            input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        }
        catch(Exception err) {
            System.out.println(err.getMessage());
        }
        Matcher m = p.matcher(input);
        //если введенный номер соответствует выражению, пишем OK...
        if(m.matches()) {
            System.out.println("\"" + input + "\" - OK");
        }
        //... если нет - ERR
        else {
            System.out.println("\"" + input + "\" - ERR");
        }
        //создаем регулярное выражение для поиска кода города
        Pattern codeP = Pattern.compile("\\([\\d]+\\)");
        m = codeP.matcher(input);
        //если номер содержит код города, то выводим его отдельной строкой
        if(m.find()) {
            System.out.println("Operator code: " + m.group());
        }
    }
}
