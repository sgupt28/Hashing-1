//Time Complexity: O(n*k), where n is the size if input array and k is the no. of characters in each string
//Space Complexity: O(n), used to store hashmap
//Did this code successfully run on Leetcode : Yes

/*Approach:
1. Calculate the hash value using prime product for each word in the string array
2. Map each word in  a hash map using the hash value generated as key
3. All the anagrams would be mapped to the same hash value
 */
class Solution {

    int primeNos[]=new int[26];

    public List<List<String>> groupAnagrams(String[] strs){

        HashMap<Double, List<String>> map = new HashMap<>();

        primeNos=getPrimeNos();

        for(int i=0;i<strs.length;i++){

            double hashCode=getHashValue(strs[i].toCharArray());

            if(!map.containsKey(hashCode))
                map.put(hashCode, new ArrayList<>());

            map.get(hashCode).add(strs[i]);

        }
        return new ArrayList<>(map.values());

    }

    public int[] getPrimeNos(){

        int arr[]=new int[26];

        int count=0;
        int num=2;

        while(count<26){

            int isPrime=1;
            for(int i=2;i<=Math.sqrt(num);i++){

                if(num%i==0){
                    isPrime=0;
                    break;
                }
            }
            if(isPrime==1){
                arr[count++]=num;
            }
            num++;
        }

        return arr;

    }
    public double getHashValue(char arr[]){

        double hash=1;
        for(char c: arr){
            hash=hash*primeNos[c-'a'];
        }

        return hash;
    }
}