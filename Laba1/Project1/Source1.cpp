#include <iostream> 
#include <locale> 
#include <conio.h> 
#include <memory> 

using namespace std;

class Rational
{
private:
	std::unique_ptr<int> num = std::make_unique<int>();
	std::unique_ptr<int> den = std::make_unique<int>();

	void reduce()
	{
		int nod = NOD(*num, *den);
		*num = *num / nod;
		*den = *den / nod;
	}

public:
	Rational()//конструктор по умолчанию 
	{
		*this->num = 0;
		*this->den = 1;
	}

	Rational(int a, int b) // Конструктор с параметрами
	{
		if (b < 0)
			exit(1);
		*num = a;
		if (b > 0)
			*den = b;
		else
			exit(1);
		reduce();
	}

	Rational(const Rational &tmp)
	{
		*this->num = *tmp.num;
		*this->den = *tmp.den;
	}

	int getNum()
	{
		return *this->num;
	}

	int getDen()
	{
		return *this->den;
	}

	void setNum(int number)
	{
		*this->num = number;
	}

	void setDen(int number)
	{
		*this->den = number;
	}

	int NOD(int a, int b)
	{
		int x = abs(a), y = abs(b);
		while (x != 0 && y != 0) {
			if (x >= y)
				x = x % y;
			else
				y = y % x;
		}
		return x + y;
	}

	

	Rational operator + (const Rational &tmp)
	{
		Rational temp;
		if (*this->den == *tmp.den)
		{
			*temp.den = *this->den;
			*temp.num = *this->num + *tmp.num;
		}
		else
		{
			*temp.den = *this->den * *tmp.den;
			*temp.num = (*temp.den / *this->den * *this->num) + (*temp.den / *tmp.den * *tmp.num);

		}
		temp.reduce();

		return temp;
	}

	Rational operator - (const Rational &tmp)
	{
		Rational temp;
		if (*this->den == *tmp.den)
		{
			*temp.den = *this->den;
			*temp.num = *this->num - *tmp.num;
		}
		else
		{
			*temp.den = *this->den * *tmp.den;
			*temp.num = (*temp.den / *this->den * *this->num) - (*temp.den / *tmp.den * *tmp.num);

		}
		temp.reduce();

		return temp;
	}

	Rational operator * (const Rational &tmp)
	{
		Rational temp;
		*temp.den = *this->den * *tmp.den;
		*temp.num = *tmp.num * *this->num;

		temp.reduce();

		return temp;
	}

	Rational operator / (const Rational &tmp)
	{
		Rational temp;
		*temp.den = *this->den * *tmp.num;
		*temp.num = *tmp.den * *this->num;

		temp.reduce();

		return temp;
	}

	Rational operator = (const Rational &tmp)
	{
		return Rational(tmp);
	}

	Rational operator >= (const Rational &tmp)
	{
		Rational temp;
		Rational srav;
		if (*this->den == *tmp.den)
		{
			*temp.den = *this->den;
			if (*this->num > *tmp.num) *temp.num = *this->num;
			else *temp.num = *tmp.num;
		}
		else if (*this->num == *tmp.num)
		{
			*temp.num = *this->num;
			if (*this->den < *tmp.den) *temp.den = *this->den;
			else *temp.den = *tmp.den;
		}
		else
		{
			*srav.num = *this->num * *tmp.den;
			*srav.den = *this->den * *tmp.den;

			*tmp.den = *srav.den;
			*tmp.num *= *this->den;

			if (*srav.num > *tmp.num)
			{
				*temp.num = *srav.num;
				*temp.den = *srav.den;
			}
			else
			{
				*temp.num = *tmp.num;
				*temp.den = *tmp.den;
			}
		}
		temp.reduce();
		return temp;
	}

	friend ostream &operator << (ostream &out, const Rational &rvalue)
	{
		return (out << " " << *rvalue.num << "/" << *rvalue.den << "\n");
	}

	friend istream &operator >> (istream &in, const Rational &rvalue)
	{
		cout << "Enter rational value (num/den): ";
		in >> *rvalue.num;
		in.ignore();
		in >> *rvalue.den;
		return in;
	}

	
};

int main()
{
	Rational A(2, 3);
	Rational B(3, 4);
	Rational C, D, F;
	cin >> C;
	cin >> D;
	cout << "-----------------\n";
	cout << "Sum = " << (C + D);
	cout << "-----------------\n";
	cout << "Comp - " << (C >= D);
	cout << "-----------------\n";
	cout << "Dif = " << (C - D);
	cout << "-----------------\n";
	cout << "Mult = " << (C * D);
	cout << "-----------------\n";
	cout << "Div  = " << (C / D);

	system("pause");
	return 0;
}