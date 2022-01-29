package com.Spring.StackWithObjects;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;

public class GetStackById {

//    @Autowired
//    private static StackDao dao;

    public static HashMap<String, Object> get(StackDao dao,int id){
//        System.out.println(id);
        try{
//            System.out.println("GetStackById: try start");
//            Stack s = dao.getById(id);
            Stack s = dao.findById(id).get();
//            System.out.println((s));
            return new HashMap<>(){{put("success", 1);put("value", s);}};
        }
        catch (Exception e){
            return new HashMap<>(){{put("success", 0);}};
        }
    }

}
