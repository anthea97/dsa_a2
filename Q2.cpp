/* Topic: Arrays
 * Question: Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int longestConsecutive(vector<int>& nums) {

    int maxcount = 0;
    int ele;

    if(nums.size() == 0){
        return 0;
    }

    int count = 0;
    unordered_set<int> hset;

    //Insert elements in hash set
    for(int i = 0; i < nums.size(); i++){
        hset.insert(nums[i]);
    }

    //Check for consecutive sequence
    for(int i = 0; i < nums.size(); i++){

        ele = nums[i];

        if(hset.find(ele - 1) == hset.end()){

            count = 1;

            while(hset.find(ele + 1) != hset.end()){
                count++;
                ele++;
            }

        }

        maxcount = max(maxcount, count);
    }

    return maxcount;
}

int main()
{
    vector<int> arr = { 1, 9, 3, 10, 4, 20, 2, 5, 11 };
    cout << "Length of the Longest contiguous subsequence "
            "is "
         << longestConsecutive(arr);
    return 0;
}