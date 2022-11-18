/* Topic: Recursion
 * Question: Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */

#include <iostream>
#include <cmath>

using namespace std;

double myPow(double x, int n) {

    if(n < 0) {
        x = 1 / x;
    }

    long num = labs(n);

    double pow = 1;

    while(num){ // equivalent to while(num != 0)
        if(num & 1) { // equivalent to if((num & 1) != 0)
            pow *= x;
        }

        x *= x;
        num >>= 1;
    }

    return pow;
}

int main(){
    int x = 2.00000;
    int n = 10;

    cout<<myPow(x, n);
}