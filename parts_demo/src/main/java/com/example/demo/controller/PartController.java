package com.example.demo.controller;

import com.example.demo.entity.Part;
import com.example.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"} )
@RestController
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(@Qualifier("partServiceIMPL")PartService partService )
    {   this.partService=partService;
    }

    //http://localhost:8080/retrieveAllPart
    @GetMapping("/retrieveAllPart")
    public List<Part> findAll() {
        return partService.findAll();
    }

    //http://localhost:8080/addPart
    @PostMapping("/addPart")
    public Part addPart(@RequestBody Part thePart) {
        thePart.setId(0);
        partService.saveOrUpdate(thePart);
        return thePart;
    }

    //http://localhost:8080/updatePart
    @PutMapping("/updatePart")
    public Part updatePart(@RequestBody Part updatePart) {
        partService.saveOrUpdate(updatePart);
        return updatePart;
    }

    //http://localhost:8080/findPart/1 v
    @GetMapping("/findPart/{Id}")
    public Part findEmployee(@PathVariable int Id)
    {
        return  partService.findById(Id);
    }


    //http://localhost:8080/deletePart/1
    @DeleteMapping("/deletePart/{Id}")
    public String deletePart(@PathVariable int Id) {
        partService.deleteById(Id);
        return "Deleted Part id : " + Id;
    }


}
