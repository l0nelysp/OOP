//#include <iostream>
//#include <locale>
//#include <conio.h>
//#include <memory>
//
//using namespace std;
//
//class Rational
//{
//private: 
//	std::unique_ptr<int> num = std::make_unique<int>();
//	std::unique_ptr<int> den = std::make_unique<int>();
//
//	void reduce()
//	{
//		int nod = NOD(*num, *den);
//		num = std::make_unique<int>(*num / nod);
//		den = std::make_unique<int>(*den / nod);
//	}
//
//public:
//	Rational()//конструктор по умолчанию
//	{
//		*this->num = 0;
//		//this->num = make_unique<int>(1);
//		//this->den = make_unique<int>(2);
//		*this->den = 1;
//	}
//
//	Rational(int a,int b) //  онструктор с данными
//	{
//		if (b<0)
//			exit(1);
//		num = std::make_unique<int>( a);
//		if (b > 0)
//			den = std::make_unique<int>(b);
//		else
//			exit(1);
//		reduce();
//	}
//
//	int NOD(int a, int b)
//	{
//		int x = abs(a), y = abs(b);
//		while (x != 0 && y != 0) {
//			if (x >= y)
//				x = x % y;
//			else
//				y = y % x;
//		}
//		return x + y;
//	}
//
//
//	Rational &operator + (const Rational &tmp)
//	{
//		Rational temp;
//		if (*this->den == *tmp.den)
//		{
//			temp.den = std::make_unique<int>(*this->den);
//			temp.num = std::make_unique<int>(*this->num * *tmp.num);
//		}
//		else
//		{
//			temp.den = std::make_unique<int>(*this->den * *tmp.den);
//			temp.num = std::make_unique<int>((*this->num * *tmp.den) + (*this->den * *tmp.num));
//		}
//		temp.reduce();
//		return temp;
//	}
//
//	friend ostream &operator << (ostream &stream_out, Rational &rvalue)
//	{
//		stream_out << "Rational number: " << *rvalue.num << "/" << *rvalue.den << endl;
//		return stream_out;
//	}
//};
//
//int main()
//{
//	Rational A;
//	Rational B(3,25);
//	cout << (A + B);
//
//	system("pause");
//	return 0;
//}