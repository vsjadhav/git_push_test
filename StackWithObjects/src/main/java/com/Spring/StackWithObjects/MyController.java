package com.Spring.StackWithObjects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private StackService stack;
//	private CourseServiceImpl CS = new CourseServiceImpl();

    @GetMapping("/home")
    public String home() {
        return "this is home page";
    }

    @PostMapping("/stack/create")
    public Object create(@RequestBody HashMap<String, Object> s) {
        return stack.create(s);
    }

    @GetMapping("/stack")
    public List<Stack> getStack(){
        return stack.getStack();
    }

    @GetMapping("/stack/{stackID}")
    public ResponseEntity<Object> fromID(@PathVariable Object stackID) {
        System.out.println(stackID);
        return stack.fromStackID(stackID);
    }

    @PostMapping("/stack/push")
    public Object post(@RequestBody HashMap<String, Object> temp) {
        return stack.push(temp);
    }

    @PostMapping("/stack/pop/{stackID}")
    public Object post(@PathVariable Object stackID) {
        return stack.pop(stackID);
    }

    @GetMapping("stack/peek/{stackID}")
    public Object peek(@PathVariable Object stackID) {
        return stack.peek(stackID);
    }


//    @PutMapping("/courses")
//    public Stack put(@RequestBody Stack c) {
//        return CS.putCourse(c);
//    }
//
//    @DeleteMapping("/courses/{courseID}")
//    @ResponseBody
//    public Stack delete(@PathVariable String courseID) {
//        return CS.delete(Long.parseLong(courseID));
//    }







}


