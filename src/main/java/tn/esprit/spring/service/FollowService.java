package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.FollowRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.entity.Follow;
import tn.esprit.spring.entity.User;

@Service
public class FollowService implements IFollowService  {
    @Autowired
    UserRepository er;
    @Autowired
    FollowRepository fr;

    @Override
    public Follow addFollow(Long idUser1, Long idUser2) {
        User user1=er.findById(idUser1).orElse(new User());
        User user2=er.findById(idUser2).orElse(new User());
        Follow follow=fr.findByIdUser1User2(user1, user2).orElse(new Follow());

        if(follow.getIdFollow()==null){
            follow=new Follow();
            follow.setUser1(user1);
            follow.setUser2(user2);
            follow.setDateFollow(new Date());
            follow.setEtat(0);
            return fr.save(follow);
        }
        else{
            fr.delete(follow);
        }
        return follow;
    }

    @Override
    public void acceptFollow(Long idFollow) {

        Follow follow=fr.findById(idFollow).get();
        follow.setEtat(1);
        fr.save(follow);

    }

    @Override
    public List<String> myFrinds(Long idUser1, int etat) {
        List<Follow> follows=fr.myFrinds(er.findById(idUser1).get(), etat);
        List<String> frinds = new ArrayList<String>();
        for(Follow f:follows){
            if(f.getUser1().getIdUser()==idUser1)
                frinds.add(f.getUser2().getFirstName()+" "+f.getUser2().getLastName()+"  "+f.getDateFollow());
            else
                frinds.add(f.getUser1().getFirstName()+" "+f.getUser1().getLastName()+" "+f.getDateFollow());
        }
        return frinds;
    }

    @Override
    public List<String> myInvitations(Long idUser2, int etat) {
        List<Follow> follows=fr.myInvitations(er.findById(idUser2).get(), etat);
        List<String> frinds = new ArrayList<String>();
        for(Follow f:follows){
            frinds.add(f.getUser1().getFirstName()+" "+f.getUser1().getLastName()+"  "+f.getDateFollow());
        }
        return frinds;
    }
}
