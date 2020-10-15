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
	HANDLE* Senders;
	cout<<"In name of file"<<endl;
	char* filename=new char[60];
	cin.getline(filename,49,'\n');
	strcat(filename,".bin");
	HANDLE Full;HANDLE Clear;
	cout<<"In number of elements"<<endl;
	int n;
	cin>>n;
	cin.clear();
	cin.sync();
	//z
	Full =CreateSemaphore(NULL,0,n,"Full");
	Clear = CreateSemaphore(NULL,n,n,"Clear");
	
	fstream bfileInit;
	bfileInit.open(filename,ios::out | ios::binary);
	Info I;

	I.start=-1;
	I.n=n;I.last=0;
	bfileInit.write((char*)&I,sizeof(Info));
	for(int i= 0;i<n;i++)
	{
		Message e;
		//zamena
		char* ne = new char[30];
		itoa(i,ne,10);
		strcat(ne,"Empty");
		bfileInit.seekg(1*sizeof(Info)+i*sizeof(Message),ios::beg);
		e.free=true;strcpy(e.name,ne);strcpy(e.text,"emptyS");
		bfileInit.write((char*)&e,sizeof(e));
	}
	bfileInit.close();
	/*cout<<"How many senders you need?"<<endl;
	int numberOfSenders;
	cin>>numberOfSenders;
	cin.clear();
	cin.sync();

	Senders = new HANDLE[numberOfSenders];
	char*command = new char[200];
	strcpy(command,"Sender.exe ");
	cout<<"Add 1"<<endl;
	strcat(command,filename);
	cout<<"Add 2"<<endl;
	cout<<command<<endl;
	for(int i = 0;i<numberOfSenders;i++)
	{
		STARTUPINFO si;  PROCESS_INFORMATION pi; 
		CreateProcess(NULL, command,NULL, NULL, FALSE,CREATE_NEW_CONSOLE, NULL, NULL, &si, &pi) ;
		Senders[i]=pi.hProcess;
		//CloseHandle(pi[i].hThread);  CloseHandle(pi[i].hProcess); 
	}
	*/
	bool is_go = true;

	/*aaaaaaaaaaa*/
	char* name ="name";
	while(is_go)
	{
		cout<<"Command: 1 - read, 2 - end"<<endl;
		int go;
		cin>>go;
		cin.clear();
		cin.sync();
		if(go==2)
		{
			is_go = false;
		}
		if(go==1)
		{	
			cout<<"Wait start"<<endl;
			WaitForSingleObject(Clear,INFINITE);
			cout<<"Wait finished"<<endl;
			
			cout<<"Read info"<<endl;
			Info I;//почитали информацию об очереди
			fstream bfileR;
			bfileR.open(filename,ios::in | ios::binary);
			bfileR.seekg(0,ios::beg);
			bfileR.read((char*)&I,sizeof(Info));
			cout<<I.n<<"=n,"<<I.start<<"=start,"<<I.last<<"=last"<<endl;

			cout<<"Readed"<<endl;
			bfileR.close();				
			cout<<"Get text"<<endl;
			cin.clear();
			cin.sync();
			char* text = new char[50];
			cout<<"Vvedite text"<<endl;
			cin.getline(text,49,'\n');
			cin.clear();
			cin.sync();
			Message mess;
			mess.free=false;strcpy(mess.text,text);strcpy(mess.name,name);
			
			fstream bfileW;
			bfileW.open(filename,ios::out | ios::binary | ios::in);
			cout<<"Go to 1 empty plase"<<endl;	
			bfileW.seekg(1*sizeof(Info)+I.last*sizeof(Message),ios::beg);
			cout<<"Put message:"<<mess.name<<" "<<mess.text<<endl;
			bfileW.write((char*)&mess,sizeof(Message));			
			cout<<"Done"<<endl;			
			cout<<"Write next time n,start,last"<<endl;
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
			cout<<I.n<<"=n,"<<I.start<<"=start,"<<I.last<<"=last"<<endl;
			bfileW.seekg(0,ios::beg);
			bfileW.write((char*)&I,sizeof(Info));	
			bfileW.close();
			cout<<"Writed & closed"<<endl;
			
			ReleaseSemaphore(Full,1,NULL);
			cout<<"Released semaphore"<<endl;

			cout<<"Read all what have"<<endl;
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
	//WaitForMultipleObjects(n,Senders,true,INFINITE);
	_cputs("\nPress any key to finish.\n");
	_getch();
	system("pause");
	return 0;
}
