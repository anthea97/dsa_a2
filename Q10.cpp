/* Topic: Arrays
 * Question: Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 */

#include <iostream>
#include <vector>

using namespace std;

int removeDuplicates(vector<int>& nums) {

    if(nums.size() == 1){
        return 1;
    }
    int i = 0;
    int j = 1;
    int k = 1;
    int n = nums.size();

    while(i < n && j < n){
        if(nums[i] == nums[j]){
            j++;
        }
        else{
            nums[i+1] = nums[j];
            i++;
            j++;
            k++;
        }
    }

    return k;


}

int main() {
    vector<int> arr = { 1, 1, 2, 2, 3, 5, 5, 6 };

    // Function calling
    cout<<"Number of elements after removing duplicates: "<<removeDuplicates(arr);
    return 0;
}