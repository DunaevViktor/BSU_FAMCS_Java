#include <conio.h>
#include <fstream>
#include <iostream>
using namespace std;
 struct order   { 
 int    n;  // ��� ������
 char   name[10]; // ��� ������ 
 double price;  // ��������� ������� ������
 int    amountR; // ���������� ������������� ������ ������
 int    amountNR; // ���������� ����������� ������ ������ 
 }; 
int main(int argc, char *argv[])
{
	setlocale(LC_ALL,".1251");
	int i;
	fstream bfile;
	bfile.open(argv[1], ios::out | ios::binary);
	int n;
	cout<<endl<<"������� ���������� ���������(�������)?"<<endl;
	cin>>n;
	for(int i=0;i<n;i++)
	{
			order o;
			cout<<"��� ������ (9 ����)"<<endl;
			cin.clear();
			cin.sync();
			cin.getline(o.name,9,'\n');
			cout<<"������� ��� ������"<<endl;
			cin>>o.n;				
			cout<<"���� (double)"<<endl;
			cin>>o.price;
			cout<<"���������� ���������"<<endl;
			cin>>o.amountR;
			cout<<"���������� �� ���������"<<endl;
			cin>>o.amountNR;

		    bfile.write((char*)&o,sizeof(o));
			if(!bfile.good())
			{
				cout<<"������!!!"<<endl;
			}
	}

	order end;
	strcpy(end.name,"");
	end.n=0;
	end.amountNR=0;
	end.amountR=0;
	end.price=0;

	bfile.write((char*)&end,sizeof(end));
	bfile.close();
	_cputs("\n ������� ����� ������� ��� ������.\n");
	_getch();

	
	return 0;
}
