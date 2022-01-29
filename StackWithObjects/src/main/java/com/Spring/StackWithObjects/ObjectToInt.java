package com.Spring.StackWithObjects;

import java.util.HashMap;

public class ObjectToInt {

    public static HashMap<String, Integer> objToInt(Object o){
        if (o instanceof Number){
            int id = ((Number) o).intValue();
            return new HashMap<>(){{put("success", 1);put("value", id);}};
        }
        else if (o instanceof String){
            System.out.println(("yes"));
            System.out.println(o);
            try{
                int id = Integer.parseInt(((String)o));
                System.out.println("yes2");
                return new HashMap<>(){{put("success", 1);put("value", id);}};
            }
            catch(Exception e){
                return new HashMap<>(){{put("success", 0);}};
            }
        }
        else{
            return new HashMap<>(){{put("success", 0);}};
        }
    }
}
