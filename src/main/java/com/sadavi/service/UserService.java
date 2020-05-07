package com.sadavi.service;

import com.sadavi.bean.User;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

@Service
public class UserService {

    RestTemplate restTemplate;

    @Autowired
    UserService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<User> getUserInfo() throws MalformedURLException {
        String url = "https://api.github.com/users/joshuadeguzman";
        Uri uri = new Uri(url);
        HttpHeaders httpHeaders = new HttpHeaders();

        ResponseEntity<User> responseEntity =
                restTemplate.getForEntity(url, User.class);

        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        }
        return null;
    }

}
