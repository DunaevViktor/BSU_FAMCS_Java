#include <iostream>
#include <Windows.h>
#include <cmath>

using namespace std;

CRITICAL_SECTION cs;

struct polynom{
	int argument;
	int stepen;
	int* koef;
	int count;
	polynom(int argument1, int stepen1, int* koef1){
		argument = argument1;
		stepen = stepen1;
		koef = new int[stepen1+1];
		for (int i = 0; i < stepen1+1; i++)
		{
			koef[i] = koef1[i];
		}
	}
};



int Polynom(void* p1)
{
	polynom* p = (polynom*)p1;
	int summ = 0;
	int deg = p->stepen;
	for (int i = 0; i < p->stepen+1; i++)
	{
		summ += pow((double)p->argument, deg)*p->koef[i];
		deg--;
		Sleep(200);
	}

	EnterCriticalSection(&cs);

	int deg1 = p->stepen;
	for (int i = 0; i < p->stepen + 1; i++)
	{
		if (i != p->stepen){
			cout << p->koef[i] << "*(" << "x" << "^" << deg1 << ")" << "+";
            deg1--;
		}
		else
			cout << p->koef[i];
	}
	cout << endl;
	p->count = summ;
	cout << "P(" << p->argument << ") = " << p->count << endl;
    LeaveCriticalSection(&cs);

	//DeleteCriticalSection(&cs);

	return summ;
}

int main()
{
	setlocale(LC_ALL, ".1251");
	HANDLE 	hThread[2];
	DWORD	dwThread[2];
	InitializeCriticalSection(&cs);

	

	int arg, step1,step2; 
	int* koef1; int* koef2;
	cout << "¬ведите степень полинома 1 и 2:" << endl;
	cin >> step1;
	cin >> step2;
	koef1 = new int[step1+1];
	cout << "¬ведите коэффициенты первого(stepen1+1):" << endl;
	for (int i = 0; i < step1+1; i++)
	{
		cin >> koef1[i];
	}
	koef2 = new int[step2 + 1];
	cout << "¬ведите коэффициенты второго (stepen2+1):" << endl;
	for (int i = 0; i < step2 + 1; i++)
	{
		cin >> koef2[i];
	}
	cout << "¬ведите аргумент:" << endl;
	cin >> arg;
	polynom p1(arg, step1, koef1);
	polynom p2(arg, step2, koef2);
	//int summ1 = countPolynom(&p1);
	//int summ2 = countPolynom(&p2);

	hThread[0] = CreateThread(NULL, 0, (LPTHREAD_START_ROUTINE)Polynom,
		&p1, 0, &dwThread[0]);

	hThread[1] = CreateThread(NULL, 0, (LPTHREAD_START_ROUTINE)Polynom,
		&p2, 0, &dwThread[1]);

	if (WaitForMultipleObjects(2, hThread, TRUE, INFINITE) == WAIT_FAILED)
	{
		cout << "Wait for multiple objects failed." << endl;
		cout << "Press any key to exit." << endl;
	}

	double res = (p1.count*1.0)/p2.count;
	cout << "f("<<arg<<") = " << res << endl;

	CloseHandle(hThread[0]);
	CloseHandle(hThread[1]);

	system("pause");

	return 0;
}