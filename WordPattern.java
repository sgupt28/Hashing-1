//Time: O(n)
//Space: O(1), constant space of Hashmap/HashSet for the lowercase characters

class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String[] str=s.split(" ");

        if(pattern.length()!=str.length)
            return false;

        for(int i=0;i<pattern.length();i++){

            char c = pattern.charAt(i);

            if(map.containsKey(c)){
                if(!map.get(c).equals(str[i]))
                    return false;
            }
            else{
                if(set.contains(str[i]))
                    return false;

                map.put(c, str[i]);
                set.add(str[i]);
            }
        }
        return true;

    }
}