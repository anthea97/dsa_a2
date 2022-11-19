/* Topic: Dynamic Programming
 * Question: Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

#include <iostream>
#include <vector>

using namespace std;

int climbStairs(int n) {
    if (n <= 2) return n;
    int prev = 2, prev2 = 1, res;
    for (int i = 3; i <= n; i++) {
        res = prev + prev2;
        prev2 = prev;
        prev = res;
    }
    return res;
}

int main()
{
    int n = 5;

    cout<<climbStairs(n);

    return 0;
}