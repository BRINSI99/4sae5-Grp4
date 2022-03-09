package tn.esprit.spring.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.UserRole;



@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(UserRole name);
}
