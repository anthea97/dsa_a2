/* Topic: Search Trees
 * Question: Convert Sorted Array into Binary Search Tree
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */

#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

TreeNode* buildBST(vector<int>& A, int l, int r){

    if(l > r){
        return NULL;
    }
    int mid = r -(r - l)/2;

    TreeNode* root = new TreeNode(A[mid]);

    root->left = buildBST(A, l, mid-1);
    root->right = buildBST(A, mid + 1, r);

    return root;

}

TreeNode* sortedArrayToBST(vector<int>& nums) {

    return buildBST(nums, 0, nums.size()-1);

}

void printPreorder(TreeNode* root){

    if(root == NULL){
        cout<<" null";
        return;
    }

    cout<<" "<<root -> val;

    printPreorder(root->left);
    printPreorder(root->right);

}

int main() {
    vector<int> nums = {-10, -3, 0, 5, 9};

    TreeNode *mytree = new TreeNode();
    mytree = sortedArrayToBST(nums);
    cout<<"Preorder Traversal:"<<endl;
    printPreorder(mytree);

    return 0;
}