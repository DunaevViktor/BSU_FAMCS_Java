package aplet;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class MainFrame extends JFrame{
    private final int WIDTH = 900;
    private final int HEIGHT = 650;

    private Checkbox whoBox1, whoBox2, whoBox3, whoBox4, whoBox5;
    private Checkbox presentBox1, presentBox2, presentBox3, presentBox4;
    private Checkbox regulBoxYep, regulBoxNope;
    private Checkbox concertBoxYep, concertBoxNope;
    private Button countButton;
    private CheckboxGroup myCheckboxGroup;
    private Label vocalistLabel, presentLabel, concertLabel, regulLabel, resLabel;
    
    public MainFrame() throws HeadlessException{
        //Инициализация
        super();
        setSize(WIDTH,HEIGHT);
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().width/2 - WIDTH/2),
                (int)(Toolkit.getDefaultToolkit().getScreenSize().height/2 - HEIGHT/2));
        setTitle("Награждение победителей олимпиады по программированию!");
        setLayout(new GridLayout(35,1));
        
        
        //Поздравитель
        myCheckboxGroup = new CheckboxGroup();
        vocalistLabel = new Label("Кто будет поздравителем?");
        whoBox1 = new Checkbox("Максим \"Inspirer\" Мазеин", myCheckboxGroup, true);
        whoBox1.setBackground(Color.YELLOW);
        whoBox2 = new Checkbox("Андрей \"Лектор\" Петрович", myCheckboxGroup, false);
        whoBox2.setBackground(Color.YELLOW);
        whoBox3 = new Checkbox("Дмитрий \"SL1DE\" Фришман", myCheckboxGroup, true);
        whoBox3.setBackground(Color.YELLOW);
        whoBox4 = new Checkbox("Обычный человек", myCheckboxGroup, false);
        whoBox4.setBackground(Color.YELLOW);
        whoBox5 = new Checkbox("Олег \"Straik\" Романенков", myCheckboxGroup, true);
        whoBox5.setBackground(Color.YELLOW);
        add(vocalistLabel);
        add(new Label());
        add(whoBox1);
        add(whoBox2);
        add(whoBox3);
        add(whoBox4);
        add(whoBox5);
        add(new Label());

        //Подарок
        presentLabel = new Label("Подарок победителю:");
        
        myCheckboxGroup = new CheckboxGroup();
        presentBox1 = new Checkbox("Современный ПК", myCheckboxGroup, true);
        presentBox1.setBackground(Color.magenta);
        presentBox2 = new Checkbox("Компьютерная мышь", myCheckboxGroup, false);
        presentBox2.setBackground(Color.magenta);
        presentBox3 = new Checkbox("Наушники SONY", myCheckboxGroup, false);
        presentBox3.setBackground(Color.magenta);
        presentBox4 = new Checkbox("Блокнот и ручка", myCheckboxGroup, false);
        presentBox4.setBackground(Color.magenta);
        add(presentLabel);
        add(new Label());
        add(presentBox1);
        add(presentBox2);
        add(presentBox3);
        add(presentBox4);
        add(new Label());
        
        //Показательная игра
        concertLabel= new Label("Хотите показательный матч киберспортсменов?");
        myCheckboxGroup = new CheckboxGroup();
        concertBoxYep = new Checkbox("Да, это же весело", myCheckboxGroup, true);
        concertBoxYep.setForeground(Color.RED);
        concertBoxNope = new Checkbox("Нет, компьютерные игры - зло!", myCheckboxGroup, false);
        concertBoxNope.setForeground(Color.GREEN);
        add(concertLabel);
        add(new Label());
        add(concertBoxYep);
        add(concertBoxNope);
        add(new Label());

        //Топовый игрок
        regulLabel = new Label("Постоянный победитель олимпиад?");
        myCheckboxGroup = new CheckboxGroup();
        regulBoxYep = new Checkbox("Да, он умный", myCheckboxGroup, true);
        regulBoxYep.setForeground(Color.GREEN);
        regulBoxNope = new Checkbox("Нет, случайно победил", myCheckboxGroup, false);
        regulBoxNope.setForeground(Color.RED);
        add(regulLabel);
        add(new Label());
        add(regulBoxYep);
        add(regulBoxNope);
        add(new Label());
        
        //Кнопка
        countButton = new Button();
        countButton.setBackground(Color.YELLOW);
        countButton.setForeground(Color.BLUE);
        countButton.setLabel("Посчитать итог $$$");
        add(new Label());
        add(new Label());
        add(countButton);
        
        //Результат
        resLabel = new Label("Сумма $$$     ");
        add(new Label());
        add(resLabel);

        //Суммирование
        TestActionListener actionListener = new TestActionListener();
        countButton.addActionListener(actionListener);
    }


    private class TestActionListener implements ActionListener  {
        public void actionPerformed(ActionEvent e){
            int sum = 0;
            if( whoBox1.getState()==true){
                sum+=2; 
            }
            if( whoBox2.getState()==true){
                sum+=1; 
            }
            if( whoBox3.getState()==true){ 
                sum+=3; 
            }
            if( whoBox4.getState()==true){
                sum+=1; 
            }
            if( whoBox5.getState()==true){
                sum+=4; 
            }

            if( presentBox1.getState()==true){
                sum+=4; 
            }
            if( presentBox2.getState()==true){
                sum+=2; 
            }
            if( presentBox3.getState()==true){
                sum+=3; 
            }
            if( presentBox4.getState()==true){
                sum+=1; 
            }
            
            if( concertBoxYep.getState()==true){
                sum+=1; 
            }

            if( regulBoxYep.getState()==true) {
                sum*=0.9;
            }
            resLabel.setText("Заплатить 0_0   : "+sum);
        }
    }
}

