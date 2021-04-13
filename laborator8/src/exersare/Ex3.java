package exersare;

import java.security.PublicKey;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Se da un string.
 * Sa se afiseze numarul de aparitii pt fiecare litera.
 *
 * Input:
 * "abracadabra":
 *
 * Output:
 * a: 5
 * b: 2
 * c: 1
 * d: 1
 * r: 2
 */
public class Ex3 {
    public static void main(String[] args){
        String input = "abracadabra";

        Map<Character,Integer> map = new TreeMap<>();

        for (char c : input.toCharArray()) {
            if(map.containsKey(c)){
                Integer value = map.get(c);
                map.put(c, value+1);
            }else {
                map.put(c,1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Key : "+entry.getKey()+ " , value : "+entry.getValue());
        }
    }

}