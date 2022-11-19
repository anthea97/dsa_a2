/* Topic: 2D Arrays
 * Question: Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
*/

#include <iostream>
#include <vector>

using namespace std;

#define R 4
#define C 4

 void spiralPrint(int m, int n, int a[R][C])
{
    int i, k = 0, l = 0;

    /* k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
    */

    while (k < m && l < n) {
    for (i = l; i < n; ++i) {
        cout << a[k][i] << " ";
        }
    k++;

    /* Print the last column
     from the remaining columns */
    for (i = k; i < m; ++i) {
        cout << a[i][n - 1] << " ";
    }
    n--;
    /* Print the last row from
                    the remaining rows */
        if (k < m) {
            for (i = n - 1; i >= l; --i) {
                cout << a[m - 1][i] << " ";
            }
            m--;
        }

    /* Print the first column from
               the remaining columns */
    if (l < n) {
        for (i = m - 1; i >= k; --i) {
            cout << a[i][l] << " ";
        }
        l++;
    }
}

    /* Print the last row from
                the remaining rows */
     if (k < m) {
         for (i = n - 1; i >= l; --i) {
             cout << a[m - 1][i] << " ";
         }
         m--;
     }

     /* Print the first column from
                the remaining columns */
     if (l < n) {
         for (i = m - 1; i >= k; --i) {
             cout << a[i][l] << " ";
         }
         l++;
     }
 }

int main()
{
    int a[R][C] = { { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 10, 11, 12 },
                    { 13, 14, 15, 16 } };

    // Function Call
    spiralPrint(R, C, a);
    return 0;
}