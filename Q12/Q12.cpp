/* Topic: Linked List
 * Question: Reverse a Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
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

ListNode* reverseList(ListNode* head) {

    if(head == NULL || head->next == NULL){
        return head;
    }

    ListNode* prev = NULL;
    ListNode* temp = head;
    ListNode* curr;

    while(temp != NULL){
        curr = temp;
        temp = curr->next;
        curr->next = prev;
        prev = curr;
    }

    head = curr;

    return head;
}

void printLL(ListNode* head){
    if(head == NULL){
        cout<<"NULL";
        return;
    }
    ListNode* newnode = head;

    while(newnode!= NULL){
        cout<<newnode->val<<" ";
        newnode = newnode->next;
    }
}

int main(){

    ListNode* node1 = new ListNode(1);
    ListNode* node2 = new ListNode(2);
    ListNode* node3 = new ListNode(3);
    ListNode* node4 = new ListNode(4);
    ListNode* node5 = new ListNode(5);
    ListNode* head = new ListNode(0);

    node5->next = NULL;
    node4->next = node5;
    node3->next = node4;
    node2->next = node3;
    node1->next = node2;
    head->next = node1;

    cout<<"LL before reversal:\n";
    printLL(head);
    ListNode* newhead = reverseList(head);
    cout<<"\nLL after reversal:\n";
    printLL(newhead);

    return 0;

}