#include <windows.h>
#include <conio.h>
#include <iostream>
#include <fstream>
using namespace std;
struct Message
{
	bool free;  // ������� ��������� ������
	char name[10]; // ��� �����������
	char text[20]; // ����� ���������
};
struct Info{
	int n;//���������� ���������
	int start;//����� 1 �������
	int last;//����� ����� ���������� �������
};
int main(int argc, char *argv[])
{
	setlocale(0,"rus");
	//������ ��������
	HANDLE* Senders;
	//���������� � �����
	cout<<"��� ������������ �������� �����"<<endl;
	char* filename=new char[60];
	cin.getline(filename,49,'\n');
	strcat(filename,".bin");
	//��� ���������
	HANDLE Full;
	HANDLE Clear;
	cout<<"���������� ���������"<<endl;
	int n;
	cin>>n;
	cin.clear();
	cin.sync();
	//�������� ���������
	Full =CreateSemaphore(NULL,0,n,"Full");
	Clear = CreateSemaphore(NULL,n,n,"Clear");
	//������� ��������� ����� ��� ������
	fstream bfileInit;
	bfileInit.open(filename,ios::out | ios::binary);
	//��������� ���������� �� �������(������� ���������)
	Info I;
	I.start=-1;
	I.n=n;
	I.last=0;
	//���������� � ��� ���� ������ ��������
	//����� ������������������� ���
	bfileInit.write((char*)&I,sizeof(Info));
	for(int i= 0;i<n;i++)
	{
		Message e;
		char* ne = new char[30];
		//������� ����� � ������
		itoa(i,ne,10);
		strcat(ne,"Empty");
		//������� ������
		bfileInit.seekg(1*sizeof(Info)+i*sizeof(Message),ios::beg);
		//��������� ��������
		e.free=false;
		strcpy(e.name,ne);
		strcpy(e.text,"emptyS");
		bfileInit.write((char*)&e,sizeof(e));
	}
	bfileInit.close();

	cout<<"������� ������������(sender's)?"<<endl;
	int numberOfSenders;
	cin>>numberOfSenders;
	cin.clear();
	cin.sync();

	//���������� ��� �������� ���������
	STARTUPINFO si;
	PROCESS_INFORMATION piCom; 
	//������������� ���������� ��� �������� ���������
	ZeroMemory(&si, sizeof(STARTUPINFO));
	si.cb = sizeof(STARTUPINFO); 
	//������ ���������
	HANDLE* handle;
	handle = new HANDLE[numberOfSenders];
	// ������� ����� ���������� �������
	char*command = new char[200];
	//��� �������� ����� �������
	strcpy(command,"Sender.exe ");
	strcat(command,filename);
	cout<<"��� ������ ������� : "<<command<<endl;

	//������� ������� ��������� ������� ��������(���-�� ����)
	//� ���������� �� � ���� ������
	for(int i = 0;i<numberOfSenders;i++)
	{	
		if(!
	CreateProcess(NULL, command, NULL, NULL, FALSE,  CREATE_NEW_CONSOLE, NULL, NULL, &si, &piCom))
	cout<<"errordsds"<<endl; 
	handle[i]=piCom.hProcess;
	
	}
	//���������� ����� ������ ������
	bool is_go = true;
	//���� ������ �������
	while(is_go)
	{
		cout<<"�������: 1 - ������, 2 - �����"<<endl;
		int go;
		cin>>go;
		cin.clear();
		cin.sync();
		//����������
		if(go==2)
		{
			is_go = false;
		}
		//������ �� ��������
		if(go==1)
		{	
			cout<<"���� ������"<<endl;
			//���� ����� ���� 1 ����� � �����
			WaitForSingleObject(Full,INFINITE);
			cout<<"���� ������"<<endl;
			
			cout<<"������ ����������"<<endl;
			Info I;//�������� ���������� �� �������(������� ���������)
			fstream bfileR;
			bfileR.open(filename,ios::in | ios::binary);
			//� ����� �������
			bfileR.seekg(0,ios::beg);
			bfileR.read((char*)&I,sizeof(Info));
			cout<<I.n<<" = n,"<<I.start<<" = �����,"<<I.last<<" = ��������	"<<endl;
			cout<<"���������:"<<endl;
							
			Message mess;
			bfileR.seekg(1*sizeof(Info)+I.start*sizeof(Message),ios::beg);
			//������ ������ "start"
			bfileR.read((char*)&mess,sizeof(Message));
			cout<<"����� = "<<mess.name<<",����� = "<<mess.text<<endl;
			bfileR.close();
			//���������� ���������(���������)
			mess.free=false;
			strcpy(mess.text,"-");
			strcpy(mess.name,"");
			//��������� ����������
			fstream bfileW;
			bfileW.open(filename,ios::out | ios::binary | ios::in);
			cout<<"���� � ������� ���������� �����"<<endl;	
			bfileW.seekg(1*sizeof(Info)+I.start*sizeof(Message),ios::beg);
			cout<<"�������� ���������:"<<mess.name<<" "<<mess.text<<endl;
			bfileW.write((char*)&mess,sizeof(Message));			
			cout<<"���������"<<endl;
			//�������� ���� � ������� ���������
			cout<<"����� ������ � ������� (n,start,last)"<<endl;
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
			//�� ����� � ����������
			cout<<I.n<<" = n,"<<I.start<<" = �����,"<<I.last<<" = ���������"<<endl;
			bfileW.seekg(0,ios::beg);
			bfileW.write((char*)&I,sizeof(Info));	
			bfileW.close();
			cout<<"�������� � �������."<<endl;
			//�������� ������� �� ����������� ���������(-1)
			ReleaseSemaphore(Clear,1,NULL);
			cout<<"��������(����������)��������"<<endl;
			//���������� ��������� ����� ��������
			cout<<"������, ��� ����������"<<endl;
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
	_cputs("\n ������� ������� ��� ����������.\n");
	_getch();
	system("pause");
	return 0;
}
