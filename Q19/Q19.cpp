/* Topic: Heap/Priority Queues
 * Question: Sort an Array
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions
 * in O(nlog(n)) time complexity and with the smallest space complexity possible.
 */

#include <iostream>
#include <vector>

using namespace std;

void heapify(vector<int>&nums,int n,int i){
    int l=2*i+1;
    int r=2*i+2;
    int lar=i;

    if(l<n && nums[l]>nums[lar])
        lar=l;
    if(r<n && nums[r]>nums[lar])
        lar=r;

    if(lar!=i){
        swap(nums[lar],nums[i]);
        heapify(nums,n,lar);
    }
}

void buildheap(vector<int>&nums,int n){
    for(int i=(n-2)/2;i>=0;i--){
        heapify(nums,n,i);
    }
}

void heapsort(vector<int>&nums,int n){
    buildheap(nums,n);

    for(int i=n-1;i>=0;i--){
        swap(nums[i],nums[0]);
        heapify(nums,i,0);
    }
}

vector<int> sortArray(vector<int>& nums) {
    heapsort(nums,nums.size());
    return nums;
}

void printarr(vector<int>&A){
    for(int i = 0; i < A.size(); i++){
        cout<<A[i]<<" ";
    }
    cout<<endl;
}
int main(){
    vector<int> nums = {5,1,1,2,0,0,7};
    vector<int> res;

    cout<<"Before:";
    printarr(nums);
    res = sortArray(nums);
    cout<<"After:";
    printarr(res);

    return 0;
}