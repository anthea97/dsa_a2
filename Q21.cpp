/* Topic: Sorting
 * Question: Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
    int i=m-1,j=n-1,k=m+n-1;
    while(i>=0&&j>=0)
    {
        if(nums1[i]>nums2[j])
        {
            nums1[k--]=nums1[i--];

        }
        else
        {
            nums1[k--]=nums2[j--];

        }
    }

    while(j>=0){
        nums1[k--]=nums2[j--];
    }
}

void printarr(vector<int>&A){
    for(int i = 0; i < A.size(); i++){
        cout<<A[i]<<" ";
    }
    cout<<endl;
}

int main(){
    vector<int>nums1 = {1,2,3,0,0,0};
    vector<int>nums2 = {2,5,6};

    int m = nums1.size() - nums2.size();
    int n = nums2.size();
    printarr(nums1);
    printarr(nums2);
    merge(nums1, m, nums2, n);
    printarr(nums1);

    return 0;

}