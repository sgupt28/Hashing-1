//Time Complexity: O(n),
//Space Complexity: O(1), constant size of hashMap/hashset for valid ASCII characters
//Did this code successfully run on Leetcode : Yes

/*Approach:
1. Map each character in string a to  string b at the same index using hashmap
2. If a key already exists and value is not same, return false
3. If key and value are unique , but the value is already mapped to some other character return false
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set= new HashSet<>();

        for(int i=0;i<s.length();i++){ //O(n)
            char a=s.charAt(i);
            char b=t.charAt(i);

            if(map.containsKey(a)){
                if(map.get(a)!=b)
                    return false;
            }

            else{
                if(set.contains(b))
                    return false;

                map.put(a,b);
                set.add(b);
            }
        }

        return true;

    }
}