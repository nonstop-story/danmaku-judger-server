package com.emmmer.killer;

import java.util.HashMap;
import java.util.Map;

public class AddBlackList {

    public static void main(String[] args) {
        Map<String, String> man = new HashMap<String, String>();
        man.put("uid", "12345678");
        man.put("type", "black");

        if (man.get("type").equals("black")){

        }
        var a = man.get("uid");
        System.out.println(a);
    }
}
