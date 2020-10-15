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
	HANDLE Full;
	HANDLE Clear;
	//���������� �������� �� ����.���
	Full = OpenSemaphore(SEMAPHORE_ALL_ACCESS,true,"Full");
	Clear = OpenSemaphore(SEMAPHORE_ALL_ACCESS,true,"Clear");
	//���������� ��������� ����
	cout<<"��� ����� = "<<argv[1]<<endl;
	cout<<"������� ��� �����������(sender'a)"<<endl;
	char* name = new char[50];
	cin.getline(name,49,'\n');
	bool is_go = true;
	//�������� ��� ��������
	while(is_go)
	{
		cout<<"�������: 1 - ������, 2 - ���������"<<endl;
		int go;
		cin>>go;
		cin.clear();
		cin.sync();
		//���������� ������
		if(go==2)
		{
			is_go = false;
		}
		//������ ������ ��������
		if(go==1)
		{		
			cout<<"���� ������"<<endl;
			//���� ���� ���� ���� ������
			WaitForSingleObject(Clear,INFINITE);
			cout<<"���� ������"<<endl;
			
			cout<<"������ ����������"<<endl;
			Info I;//�������� ���������� �� �������
			fstream bfileR;
			bfileR.open(argv[1],ios::in | ios::binary);
			//�������
			bfileR.seekg(0,ios::beg);
			bfileR.read((char*)&I,sizeof(Info));
			cout<<I.n<<" = n,"<<I.start<<" = �����,"<<I.last<<" = ���������"<<endl;
			cout<<"���������"<<endl;
			bfileR.close();	

			//���������� ����� ��������� � �������
			cout<<"�������� �����"<<endl;
			cin.clear();
			cin.sync();
			char* text = new char[50];
			cout<<"������� �����"<<endl;
			cin.getline(text,49,'\n');
			cin.clear();
			cin.sync();
			//��� ���������� � �������
			Message mess;
			mess.free=true;
			strcpy(mess.text,text);
			strcpy(mess.name,name);
			//��������� � ������ ����� �������
			fstream bfileW;
			bfileW.open(argv[1],ios::out | ios::binary | ios::in);
			cout<<"���� �� 1 ��������� �����"<<endl;	
			bfileW.seekg(1*sizeof(Info)+I.last*sizeof(Message),ios::beg);
			cout<<"�������� ���������:"<<mess.name<<" "<<mess.text<<endl;
			bfileW.write((char*)&mess,sizeof(Message));			
			cout<<"���������"<<endl;	

			cout<<"����� �������� ��� ������� (n,start,last)"<<endl;
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
			//������� � ���������� ���������
			cout<<I.n<<" = n,"<<I.start<<" = �����,"<<I.last<<" = ���������"<<endl;
			bfileW.seekg(0,ios::beg);
			bfileW.write((char*)&I,sizeof(Info));	
			bfileW.close();
			cout<<"�������� � �������"<<endl;
			//�������� �������� ��������
			ReleaseSemaphore(Full,1,NULL);
			cout<<"��������� ��������"<<endl;

			cout<<"������� ��� ����������"<<endl;
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
	_cputs("\n ������� ����� ������� ��� ����������.\n");
	_getch();
	system("pause");
	return 0;

}
