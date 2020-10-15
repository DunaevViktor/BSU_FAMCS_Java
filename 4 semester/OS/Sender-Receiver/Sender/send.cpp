#include <windows.h>
#include <conio.h>
#include <iostream>
#include <fstream>
using namespace std;
struct Message
{
	bool free;  // признак свободной ячейки
	char name[10]; // имя отправителя
	char text[20]; // текст сообщения
};
struct Info{
	int n;//количество элементов
	int start;//номер 1 объекта
	int last;//номер после последнего объекта
};
int main(int argc, char *argv[])
{
	setlocale(0,"rus");
	HANDLE Full;
	HANDLE Clear;
	//используем симофоры из маин.спп
	Full = OpenSemaphore(SEMAPHORE_ALL_ACCESS,true,"Full");
	Clear = OpenSemaphore(SEMAPHORE_ALL_ACCESS,true,"Clear");
	//используем созданный файл
	cout<<"Имя файла = "<<argv[1]<<endl;
	cout<<"Введите имя отправителя(sender'a)"<<endl;
	char* name = new char[50];
	cin.getline(name,49,'\n');
	bool is_go = true;
	//операции над сендером
	while(is_go)
	{
		cout<<"Команды: 1 - запись, 2 - завершить"<<endl;
		int go;
		cin>>go;
		cin.clear();
		cin.sync();
		//завершение работы
		if(go==2)
		{
			is_go = false;
		}
		//запись нового месседжа
		if(go==1)
		{		
			cout<<"Ждем старта"<<endl;
			//ждем пока есть куда писать
			WaitForSingleObject(Clear,INFINITE);
			cout<<"Ждем финиша"<<endl;
			
			cout<<"Чтение информации"<<endl;
			Info I;//почитали информацию об очереди
			fstream bfileR;
			bfileR.open(argv[1],ios::in | ios::binary);
			//позиция
			bfileR.seekg(0,ios::beg);
			bfileR.read((char*)&I,sizeof(Info));
			cout<<I.n<<" = n,"<<I.start<<" = Старт,"<<I.last<<" = Последний"<<endl;
			cout<<"Прочитано"<<endl;
			bfileR.close();	

			//записываем новое сообщение с консоли
			cout<<"Получить текст"<<endl;
			cin.clear();
			cin.sync();
			char* text = new char[50];
			cout<<"Введите текст"<<endl;
			cin.getline(text,49,'\n');
			cin.clear();
			cin.sync();
			//эту информацию в месседж
			Message mess;
			mess.free=true;
			strcpy(mess.text,text);
			strcpy(mess.name,name);
			//загружает в массив новый месседж
			fstream bfileW;
			bfileW.open(argv[1],ios::out | ios::binary | ios::in);
			cout<<"Идем на 1 свободное место"<<endl;	
			bfileW.seekg(1*sizeof(Info)+I.last*sizeof(Message),ios::beg);
			cout<<"Положить сообщение:"<<mess.name<<" "<<mess.text<<endl;
			bfileW.write((char*)&mess,sizeof(Message));			
			cout<<"Выполнено"<<endl;	

			cout<<"Новые значения для очереди (n,start,last)"<<endl;
			if(I.start==-1)
			{
				I.start=0;
			}
			if(I.last==I.n-1)
			{
				I.last=0;
			}
			else
			{
				I.last++;
			}
			//выводим и записываем изменения
			cout<<I.n<<" = n,"<<I.start<<" = старт,"<<I.last<<" = последний"<<endl;
			bfileW.seekg(0,ios::beg);
			bfileW.write((char*)&I,sizeof(Info));	
			bfileW.close();
			cout<<"Записано и закрыто"<<endl;
			//изменяем значение симофора
			ReleaseSemaphore(Full,1,NULL);
			cout<<"Изменение симофора"<<endl;

			cout<<"Покажем что получилось"<<endl;
			fstream reader;
			reader.open(argv[1],ios::in | ios::binary);
			Info temp;
			reader.read((char*)&temp,sizeof(Info));
			for(int i=0;i<I.n;i++)
			{
				Message m;
				reader.read((char*)&m,sizeof(m));
				cout<<m.free<<" "<<m.name<<" "<<m.text<<endl;
			}
			reader.close();	
		}
	}
	_cputs("\n Нажмите любую клавишу для завершения.\n");
	_getch();
	system("pause");
	return 0;

}
