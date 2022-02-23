package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Company;
import tn.esprit.spring.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	CompanyRepository companyrepository;

	@Override
	public Company addCompany(Company c) {
		// TODO Auto-generated method stub
		System.out.println("service " + c.getName());
		return companyrepository.save(c);
	}

	@Override
    public List<Company> ShowAllUniOff() {
        List<Company> ListUniOff = companyrepository.findAll();
        return ListUniOff;
	}

	@Override
	public int DeleteCompany(int X) {
		// TODO Auto-generated method stub
		companyrepository.deleteById(X);
        return X;
	}

	@Override
	public Company ModifyCompany(Company C, int x) {
		// TODO Auto-generated method stub
		Optional<Company> opCompany = companyrepository.findById(x);
		if (opCompany.isPresent()) {
			Company c = opCompany.get();
			c.setName(C.getName());
			System.out.println(C.getName());
			System.out.println(c.getName());			
			//c.setDomains(C.getDomains());
			c.setResgistrationNumber(C.getResgistrationNumber());
			c.setCapacity(C.getCapacity());
			companyrepository.save(c);
			return c;
		}
		else {
			return null;
		}
	}
}
    

	

	


