package com.Spring.StackWithObjects;

public class CreateStackUtil {
    public static Object create(int id, int size, String type){
        if(type.contentEquals("integer")){
            return new Stack<Integer>(id,size);
        }
        else if(type.contentEquals("float")){
            return new Stack<Float>(id,size);
        }
        else if(type.contentEquals("string")){
            return new Stack<String>(id,size);
        }
        else if(type.contentEquals("boolean")){
            return new Stack<Boolean>(id,size);
        }
        else{
            return new Stack<Object>(id,size);
        }
        
    }
}
