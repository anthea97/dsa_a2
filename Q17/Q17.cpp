/* Topic: Queues
 * Question: Implement Stack Using Queues
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 */

#include <iostream>
#include <queue>

using namespace std;

class Stack {
    queue<int> q;
public:
    void push(int data);
    void pop();
    int top();
    int size();
    bool empty();
};

void Stack::push(int data)
{
    //  Get previous size of queue
    int s = q.size();

    // Push the current element
    q.push(data);

    // Pop all the previous elements and put them after
    // current element

    for (int i = 0; i < s; i++) {
        // Add the front element again
        q.push(q.front());

        // Delete front element
        q.pop();
    }
}

void Stack::pop()
{
    if (q.empty())
        cout << "No elements\n";
    else
        q.pop();
}

// Returns top of stack
int Stack::top() {
    return (q.empty()) ? -1 : q.front();
}

// Returns true if Stack is empty else false
bool Stack::empty() {
    return (q.empty());
}

int Stack::size(){
    return q.size();
}

int main()
{
    Stack st;
    st.push(1);
    st.push(2);
    st.push(3);
    cout << "current size: " << st.size() << "\n";
    cout << "Pop "<<st.top() << "\n";
    st.pop();
    cout << "Pop "<<st.top() << "\n";
    st.pop();
    cout << "Pop "<<st.top() << "\n";
    cout << "current size: " << st.size();
    return 0;
}
