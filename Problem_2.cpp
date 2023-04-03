Remove all the continuous character

Given a string we have to remove all the continuous character whose count is more than 2. For example :

abba ----> abba
abbb---->a is the output because c count is 3.
abbbaa---> '' empty string
abbacccaa--->abbHere relative order of characters and their counts must be maintained so we figured out that we cannot use hashtable. Give a solution better than O(n^2).


TC O(n)
SC O(n)


string removeDuplicates(string s) {
    stack<int> counts;
    for (int i = 0; i < s.size(); ++i) {
        if (i == 0 || s[i] != s[i - 1]) {
            counts.push(1);
        } else if (++counts.top() => 2) {
            counts.pop();
            s.erase(i - 2 + 1, 2);
            i = i - 2;
        }
    }
    return s;
}
