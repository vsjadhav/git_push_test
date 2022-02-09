package com.Spring.StackWithObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class StackServiceImpl implements StackService{

    @Autowired
    private StackDao dao;

    @Override
    public Object create(HashMap<String, Object> h) {
        Object id_obj = h.get("stackID");
        Object size_obj = h.get("size");
        Object type_obj = h.get("type");
        var id = ObjectToInt.objToInt(id_obj);
        var size = ObjectToInt.objToInt(size_obj);
        var type = TypeCheck.check(type_obj);
        if ((id.get("success") == 1) && size.get("success") == 1
                && type.get("success").contentEquals("1")){
            if(size.get("value")<=0){
                return "\"create\" operation failed\n" +
                        "Size must be greater than 0";
            }
            else {
                var temp = CreateStackUtil.create(id.get("value"),
                                size.get("value"),type.get("value"));
                System.out.println(temp.getClass());
                System.out.println(temp.getClass().getSimpleName());
                dao.save(temp);
//                HashMap<String, Object> stackById = GetStackById.get(dao, id.get("value"));
//                Stack s = (Stack) stackById.get("value");
//                return  s;
//                System.out.println((s));
//                System.out.println(s.getStackID());

                return temp;
            }
        }
        else if(id.get("success")==0){
            return "\"create\" operation failed\n" +
                    "stackID must be a number, preferably Integer\n" +
                    "(for numbers other than integer, only integer part of given number will be considered )";
        }
        else{
            return "\"create\" operation failed\n" +
                    "size must be a number, preferably Integer\n" +
                    "(for numbers other than integer, only integer part of given number will be considered )";
        }
    }

    @Override
    public List<Stack> getStack() {
        return dao.findAll();
    }



    public boolean isFull(Stack s){
        if (s.getTopIndex() == s.getSize()-1){
            return true;
        }
        else { return false;}
    }

    public boolean isEmpty(Stack s){
        if (s.getTopIndex() == -1){
            return true;
        }
        else { return false;}
    }

    @Override
    public Object push(HashMap<String, Object> temp) {
        System.out.println(temp);
        Object id_obj = temp.get("stackID");
        var id = ObjectToInt.objToInt(id_obj);
        if (id.get("success") == 1) {
            HashMap<String, Object> stackById = GetStackById.get(dao, id.get("value"));
            if ((Integer) stackById.get("success") ==1){
                Stack s = (Stack) stackById.get("value");
                System.out.println(s.getStackID());
                System.out.println(isFull(s));
                if (this.isFull(s)) {
                    System.out.println("stack is full");
                    return "\"push\" operation failed\n" +
                            "Stack is full";
                } else {
                    s.push(temp.get("value"));
                    System.out.println(Arrays.toString(s.getStack()));
                    System.out.println("value successfully pushed in stack");
                    dao.save(s);
                    System.out.println("done");
                    //            Stack s = dao.getById(temp.get("stackID"));
                    return dao.findById(id.get("value")).get();
                }
            }
            else{
                return "\"POST(push on Stack)\" operation failed\n" +
                        "Stack with given \"stackID\" is not present in database";
            }
        }
        else{
            return "\"push\" operation failed\n" +
                    "stackID must be a number, preferably Integer\n" +
                    "(for numbers other than integer, only integer part of given number will be considered )";
        }
    }

    @Override
    public ResponseEntity<Object> fromStackID(Object id_obj) {
//        Stack s = dao.getById(id);
        var id = ObjectToInt.objToInt(id_obj);
        if (id.get("success") == 1) {
            HashMap<String, Object> stackById = GetStackById.get(dao, id.get("value"));
            if ((Integer) stackById.get("success") ==1) {
                Stack s = (Stack)stackById.get("value");
                return ResponseEntity.ok().body(s);
            }
            else{
                String msg = "\"GET\" operation failed\n" +
                        "Stack with given \"stackID\" is not present in database";
                return ResponseEntity.badRequest().body(msg);
            }
        }
        else{
            var msg = "\"get\" operation failed\n" +
                    "stackID must be a number, preferably Integer\n" +
                    "(for numbers other than integer, only integer part of given number will be considered )";
            return ResponseEntity.badRequest().body(msg);
        }
    }

    @Override
    public Object pop(Object id_obj) {
        System.out.println("start pop impl");
        var id = ObjectToInt.objToInt(id_obj);
        if (id.get("success") == 1) {
            System.out.println(GetStackById.get(dao, id.get("value")));
            HashMap<String, Object> stackById = GetStackById.get(dao, id.get("value"));
            if ((Integer) stackById.get("success") ==1) {
                Stack s = (Stack)stackById.get("value");
                if (isEmpty(s)) {
                    System.out.println("stack is empty");
                    return "Stack is empty\nNothing to \"pop\"";
                } else {
                    Object popped = s.pop();
                    dao.save(s);
                    return popped;
                }
            }
            else{
                return "\"POP\" operation failed\n" +
                        "Stack with given \"stackID\" is not present in database";
            }
        }
        else{
            return "\"POST(pop on Stack)\" operation failed\n" +
                    "stackID must be a number, preferably Integer\n" +
                    "(for numbers other than integer, only integer part of given number will be considered )";
        }
    }

    @Override
    public Object peek(Object id_obj) {
        var id = ObjectToInt.objToInt(id_obj);
        if (id.get("success") == 1) {
            HashMap<String, Object> stackById = GetStackById.get(dao, id.get("value"));
            if ((Integer) stackById.get("success") ==1) {
                Stack s = (Stack) stackById.get("value");

                if (isEmpty(s)) {
                    System.out.println("stack is empty");
                    return "Stack is empty\nNothing to \"peek\"";
                } else {
                    return s.getStack()[s.getTopIndex()];
                }
            }
            else{
                return "\"GET(peek in Stack)\" operation failed\n" +
                        "Stack with given \"stackID\" is not present in database";
                }
        }
        else{
            return "\"get\" operation failed\n" +
                    "stackID must be a number, preferably Integer\n" +
                    "(for numbers other than integer, only integer part of given number will be considered )";
        }
    }


}
