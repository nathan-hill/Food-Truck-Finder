#include <iostream>
#include <stdio.h>      /* printf, scanf, puts, NULL */
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
using namespace std;

double randFloat(double min, double max){
    return (max - min) * ( (double)rand() / (double)RAND_MAX ) + min;
}

int main()
{
    srand (time(NULL));
    int id = 1;

    string description[] = {"\"Super good food at super low prices\"",
                            "\"Definitely delicious but possibly dangerous\"",
                            "\"Hope It's Taco , It's Taco , We Hope It's Taco ...\"",
                            "\"God made Taco .\"",
                            "\"Taco , satisfies the need.\"",
                            "\"Nothing Sucks Like A Taco.\"",
                            "\"Australians Wouldn't Give A Taco  For Anything Else.\"",
                            "\"Give That Man A Taco .\"",
                            "\"Taco  beams with quality.\"",
                            "\"Fresh from the Captain's Taco .\""};
    string menu[] = {"\"Burger\"",
                     "\"Taco\"",
                     "\"Chicken\"",
                     "\"Grease\"",
                     "\"Curry\"",
                     "\"Pasta\"",
                     "\"Sandwitches\"",
                     "\"Oatmean\"",
                     "\"Coffee\"",
                     "\"Salad\""};

    string name[] = {"\"Taco Wedge\"",
                     "\"Tacodo\"",
                     "\"Taco Flawless\"",
                     "\"Tacoopedia\"",
                     "\"Tacoail\"",
                     "\"Tacopath\"",
                     "\"Taco Access\"",
                     "\"Taco Top\"",
                     "\"Taco Cuts\"",
                     "\"Taco Relish\""};
    string type[] = {"\"ITALIAN\"",
                     "\"VIETNAMESE\"",
                     "\"CHINESE\"",
                     "\"AFRICAN\"",
                     "\"RUSSIAN\"",
                     "\"MEXICAN\"",
                     "\"MEXICAN\"",
                     "\"AMERICAN\"",
                     "\"AMERICAN\"",
                     "\"AMERICAN\"",
    };
    int cost[] = {0, 1,0,1,0,0,3,1,2,3};

    for(int i = 0; i < 10; i++ ){
        cout << "(" << i + 1 << "," << description[i] << "," << menu[i] << "," << name[i] << "," << "\"yes\"" << "," << 82 <<"," << type[i] <<"," << cost[i] << ")," << endl;
    }

    return 0;
}
