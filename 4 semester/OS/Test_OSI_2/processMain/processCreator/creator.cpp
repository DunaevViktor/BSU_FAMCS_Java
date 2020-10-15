#include <conio.h>
#include <fstream>
#include <iostream>
using namespace std;
 struct order   { 
 int    n;  // код товара
 char   name[10]; // имя товара 
 double price;  // стоимость единицы товара
 int    amountR; // количество реализованных единиц товара
 int    amountNR; // количество непроданных единиц товара 
 }; 
int main(int argc, char *argv[])
{
	setlocale(LC_ALL,".1251");
	int i;
	fstream bfile;
	bfile.open(argv[1], ios::out | ios::binary);
	int n;
	cout<<endl<<"Введите количесвто элементов(товаров)?"<<endl;
	cin>>n;
	for(int i=0;i<n;i++)
	{
			order o;
			cout<<"Имя товара (9 букв)"<<endl;
			cin.clear();
			cin.sync();
			cin.getline(o.name,9,'\n');
			cout<<"Введите код товара"<<endl;
			cin>>o.n;				
			cout<<"Цена (double)"<<endl;
			cin>>o.price;
			cout<<"Количество проданных"<<endl;
			cin>>o.amountR;
			cout<<"Количество НЕ проданных"<<endl;
			cin>>o.amountNR;

		    bfile.write((char*)&o,sizeof(o));
			if(!bfile.good())
			{
				cout<<"Ошибка!!!"<<endl;
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
	_cputs("\n Нажмите любую клавишу для выхода.\n");
	_getch();

	
	return 0;
}
