package com.fit.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.Entity.UserEntity;
import com.fit.Repo.UserRepo;

import jakarta.transaction.Transactional;

@Service

public class UserService {

	@Autowired
	UserRepo ur;
	
	public UserEntity save(UserEntity reglist) {
		// TODO Auto-generated method stub
		return ur.save(reglist);
	}

	public List<UserEntity> getuser() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}
@Transactional
	public Optional<UserEntity> getUserById(int id) {
		// TODO Auto-generated method stub
		 return ur.findById(id);
		 
	}

	public UserEntity updateUser(int id, UserEntity newUser) {
		// TODO Auto-generated method stub
		Optional<UserEntity> optionalUser = ur.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
			existingUser.setUsername(newUser.getUsername());
            existingUser.setAge(newUser.getAge());
            existingUser.setGender(newUser.getGender());
            existingUser.setContact(newUser.getContact());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setDiabetes(newUser.getDiabetes());
            existingUser.setBp(newUser.getBp());
            existingUser.setDiseases(newUser.getDiseases());
            return ur.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
            
        }
	}

}
