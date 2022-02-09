package com.Spring.StackWithObjects;

public class CreateStackUtil {
    public static Stack<? extends  Object> create(int id, int size, String type){
        if(type.contentEquals("integer")){
            System.out.println("integer Stack crated");
            return new Stack<Integer>(id,size, new Integer[size]);
        }
        else if(type.contentEquals("float")){
            return new Stack<Float>(id,size, new Float[size]);
        }
        else if(type.contentEquals("string")){
            return new Stack<String>(id,size, new String[size]);
        }
        else if(type.contentEquals("boolean")){
            return new Stack<Boolean>(id,size, new Boolean[size]);
        }
        else{
            return new Stack<Object>(id,size, new Object[size]);
        }

    }
}
