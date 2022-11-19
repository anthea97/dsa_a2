/* Topic: Heaps/Priority Queues
 * Question: Kth Largest Element in a Stream
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class KthLargest {
public:
    KthLargest(int k, vector<int>& nums) {
        this -> k = k;

        for(int i = 0; i < nums.size(); i++){
            pq.push(nums[i]);

        }
        while(pq.size() > this -> k){
            pq.pop();
        }
    }

    int add(int val) {
        pq.push(val);

        if(pq.size() > k){
            pq.pop();
        }
        return pq.top();
    }
private:
    int k;
    priority_queue<int, vector<int>, greater<int>> pq;
};

int main(){
    int k = 3;
    vector<int> nums = {4, 5, 8, 2};
    KthLargest* obj = new KthLargest(k, nums);

    int param_1 = obj->add(10);
    cout<<"Kth Largest Value after adding 10: "<<param_1<<endl;
    int param_2 = obj->add(15);
    cout<<"Kth Largest Value after adding 15: "<<param_2<<endl;

    return 0;

}