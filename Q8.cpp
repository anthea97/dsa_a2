/* Topic: Hashing
 * Question: Two Sum
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 */

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {

    unordered_map<int,int> hmap;
    vector<int> result;

    for(int i = 0; i < nums.size(); i++){
        int look = target - nums[i];

        if(hmap.find(look) != hmap.end()){//if target-nums[i] exists in hashmap
            result.push_back(hmap[look]);
            result.push_back(i);
            break;
        }

        hmap[nums[i]] = i;
    }
    return result;

}

void printArr(vector<int> &A){

    for(int i = 0; i < A.size(); i++){
        cout<<A[i]<<" ";
    }
    cout<<endl;
}

int main() {

    vector<int> arr1 = {2,7,11,15};
    vector<int> arr2 = {3,2,4,5};
    vector<int> res1, res2;

    printArr(arr1);
    cout<<"Two Sum: ";
    res1 = twoSum(arr1,9);
    printArr(res1);

    printArr(arr2);
    cout<<"Two Sum: ";
    res2 =  twoSum(arr2, 6);
    printArr(res2);


    return 0;
}