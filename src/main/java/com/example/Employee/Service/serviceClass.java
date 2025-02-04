package com.example.Employee.Service;

import com.example.Employee.Exception.ExceptionClass;
import com.example.Employee.Model.Employee;
import com.example.Employee.Repository.repositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class serviceClass {
    @Autowired
    private repositoryClass repositoryclass;

    public boolean saveEmployee(Employee employee) {
        if (repositoryclass.existsByName(String.valueOf(employee.getName()))) {
            throw new ExceptionClass("Employee with name" + employee.getName() + "Already Exists Status code = " + HttpStatus.CONFLICT);
        } else {
            repositoryclass.save(employee);

            return true;
        }
    }

    public Employee getEmployeeByName(String name) {
        //   return (Employee) repositoryclass.findByName(name).orElseThrow(() -> new RuntimeException("Employee with name " + name + " not found."));
        //1... (one  way to do code for this )
        //     Employee isEmployee= repositoryclass.findByName(name);
        //     return isEmployee;

        // 2.....(second way)
        return repositoryclass.findByName(name);

    }

    public Employee findByName(String name) {

        return null;
    }

    public List<Employee> findAllEmployees() {
        return repositoryclass.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (repositoryclass.existsById(employee.getId())) {
            return repositoryclass.save(employee);
        } else {
            return null;
        }
    }

    public boolean deleteEmployee(long id) {
        if (repositoryclass.existsById(id)) {
            repositoryclass.deleteById(id);
            return true;
        } else {
            return false;
        }

    }


    public List<Employee> saveAllEmployees(List<Employee> employees) {
        List<Employee> savedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (!repositoryclass.existsByName(employee.getName())) {
                savedEmployees.add(repositoryclass.save(employee));
            } else {
                throw new ExceptionClass("Employee With Name" + employee.getName() + "already exists");

            }
        }
        return savedEmployees;

    }
     // To use the HashMap with the API.......................
    HashMap<String, String> useData = new HashMap<>();
    public serviceClass() {                     // to initialise the map with some data

        useData.put("contact", "go to the next window");
        useData.put("i need help", "please log in to get help");
        useData.put("create account","click on the create new account button");
    }



    public String yes(String input) {
        for (Map.Entry<String, String> val : useData.entrySet()) {
            //  if(val.getKey().equals(input));
            if (val.getKey().contains(input)) {// "equals" needs exactly same data ,so we will use "contains".
                return val.getValue();
            }

        } return "not found";
    }}

