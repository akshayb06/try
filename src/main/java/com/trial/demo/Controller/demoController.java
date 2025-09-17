package com.trial.demo.Controller;



import com.trial.demo.Model.Demo;
import com.trial.demo.Repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class demoController {

    @Autowired
    DemoRepository demoRepo;

    String success = "Data Added Successfully";

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Demo student){
        demoRepo.save(student);
        return "Data Added Successfully";
    }

    @GetMapping("/fetchStudents")
    public List<Demo> fetchStudents(){
        return demoRepo.findAll();
    }

    @GetMapping("/fetchStudents/{id}")
    public Demo fetchStudents(@PathVariable Integer id){
        return demoRepo.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Demo update(@PathVariable Integer id, @RequestBody Demo student){
        Demo ob = demoRepo.findById(id).orElse(null);
        if (ob != null){
            ob.setName(student.getName());
            ob.setAge(student.getAge());
            return demoRepo.save(ob);
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/deleteStudents/{id}")
    public Demo delete(@PathVariable Integer id){
        Demo demo = demoRepo.findById(id).orElse(null);
        if (demo != null) {
            demoRepo.delete(demo);
            return demo;
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/deleteStudents")
    public String deleteAll(){
        demoRepo.deleteAll();
        return "Deleted All Documents";
    }

}
