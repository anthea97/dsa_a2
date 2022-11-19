/* Topic: Searching
 * Question: Sort an Array
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions
 * in O(nlog(n)) time complexity and with the smallest space complexity possible.
 */
#include <iostream>
#include <vector>

using namespace std;

int binarySearch(vector<int>&A, int l, int r, int target){
    int mid;

    while(l <= r){
        mid = l + (r-l)/2;

        if(A[mid] == target){
            return mid;
        }
        else if(A[mid] < target){
            l = mid + 1;
        }
        else{
            r = mid - 1;
        }
    }

    return -1;
}

int search(vector<int>& nums, int target) {

    int left = 0;
    int right = nums.size()-1;
    int mid;
    int boundary = -1;

    //Search for the boundary index
    while(left <= right){
        mid = left + (right - left)/2;

        if(nums[mid] > nums[mid + 1]){
            if(mid == 0 || nums[mid] > nums[mid - 1]){
                boundary = mid;
                break;
            }
            else if(mid !=0 && nums[mid] < nums[mid - 1]){
                boundary = mid - 1;
                break;
            }

        }
        else if((nums[mid] < nums[mid + 1]) && (nums[mid] > nums[mid - 1])){
            if(nums[mid] < nums[right]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
    }

    //Search in the two different arrays
    int res_l = binarySearch(nums, 0, boundary, target);
    int res_r = binarySearch(nums, boundary + 1, nums.size() - 1, target);


    if(res_l == -1)return res_r;
    if(res_r == -1)return res_l;

    return -1;

}

int main(){

    vector<int> nums = {4,5,6,7,0,1,2};
    int target = 0;

    cout<<"Found at index "<<search(nums, target);

    return 0;

}