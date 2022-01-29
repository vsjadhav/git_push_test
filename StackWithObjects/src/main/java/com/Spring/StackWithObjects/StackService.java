package com.Spring.StackWithObjects;



import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

public interface StackService {


    Object create(HashMap<String, Object> s);

    List<Stack> getStack();

    Object push(HashMap<String, Object> t);

    ResponseEntity<Object> fromStackID(Object id);

    Object pop(Object stackID);

    Object peek(Object stackID);
}
