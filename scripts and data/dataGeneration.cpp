#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <string>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <cstring>
#include <queue>
#include <cassert>
using namespace std;

#define FOR(i,a,b) for(int i=a;i<b;++i)
#define SFOR(i,a,b,c) for(int i=a;i<b;i+=c)
#define REP(i,n) FOR(i,0,n)
#define RFOR(i,a,b) for(int i=a;i>=b;i--)
#define RREP(i,n) RFOR(i,n-1,0)
#define ECH(it, v) for(typeof(v.begin()) it=v.begin();it!=v.end();++it)
#define ALL(x) (x).begin(),(x).end()
#define SRT(x) sort(ALL(x))
#define CLR(x) memset(x,0,sizeof(x))
#define SET(x) memset(x,-1,sizeof(x))
#define MOD 1000000007
typedef long long LL;
typedef unsigned int UI;
typedef unsigned long long UL;
typedef vector<int> VI;
typedef vector<vector<int> > VVI;
typedef vector<string> VS;
typedef pair<int, int> PI;

string to_string(const int& n)
{
	std::ostringstream stm ;
	stm << n ;
	return stm.str() ;
}

int main() {
	freopen("Borrowers.csv", "w", stdout);
	string cs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	string an = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	string nm = "0123456789";
/*
	//People
	REP(i, 1000) {
		int ln = 12;
		string s1 = "";
		REP(j, ln)
			s1 += nm[rand()%nm.length()];
		string s2 = "";
		ln = 10 + rand()%31;
		REP(j, ln)
			s2 += cs[rand()%cs.length()];
		string s3;
		switch(rand()%10) {
			case 1: s3 = "Faculty";
				break;
			case 2: s3 = "Staff";
				break;
			default: s3 = "Student";
				break;
		}
		string s4 = "";
		ln = 10;
		REP(j, ln)
			s4 += nm[rand()%nm.length()];
		cout<<"\""<<s1<<"\","<<"\""<<s2<<"\","<<"\""<<s3<<"\","<<"\""<<s4<<"\""<<endl;
	}
*/
/*
	//Books
	REP(i, 10000) {
		int ln = 10 + rand()%31;
		string s1 = "";
		REP(j, ln)
			s1 += cs[rand()%cs.length()];
		string s2 = "";
		ln = 10 + rand()%41;
		REP(j, ln)
			s2 += cs[rand()%cs.length()];
		ln = 10 + rand()%11;
		string s3 = "";
		REP(j, ln)
			s3 += an[rand()%an.length()];
		string s4 = rand()&1?"Yes":"No";
		cout<<"\""<<s1<<"\","<<"\""<<s2<<"\","<<"\""<<s3<<"\","<<"\""<<s4<<"\""<<endl;
	}
*/
	//Borrowers
	REP(i, 1000) {
		int ln = 10 + rand()%11;
		string s1 = "";
		REP(j, ln)
			s1 += an[rand()%an.length()];
		string s2 = "";
		ln = 12;
		REP(j, ln)
			s2 += nm[rand()%nm.length()];
		string s3 = to_string(2010 + rand()%6) + "/" + to_string(1 + rand()%12) + "/" + to_string(1 + rand()%28);
		string s4 = s3;
		while(s3 >= s4)
			s4 = to_string(2010 + rand()%10) + "/" + to_string(1 + rand()%12) + "/" + to_string(1 + rand()%28);
		cout<<"\""<<s1<<"\","<<"\""<<s2<<"\","<<"\""<<s3<<"\","<<"\""<<s4<<"\""<<endl;
	}
}