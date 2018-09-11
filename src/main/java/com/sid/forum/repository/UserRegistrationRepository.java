package com.sid.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.forum.model.UserRegistration;

//7. Create Repo for all the Model Class
@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long>{


}
