package com.Spring.StackWithObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TypeCheck {
    public static HashMap<String, String> check(Object type_obj){
        if (type_obj instanceof String){
            String type = ((String) type_obj).toLowerCase();
            var allowed = new ArrayList<String>(Arrays.asList("integer","float","boolean","string","object"));
            if (allowed.contains(type)){
                return new HashMap<>(){{put("success", "1");put("value", type);}};
            }
            else{
                return new HashMap<>(){{put("success", "0");}};
            }
        }
        else{
            return new HashMap<>(){{put("success", "0");}};
        }
    }
}
