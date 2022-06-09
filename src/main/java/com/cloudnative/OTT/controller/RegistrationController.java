package com.cloudnative.OTT.controller;

import com.cloudnative.OTT.domain.LoginRequest;
import com.cloudnative.OTT.domain.RegistrationRequest;
import com.cloudnative.OTT.domain.RegistrationResponse;
import com.cloudnative.OTT.jpa.entity.MovieDetails;
import com.cloudnative.OTT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RegistrationController {

  @Autowired
  UserService userService;



  @ResponseBody
  @RequestMapping(value = "/register", method = RequestMethod.POST,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) throws IOException {
    ResponseEntity<RegistrationResponse> responseEntity = null;
    RegistrationResponse registrationResponse = userService.registerUser(registrationRequest);
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin","*");
    headers.add("Access-Control-Allow-Methods","GET, POST");
    headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

    responseEntity = new ResponseEntity<>(registrationResponse, headers, HttpStatus.OK);
    return responseEntity;
  }


  @ResponseBody
  @RequestMapping(value = "/signIn", method = RequestMethod.POST,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest) throws IOException {
    ResponseEntity<RegistrationResponse> responseEntity = null;
    RegistrationResponse registrationResponse = userService.loginUser(loginRequest);
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin","*");
    headers.add("Access-Control-Allow-Methods","GET, POST");
    headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

    responseEntity = new ResponseEntity<>(registrationResponse, headers, HttpStatus.OK);
    return responseEntity;
  }

  @ResponseBody
  @RequestMapping(value = "/signOut", method = RequestMethod.POST,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<?> signOut(@RequestBody LoginRequest loginRequest) throws IOException {
    ResponseEntity<RegistrationResponse> responseEntity = null;
    RegistrationResponse registrationResponse = userService.loginUser(loginRequest);
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin","*");
    headers.add("Access-Control-Allow-Methods","GET, POST");
    headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

    responseEntity = new ResponseEntity<>(registrationResponse, headers, HttpStatus.OK);
    return responseEntity;
  }

}
