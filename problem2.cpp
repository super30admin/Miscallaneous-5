/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include <iostream>
#include <string>
 
using namespace std;
 
string deleteConsecutiveStrings(string s)
{
    int i = 0;
    int j = 0;
 
    string newElements = "";

    while (j < s.length()) {
        if (s[i] == s[j]) {
            j++;
        }
        else if (s[j] != s[i] || j == s.length() - 1) {
            newElements += s[i];
            i = j;
            j++;
        }
    }
    newElements += s[j - 1];
    return newElements;
}
 
int main()
{
    string s = "abbbaa";
 
    cout << "Input  : " << s << endl;
 
    cout << "Output : " << deleteConsecutiveStrings(s) << endl;
 
    return 0;
}