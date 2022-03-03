package tn.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.spring.entities.Doc;
import tn.spring.repository.DocRepository;

@Service
public class DocStorageService {
	@Autowired
	private DocRepository Docrepo;
	public Doc saveFile(MultipartFile file)
	{
		String docname=file.getOriginalFilename();
		try{
			Doc doc=new Doc(docname,file.getContentType(),file.getBytes());
			return Docrepo.save(doc);
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		return null;
	}
	public Optional <Doc>getFile(Integer fileId)
	{
		return Docrepo.findById(fileId);
	}
	public List<Doc> getFiles(){
		
		return Docrepo.findAll();
	}

}
