/* Topic: Linked Lists
 * Question: Remove Nth Node From End of List
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 */

#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* removeNthFromEnd(ListNode* head, int n) {

    ListNode* slow = head;
    ListNode* fast = head;
    ListNode* dummy = new ListNode(0, head);

    if(head -> next == NULL){
        return NULL;
    }


    while(n > 0 && fast != NULL){
        fast = fast -> next;
        n--;
    }

    //If we reached null, it means n = number of nodes in the list, so delete           //first node
    if(fast == NULL){
        head = head -> next;
        return head;
    }

    //move the two pointers till we reach the end of the list
    while(fast->next != NULL){
        fast = fast -> next;
        slow = slow -> next;
    }

    slow -> next = slow -> next -> next;

    return head;

}

int main(){

    return 0;
}