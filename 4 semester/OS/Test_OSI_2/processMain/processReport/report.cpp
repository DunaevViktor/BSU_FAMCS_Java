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
int main(int argc, char *argv[])//1 аргумент - имя бинарного файла, 2 аргумент - имя файла отчёта, 3 аргумент - код отчёта (1 - прод, 2 - не прод)
{
	setlocale(LC_ALL,".1251");
	fstream bfile;
	bfile.open(argv[1], ios::in | ios::binary);
	fstream txtfile;
	txtfile.open(argv[2],ios::out);
	txtfile<<"Отчёт по";
	int type = atoi(argv[3]);
	if(type==1)
	{
		txtfile<<" проданным товарам"<<endl;
	}
	if(type==2)
	{
		txtfile<<" не проданным товарам"<<endl;
	}
	txtfile<<"Файл:"<<argv[1];
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
			if(money!=0) //Чтобы не было дублирования последнего элемента
			{
			txtfile<<endl<<endl;
			txtfile<<"Код "<<o.n<<endl;
			txtfile<<"Имя "<<o.name<<endl;
			txtfile<<"Стоимость единицы товара "<<o.price<<endl;
			txtfile<<"Количество товаров всего "<<kolvo_tov<<endl;			
			txtfile<<"Стоимость выбранной группы товара: "<<money;
			}
		}
	}
	bfile.close();
	txtfile.close();
	return 0;
}
