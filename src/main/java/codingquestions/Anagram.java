package codingquestions;
//Increase the count for each letter in the first word and decrease it for each letter in the second word. If all counts end at 0, the words are anagrams.package codingquestions;

import java.util.HashMap;

public class Anagram {

    public static void main(String[] args) {
    String s1= "earth";
    String s2= "heart";
        System.out.println(anagramStrings(s1,s2));

    }

    public static boolean anagramStrings(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        //Add values of s1
        HashMap<Character,Integer>hm = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(hm.containsKey(s1.charAt(i))){
                hm.put(s1.charAt(i),hm.get(s1.charAt(i))+1);
            }
            else{
                hm.put(s1.charAt(i),1);
            }
        }
        //Subtract values of s2
        for(int i=0;i<s2.length();i++){
            if(hm.containsKey(s2.charAt(i))){
                hm.put(s2.charAt(i),hm.get(s2.charAt(i))-1);
            }
            else{
                return false;
            }
        }
        //check if results are equal to 0
        for(int value: hm.values()){
            if(value!=0){
                return false;
            }
        }
       return true;
    }
}
