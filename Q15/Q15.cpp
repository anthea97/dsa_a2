/* Topic: Stacks
 * Question: Remove Duplicate Letters
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results
 */
#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

string removeDuplicateLetters(string s) {

    vector<int> lastidx(26,0);
    vector<bool> charseen(26,false);
    stack<char> st;
    string res = "";

    for(int i = 0; i < s.length(); i++){
        lastidx[s[i] - 'a'] = i;
    }

    for(int i = 0; i < s.size(); i++){

        int curr = s[i] - 'a';

        if(charseen[curr]){
            continue;
        }

        while(st.size()!=0 && st.top() > s[i] && i < lastidx[st.top() - 'a']){
            charseen[st.top() - 'a'] = false;
            st.pop();
        }

        st.push(s[i]);
        charseen[curr] = true;

    }

    while(!st.empty()){
        res += st.top();
        st.pop();
    }

    reverse(res.begin(), res.end());

    return res;


}

int main(){
    string s1 = "cbacdcbc";

    cout<<removeDuplicateLetters(s1);

    return 0;
}