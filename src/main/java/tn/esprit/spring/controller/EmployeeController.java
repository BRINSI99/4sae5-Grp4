package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Company;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.entity.Invitation;
import tn.esprit.spring.service.EmployeeServiceImpl;
import tn.esprit.spring.service.ICompanyService;
import tn.esprit.spring.service.IEmployeeService;

@RestController
public class EmployeeController  {

    @Autowired
    IEmployeeService iemplloyeeservice ;

    @PostMapping("/add-Employee")
    public void addCompany(@ModelAttribute Employee e) {

        iemplloyeeservice.addEmployee(e);

    }

    @GetMapping("/Display-Employee")
    @ResponseBody
    public List<Employee> Display()
    {
        List<Employee> List = iemplloyeeservice.ShowAllUniOff();
        return List;
    }




    @DeleteMapping("/Remove-Employee/{ID}")
    @ResponseBody
    public int Remove(@PathVariable("ID") int ID)
    {
        iemplloyeeservice.DeleteEmployee(ID);
        return ID;
    }

    @PutMapping("/Update-Employee/{ID}")

    public Employee Update(@ModelAttribute Employee e,@PathVariable("ID") int ID)
    {
        iemplloyeeservice.ModifyEpmloyee(e, ID);
        return e;
    }

    @PutMapping("/Accept-Invitation/{IDinv}/{ide}")
    @ResponseBody
    public Invitation Accept(@PathVariable("IDinv") int IDinv,@PathVariable("ide")int ide)
    {
        return iemplloyeeservice.AcceptInvitation(IDinv, ide);
    }


    @GetMapping("/SortEmployee")
    @ResponseBody
    public ResponseEntity<List<Employee>> SortUniOff(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "IdUniversityOffer") String sortBy,
            @RequestParam(defaultValue = "ASC") String Type)
    {
        List<Employee> list = iemplloyeeservice.OrderUniOff(pageNo, pageSize, sortBy, Type);


        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }









}
