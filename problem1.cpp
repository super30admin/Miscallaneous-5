#include<iostream>
#include<vector>
#include<math.h>

using namespace std;

class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int sz = nums.size();
        int count{},max_len{},slow{};
        for(int i{};i<sz;++i){
            if(nums.at(i)==0){
                count++;
            }
            if(count>k){
                max_len = max(max_len,i-slow);
                while(nums.at(slow)!=0){
                    slow++;
                }
                slow++;
                count--;
            }
        }
        max_len = max(max_len,sz-slow);
        return max_len;
    }
};

class Solution_2 {
public:
    int longestOnes(vector<int>& nums, int k) {
        int sz = nums.size();
        int slow{},count{};
        for(int i{};i<sz;++i){
            if(nums.at(i)==0){
                count++;
            }
            if(count>k){
                if(nums.at(slow)==0){
                    count--;
                }
                slow++;
            }
        }
        return sz-slow;
    }
};

