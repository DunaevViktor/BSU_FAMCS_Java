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
int main(int argc, char *argv[])//1 �������� - ��� ��������� �����, 2 �������� - ��� ����� ������, 3 �������� - ��� ������ (1 - ����, 2 - �� ����)
{
	setlocale(LC_ALL,".1251");
	fstream bfile;
	bfile.open(argv[1], ios::in | ios::binary);
	fstream txtfile;
	txtfile.open(argv[2],ios::out);
	txtfile<<"����� ��";
	int type = atoi(argv[3]);
	if(type==1)
	{
		txtfile<<" ��������� �������"<<endl;
	}
	if(type==2)
	{
		txtfile<<" �� ��������� �������"<<endl;
	}
	txtfile<<"����:"<<argv[1];
	txtfile<<endl;
	order prev;


	while(!(bfile.eof()))
	{
		order o;
		bfile.read((char*)&o,sizeof(o));

		if(strcmp(o.name,"")!=0)
		{
			int money;int kolvo_tov;
			if(type==1)
			{
				money=o.amountR*o.price;
				kolvo_tov=o.amountR;
			}
			if(type==2)
			{
				money=o.amountNR*o.price;
				kolvo_tov = o.amountNR;
			}
			if(money!=0) //����� �� ���� ������������ ���������� ��������
			{
			txtfile<<endl<<endl;
			txtfile<<"��� "<<o.n<<endl;
			txtfile<<"��� "<<o.name<<endl;
			txtfile<<"��������� ������� ������ "<<o.price<<endl;
			txtfile<<"���������� ������� ����� "<<kolvo_tov<<endl;			
			txtfile<<"��������� ��������� ������ ������: "<<money;
			}
		}
	}
	bfile.close();
	txtfile.close();
	return 0;
}
