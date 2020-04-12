
#include <stdio.h>      /* printf, scanf, puts, NULL */
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <iostream>
#include <iomanip>

using namespace std;

double randFloat(double min, double max){
    return (max - min) * ( (double)rand() / (double)RAND_MAX ) + min;
}

int main()
{
    double alat = 34.25208817361047;
    double alng = -118.92853896485677;
    double blat = 34.241729565139245;
    double blng = -118.88304869996419;
    int truckcount = 10;
    srand (time(NULL));
    rand() % 10 + 1;
    int index = 1;
    for(int i = 1; i <= truckcount; i++){
        for(int day = 1; day <=7; day++){
            cout << "(" << index++ << "," << day << "," << "\"1:00\"" << "," << setprecision(14)  << randFloat(min(alat,blat), max(alat, blat)) << "," << setprecision(14) <<  randFloat(min(alng, blng), max(alng, blng)) << "," << "\"9:00\"" << "," << i << "," << "true" << ")," << endl;
        }
    }

    return 0;
}
