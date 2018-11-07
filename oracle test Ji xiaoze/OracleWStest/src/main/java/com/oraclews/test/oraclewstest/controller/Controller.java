/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oraclews.test.oraclewstest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ji
 */
@RestController
public class Controller {

    @RequestMapping(value = "/stringClean/{s}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> stringClean(@PathVariable("s") String s){
        if(s.equals("")) return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
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
        String result = new String(h.toString());
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
    @RequestMapping(value = "/maxBlock/{s}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> maxBlock(@PathVariable("s")  String s){
        if(s.equals("")) return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
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
        String result = count+"";
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
    @RequestMapping(value = "/reOrderBlock/{s}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> reOrderBlock(@PathVariable("s") String s){
        if(s.equals("")) return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        LinkedList<String> list=new LinkedList<>();
        char[] ca = s.toCharArray();
        for(int i=0;i<ca.length;i++){ 
            if((ca[i]>='a'&&ca[i]<='z')||(ca[i]>='A'&&ca[i]<='Z')){ 
                list.add(String.valueOf(ca[i])); 
            } 
        }
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        String result = list.toString();
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
}
    
