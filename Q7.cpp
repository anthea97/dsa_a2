/* Topic: Arrays
 * Question: Rotate Array
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

#include <iostream>
#include <vector>

using namespace std;

void reverse(vector<int>&A, int start, int end){
    int n = A.size();

    int i = start;
    int j = end;

    while(i <= j){
        swap(A[i], A[j]);
        i++;
        j--;
    }
}

void rotate(vector<int>& nums, int k) {

    int N = nums.size();

    if(k == N){
        return;
    }
    if(k > N){
        k = k % N;
    }
    //Reverse whole array
    reverse(nums, 0, N-1);

    //Reverse first k elements
    reverse(nums, 0, k-1);

    //Reverse remaining
    reverse(nums, k, N-1);

}

void printArr(vector<int> &A){

    for(int i = 0; i < A.size(); i++){
        cout<<A[i]<<" ";
    }
    cout<<endl;
}
int main(){

    vector<int> arr1 = {1,2,3,4,5,6,7};
    vector<int> arr2 = {-1,-100,3,99};

    printArr(arr1);
    rotate(arr1, 3);
    cout<<"{1,2,3,4,5,6,7} rotated by 3: ";
    printArr(arr1);

    printArr(arr2);
    rotate(arr2, 2);
    cout<<"{-1,-100,3,99} rotated by 2: ";
    printArr(arr2);

    return 0;
}