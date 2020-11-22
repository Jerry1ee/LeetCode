package Q242有效的字母异位词;

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        Character[] chars = new Character[26];

        for(char c : s.toCharArray()){
            chars[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            chars[c - 'a']--;
        }
        for(int i = 0;i<26;i++){
            if(chars[i] != 0) return false;
        }
        return true;
    }
}
