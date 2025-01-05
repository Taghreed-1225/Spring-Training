package com.adminPanel.app.controller;


import com.adminPanel.app.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
//@Controller
public class HomeController
{

  @RequestMapping(  "/")
  public  String showHome() {
   return "homePage";
  }

 @GetMapping("/apiTest1")
 //@ResponseBody
 public String testAPi1()
 {
  return "HelloFromJSON";

 }


@GetMapping("/apiTest")
 //@ResponseBody// make return string not jsp
 public Student testAPi()
 {
 // take pojo return json by jakson
     return new Student(2,"Taghreed","Ali",true);
 }


    @GetMapping("/apiTest2")
   // @ResponseBody
    public void testAPi2(@RequestBody Student student)
    {
        // take json return pojo
        System.out.println(student);
    }


    @GetMapping("/listStudent")
   // @ResponseBody// make return string not jsp
    public List<Student> listStudent()
    {
        List<Student> studentList=new ArrayList<>();
        Collections.addAll(studentList,new Student(1,"taghreed","ali",true)
                ,new Student(2,"ahmed","ali",true));
        return studentList;
        //jackson take list convert it to json

    }

}
