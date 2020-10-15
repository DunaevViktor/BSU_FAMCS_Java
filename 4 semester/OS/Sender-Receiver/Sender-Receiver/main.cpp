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
	//массив сендеров
	HANDLE* Senders;
	//информация о файле
	cout<<"Имя создаваемого входного файла"<<endl;
	char* filename=new char[60];
	cin.getline(filename,49,'\n');
	strcat(filename,".bin");
	//для симофоров
	HANDLE Full;
	HANDLE Clear;
	cout<<"Количество элементов"<<endl;
	int n;
	cin>>n;
	cin.clear();
	cin.sync();
	//создание симофоров
	Full =CreateSemaphore(NULL,0,n,"Full");
	Clear = CreateSemaphore(NULL,n,n,"Clear");
	//окрытие бинарного файла для чтения
	fstream bfileInit;
	bfileInit.open(filename,ios::out | ios::binary);
	//начальная информация об очереди(массиве сообщений)
	Info I;
	I.start=-1;
	I.n=n;
	I.last=0;
	//Записываем в наш файл пустые элементы
	//чтобы проинициализировать его
	bfileInit.write((char*)&I,sizeof(Info));
	for(int i= 0;i<n;i++)
	{
		Message e;
		char* ne = new char[30];
		//функция число в строку
		itoa(i,ne,10);
		strcat(ne,"Empty");
		//позиция записи
		bfileInit.seekg(1*sizeof(Info)+i*sizeof(Message),ios::beg);
		//дефолтные значения
		e.free=false;
		strcpy(e.name,ne);
		strcpy(e.text,"emptyS");
		bfileInit.write((char*)&e,sizeof(e));
	}
	bfileInit.close();

	cout<<"Сколько отправителей(sender's)?"<<endl;
	int numberOfSenders;
	cin>>numberOfSenders;
	cin.clear();
	cin.sync();

	//информация для создания процессов
	STARTUPINFO si;
	PROCESS_INFORMATION piCom; 
	//инициализация переменных для создания процессов
	ZeroMemory(&si, sizeof(STARTUPINFO));
	si.cb = sizeof(STARTUPINFO); 
	//массив процессов
	HANDLE* handle;
	handle = new HANDLE[numberOfSenders];
	// создаем новый консольный процесс
	char*command = new char[200];
	//как выглядит вызов сендера
	strcpy(command,"Sender.exe ");
	strcat(command,filename);
	cout<<"Вид вызова сендера : "<<command<<endl;

	//создаем столько процессов сколько сендеров(кол-во окон)
	//и закидываем их в один массив
	for(int i = 0;i<numberOfSenders;i++)
	{	
		if(!
	CreateProcess(NULL, command, NULL, NULL, FALSE,  CREATE_NEW_CONSOLE, NULL, NULL, &si, &piCom))
	cout<<"errordsds"<<endl; 
	handle[i]=piCom.hProcess;
	
	}
	//переменная чтобы начать работу
	bool is_go = true;
	//цикл выбора команды
	while(is_go)
	{
		cout<<"Команды: 1 - чтение, 2 - конец"<<endl;
		int go;
		cin>>go;
		cin.clear();
		cin.sync();
		//завершение
		if(go==2)
		{
			is_go = false;
		}
		//чтение из сендеров
		if(go==1)
		{	
			cout<<"Ждем старта"<<endl;
			//пока будет хоть 1 место в файле
			WaitForSingleObject(Full,INFINITE);
			cout<<"Ждем финиша"<<endl;
			
			cout<<"Читаем информацию"<<endl;
			Info I;//почитали информацию об очереди(массиве сообщений)
			fstream bfileR;
			bfileR.open(filename,ios::in | ios::binary);
			//с какой позиции
			bfileR.seekg(0,ios::beg);
			bfileR.read((char*)&I,sizeof(Info));
			cout<<I.n<<" = n,"<<I.start<<" = старт,"<<I.last<<" = последни	"<<endl;
			cout<<"Прочитано:"<<endl;
							
			Message mess;
			bfileR.seekg(1*sizeof(Info)+I.start*sizeof(Message),ios::beg);
			//читаем объект "start"
			bfileR.read((char*)&mess,sizeof(Message));
			cout<<"Автор = "<<mess.name<<",Текст = "<<mess.text<<endl;
			bfileR.close();
			//показатель прочтения(обнуление)
			mess.free=false;
			strcpy(mess.text,"-");
			strcpy(mess.name,"");
			//обнуление физическое
			fstream bfileW;
			bfileW.open(filename,ios::out | ios::binary | ios::in);
			cout<<"Идем к первому свободному месту"<<endl;	
			bfileW.seekg(1*sizeof(Info)+I.start*sizeof(Message),ios::beg);
			cout<<"Положить сообщение:"<<mess.name<<" "<<mess.text<<endl;
			bfileW.write((char*)&mess,sizeof(Message));			
			cout<<"Выполнено"<<endl;
			//изменить инфо о массиве сообщений
			cout<<"Новые данные о очереди (n,start,last)"<<endl;
			if(I.start==-1)
			{
				I.start=0;
			}
			if(I.start==I.n-1)
			{
				I.start=0;
			}
			else
			{
				I.start++;
			}
			//их вывод и перезапись
			cout<<I.n<<" = n,"<<I.start<<" = старт,"<<I.last<<" = последний"<<endl;
			bfileW.seekg(0,ios::beg);
			bfileW.write((char*)&I,sizeof(Info));	
			bfileW.close();
			cout<<"Записали и закрыли."<<endl;
			//очищение массива на прочитанное сообщение(-1)
			ReleaseSemaphore(Clear,1,NULL);
			cout<<"Именение(реализация)симофора"<<endl;
			//показываем результат после операций
			cout<<"Читаем, что получилось"<<endl;
			fstream reader;
			reader.open(filename,ios::in | ios::binary);
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

	WaitForMultipleObjects(numberOfSenders,handle,true,INFINITE);
	_cputs("\n Нажмите клавишу для завершения.\n");
	_getch();
	system("pause");
	return 0;
}
