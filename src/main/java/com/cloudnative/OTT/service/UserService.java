package com.cloudnative.OTT.service;

import com.cloudnative.OTT.domain.LoginRequest;
import com.cloudnative.OTT.domain.RegistrationRequest;
import com.cloudnative.OTT.domain.RegistrationResponse;
import com.cloudnative.OTT.jpa.entity.User;
import com.cloudnative.OTT.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Service;

@Service
public class UserService /*implements UserDetailsService*/ {

  @Autowired
  UserRepository userRepository;

 /* @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;*/

  public RegistrationResponse registerUser(RegistrationRequest registrationRequest){
     RegistrationResponse registrationResponse = new RegistrationResponse();
    User userDetails = new User();
    userDetails.setName(registrationRequest.getName());
    userDetails.setPassword(/*bCryptPasswordEncoder.encode(*/registrationRequest.getPassword());
    userDetails.setEmail(registrationRequest.getEmail());
    User userDtl = userRepository.findByEmail(registrationRequest.getEmail());
    if(userDtl!=null) {
      registrationResponse.setMessage("User is already registered");
      registrationResponse.setUsername(userDtl.getName());
    }else {
      User userDetails1 = userRepository.saveAndFlush(userDetails);
      registrationResponse.setMessage("User registered successfully");
      registrationResponse.setUsername(userDetails1.getName());
    }
       return registrationResponse;
     }



  public RegistrationResponse loginUser(LoginRequest loginRequest){
    RegistrationResponse registrationResponse = new RegistrationResponse();
    User userDtl = userRepository.findByEmail(loginRequest.getEmail());
    if(userDtl!=null) {
      registrationResponse.setMessage("User is successfully logged in");
      registrationResponse.setUsername(userDtl.getName());
    }else {
      registrationResponse.setMessage("User is not registered. Please register first");
      registrationResponse.setUsername(loginRequest.getEmail());
    }
    return registrationResponse;
  }

  /*@Override
  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User userDetails = userRepository.findByEmail(username);
    if(userDetails==null){
      throw new UsernameNotFoundException("User can not be found");
    }
    return new CurrentUserDetail(userDetails);
  }*/
}
