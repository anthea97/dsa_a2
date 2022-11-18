/* Topic: Strings
 * Question: Reverse words in a string
 * Write a function that reverses a string.
 * The input string is given as an array of characters.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */

#include <iostream>
#include <string>

using namespace std;

string reverseWords(string s) {
    string word = "";
    string res = "";
    for (char i: s) {
        if (i == ' ') {
            res = word + " " + res;
            word = "";
        } else {
            word += i;
        }
    }
    res = word + " " + res;
    return res.substr(0, res.size() - 1);
}

int main(){
    string s1 = "the sky is blue";

    string res1 = reverseWords(s1);

    cout<<"Reverse of "<<s1<<":"<<res1;

    return 0;
}