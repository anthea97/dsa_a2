/* Topic: Linked Lists
 * Question: Linked List Cycle
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

void push(struct ListNode** head_ref, int new_data)
{
    /* allocate node */
    struct ListNode* new_node = new ListNode(new_data);

    /* link the old list off the new node */
    new_node->next = (*head_ref);

    /* move the head to point to the new node */
    (*head_ref) = new_node;
}

bool hasCycle(ListNode *head) {

    ListNode* fast;
    ListNode* slow;

    fast = head;
    slow = head;

    while(fast != NULL && fast -> next != NULL){
        slow = slow -> next; //Move slow pointer by 1
        fast = fast -> next -> next; //Move fast pointer by 2

        if(slow == fast){
            return true;
        }

    }

    return false;
}

int main(){
    ListNode* head = new ListNode(4);

    push(&head, 20);
    push(&head, 5);
    push(&head, 15);
    push(&head, 10);

    head->next->next->next->next = head;


    if(hasCycle(head))
        cout<<"Loop found"<<endl;

    else
        cout<<"No Loop"<<endl;

    return 0;

}