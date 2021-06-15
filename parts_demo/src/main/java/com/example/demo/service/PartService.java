package com.example.demo.service;

import com.example.demo.entity.Part;
import java.util.List;

public interface PartService {
    List<Part> findAll();
    Part findById(int employeeId);
    void saveOrUpdate(Part thePart);
    void deleteById(int partId);
}
