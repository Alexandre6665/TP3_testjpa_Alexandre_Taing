package com_isep.testjpa.controller;

import com_isep.testjpa.model.Emp;
import com_isep.testjpa.repository.EmpRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleController {

    private final EmpRepository empRepository;

    public SimpleController(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Emp> getEmployees() {
        return empRepository.findAll();
    }

    @PostMapping(value = "/employess")
    public Emp addEmployee(@RequestBody Emp emp) {
        return empRepository.save(emp);
    }

    @GetMapping(value = "/employees/{empno}")
    public Emp getEmployee(@PathVariable Long empno) {
        return empRepository.findById(empno).orElse(null);
    }

    @DeleteMapping(value = "/employee/{empno}")
    public void deleteEmployee(@PathVariable Long empno) {
        empRepository.deleteById(empno);
    }

    @PutMapping("/employee/{empno}")
    public Emp updateEmployee(@PathVariable Long empno, @RequestBody Emp empDetails) {
        return empRepository.findById(empno).map(emp -> {
            // Only update fields if they are provided in the request
            if (empDetails.getEname() != null) {
                emp.setEname(empDetails.getEname());
            }
            if (empDetails.getSal() != null) {
                emp.setSal(empDetails.getSal());
            }
            if (empDetails.getEfirst() != null) {
                emp.setEfirst(empDetails.getEfirst());
            }
            if (empDetails.getEmpno() != null) {
                emp.setEmpno(empDetails.getEmpno());
            }
            if (empDetails.getJob() != null) {
                emp.setJob(empDetails.getJob());
            }
            if (empDetails.getMgr() != null) {
                emp.setMgr(empDetails.getMgr());
            }
            if (empDetails.getTel() != null) {
                emp.setTel(empDetails.getTel());
            }
            if (empDetails.getMobileTel() != null) {
                emp.setMobileTel(empDetails.getMobileTel());
            }
            return empRepository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empno));
    }
}
