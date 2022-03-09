package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Follow;

public interface IFollowService {
    Follow addFollow(Long idUser1,Long idUser2);
    void acceptFollow(Long idFollow);
    List<String> myFrinds(Long idUser1,int etat);
    List<String> myInvitations(Long idUser2, int etat);

}
