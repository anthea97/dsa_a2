/* Topic: Arrays
 * Question: Majority Element
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */

#include <iostream>
#include<vector>

using namespace std;

int majorityElement(vector<int>& nums) {

    int ME;
    int me_count = 1;
    int n = nums.size();

    ME = nums[0];


    for(int i = 1; i < n; i++){

        if(me_count == 0){
            ME = nums[i];
            me_count = 1;
        }
        else{
            if(nums[i] == ME){
                me_count++;
            }
            else{
                me_count--;
            }
        }

    }

    return ME;
}

int main() {
    vector<int> arr = { 1, 1, 2, 1, 3, 5, 1 };

    // Function calling
    cout<<"The majority element is "<<majorityElement(arr);
    return 0;
}
