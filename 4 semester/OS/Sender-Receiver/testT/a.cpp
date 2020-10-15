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

	Full =CreateSemaphore(NULL,n,n,"Full");
	Clear = CreateSemaphore(NULL,0,n,"Clear");
	
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
		e.free=false;strcpy(e.name,ne);strcpy(e.text,"emptyS");
		bfileInit.write((char*)&e,sizeof(e));
	}
	bfileInit.close();
	bool is_go = true;

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
			WaitForSingleObject(Full,INFINITE);
			cout<<"Wait finished"<<endl;
			
			cout<<"Read info"<<endl;
			Info I;//почитали информацию об очереди
			fstream bfileR;
			bfileR.open(filename,ios::in | ios::binary);
			bfileR.seekg(0,ios::beg);
			bfileR.read((char*)&I,sizeof(Info));
			cout<<I.n<<"=n,"<<I.start<<"=start,"<<I.last<<"=last"<<endl;

			cout<<"Readed"<<endl;
							
			Message mess;
			bfileR.seekg(1*sizeof(Info)+I.start*sizeof(Message),ios::beg);
			bfileR.read((char*)&mess,sizeof(Message));
			cout<<mess.name<<" "<<mess.text<<endl;
			bfileR.close();
			mess.free=true;strcpy(mess.text,"-");strcpy(mess.name,"");
			
			fstream bfileW;
			bfileW.open(filename,ios::out | ios::binary | ios::in);
			cout<<"Go to 1 empty plase"<<endl;	
			bfileW.seekg(1*sizeof(Info)+I.start*sizeof(Message),ios::beg);
			cout<<"Put message:"<<mess.name<<" "<<mess.text<<endl;
			bfileW.write((char*)&mess,sizeof(Message));			
			cout<<"Done"<<endl;			
			cout<<"Write next time n,start,last"<<endl;
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
