#include <windows.h>
#include <conio.h>
#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	setlocale(LC_ALL,".1251");
	cout<<"Введите имя создаваемого бинарного файла?"<<endl;
	char* filename = new char[105];
	cin.getline(filename,99,'\n');
	strcat(filename,".bin");
	char lpszCommandLine[150]="processCreator.exe ";
	
	STARTUPINFO si;
	PROCESS_INFORMATION piCom;
	strcat(lpszCommandLine,filename);
	ZeroMemory(&si, sizeof(STARTUPINFO));
	si.cb = sizeof(STARTUPINFO);

	 CreateProcess(NULL,lpszCommandLine, NULL, NULL, FALSE,
			CREATE_NEW_CONSOLE, NULL, NULL, &si, &piCom);
	 WaitForSingleObject(piCom.hProcess,INFINITE);
	 CloseHandle(piCom.hThread);
	 CloseHandle(piCom.hProcess);

	cout<<"Введите имя создаваемого текстового файла?"<<endl;
	char* filenameOut = new char[105];
	cin.getline(filenameOut,99,'\n');
	strcat(filenameOut,".txt");
	char processReportCalling[350]="processReport.exe ";

	strcat(processReportCalling,filename);
	strcat(processReportCalling," ");
	strcat(processReportCalling,filenameOut);
	strcat(processReportCalling," ");

	cout<<"Выберите тип операции 1(проданные) или 2 (оставшиеся) товары?"<<endl;
	int type;
	cin>>type;
	char*str=new char[10];
	itoa(type,str,10);
	strcat(processReportCalling,str);

	 CreateProcess(NULL,processReportCalling, NULL, NULL, FALSE,
			CREATE_NEW_CONSOLE, NULL, NULL, &si, &piCom);
    WaitForSingleObject(piCom.hProcess,INFINITE);
	CloseHandle(piCom.hThread);
	CloseHandle(piCom.hProcess);

	fstream file;
	file.open(filenameOut,ios::in);
	char h[1000];
	while(!(file.eof()))
	{	
		file.getline(h,999,'\n');
		cout<<h<<endl;
	}
	file.close();

	_cputs("Процесс создан.\n");
	_cputs("Нажмите клавишу для завершения.\n");
	_getch();

	return 0;
}