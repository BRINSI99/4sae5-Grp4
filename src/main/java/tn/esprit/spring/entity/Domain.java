package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import tn.esprit.spring.entity.Company;
import tn.esprit.spring.entity.Invitation;
import tn.esprit.spring.entity.State;
import tn.esprit.spring.repository.InvitationRepository;
import tn.esprit.spring.service.CompanyServiceImpl;
import tn.esprit.spring.service.ICompanyService;

@RestController
public class CompanyController {

    @Autowired
    ICompanyService icompanyservice ;


    @PostMapping("/add-company")
    public void addCompany(@ModelAttribute Company c) {
        System.out.println(c.getName());


        icompanyservice.addCompany(c);

    }



    @GetMapping("/Display-Company")
    @ResponseBody
    public List<Company> Display()
    {
        List<Company> List = icompanyservice.ShowAllUniOff();
        return List;
    }



    @GetMapping("/Display-State")
    @ResponseBody
    public int CountState()
    {

        return icompanyservice.getAttemptedCountState();
    }


    @DeleteMapping("/Remove-Company/{ID}")
    @ResponseBody
    public int Remove(@PathVariable("ID") int ID)
    {
        icompanyservice.DeleteCompany(ID);
        return ID;
    }


    @PutMapping("/Update-Company/{ID}")

    public Company Update(@ModelAttribute Company c,@PathVariable("ID") int ID)
    {
        icompanyservice.ModifyCompany(c,ID);
        return c;
    }

    @PostMapping("/add-invitation/{idc}/{ide}")
    public Invitation addInvitation(@PathVariable ("idc") int idc,@PathVariable ("ide") int ide , @RequestBody Invitation i) throws WriterException, IOException {


        return icompanyservice.addInvitation(idc, ide, i);

    }

    @GetMapping("/Display-Invitation")
    @ResponseBody
    public List<Invitation> DisplayInvitation()
    {
        List<Invitation> List = icompanyservice.ShowInvitation();
        return List;
    }


    @DeleteMapping("/Remove-Invitation/{ID}")
    @ResponseBody
    public int RemoveInvitation(@PathVariable("ID") int ID)
    {
        icompanyservice.DeleteInvitation(ID);
        return ID;
    }

    @PutMapping("/Update-Invitation/{ID}") /* state*/

    public Invitation Update(@ModelAttribute Invitation i,@PathVariable("ID") int ID)
    {

        icompanyservice.ModifyInvitation(i, ID);

        return i;
    }


    @PutMapping("/Update-State/{state}/{ID}")  /* state*/

    public State Update(@PathVariable("s")  State s,@PathVariable("ID") int ID)
    {

        icompanyservice.UpdateState(s, ID);

        return s;
    }



}
