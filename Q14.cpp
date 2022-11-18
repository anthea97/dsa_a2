/* Topic: Strings
 * Question: Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool isAnagram(string s, string t) {
    if (s.size() != t.size()) {
        return false;
    }

    vector<int> count(26);

    for (int i = 0; i < s.size(); i++) {
        count[s[i] - 'a']++;
    }

    for (int j = 0; j < t.size(); j++) {
        count[t[j] - 'a']--;
        if (count[t[j] - 'a'] < 0) {
            return false;
        }
    }
    return true;

}

int main(){
    string s1 = "nagaram";
    string s2 = "anagram";



    (isAnagram(s1,s2))? cout<<"Yes" : cout<<"No";

    return 0;
}