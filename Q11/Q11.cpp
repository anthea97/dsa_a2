/* Topic: Hashing
 * Question: Contains Duplicate
 * Given an integer array nums,
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

bool containsDuplicate(vector<int>& nums) {

    unordered_map<int,int> mymap;

    for(int i = 0; i < nums.size(); i++){

        if(mymap.find(nums[i]) != mymap.end()){
            return true;
        }

        mymap[nums[i]]++;

    }

    return false;
}

int main() {
    vector<int> arr = { 1, 1, 2, 2, 3, 5, 5, 6 };

    // Function calling
    (containsDuplicate(arr)? cout<<"Yes" : cout<<"No");
    return 0;
}
