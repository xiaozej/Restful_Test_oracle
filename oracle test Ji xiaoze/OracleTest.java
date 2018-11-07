/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracletest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ji
 */
public class OracleTest {

    /**
     * @param args the command line arguments
     */
    public static String stringClean(String s){
        if(s.equals("")){
        return null;}
        List<String> h = new ArrayList();
        int i=0;
        String[] ss= s.split("");
        h.add(ss[0]);
        for(String sh:ss){
            if(h.get(i).equals(sh)){
                continue;
            }else{
                h.add(sh);
            }
            i++;
        }      
        return h.toString();
    }
    public static int maxBlock(String s){
        if(s.equals("")){return 0;}
        int count=0;
        String[] ss= s.split("");
        String start=ss[0];
        int counttemps=1;
        for(int i=1;i<ss.length;i++){
            if(start.equals(ss[i])){
                counttemps+=1;
                if(counttemps>count){
                    count=counttemps;
                }
            }else{
                start=ss[i];
            }
        }       
        return count;
    }

    public static String reOrderBlock(String s){
        if(s.equals("")) return null;
        LinkedList<String> list=new LinkedList<>();
        char[] ca = s.toCharArray();
        for(int i=0;i<ca.length;i++){ 
            if((ca[i]>='a'&&ca[i]<='z')||(ca[i]>='A'&&ca[i]<='Z')){ 
                list.add(String.valueOf(ca[i])); 
            } 
        }
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list.toString();
    }
    
    public static void main(String[] args) {
        String hello = "helllloworld";
        //System.out.println(stringClean(hello));
        //System.out.println(maxBlock(hello));
        System.out.println(reOrderBlock("bbAAccAadF"));
    }   
}
