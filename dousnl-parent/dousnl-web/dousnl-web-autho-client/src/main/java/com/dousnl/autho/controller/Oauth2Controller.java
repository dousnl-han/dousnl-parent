package com.dousnl.autho.controller;

import com.dousnl.autho.domain.User;
import com.dousnl.autho.service.ClientUserDetails;
import com.dousnl.autho.service.OAuth2Token;
import com.dousnl.autho.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/26 19:00
 */
@Slf4j
@Controller
public class Oauth2Controller {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/callback")
    public ModelAndView callback(String code, String state) {

        ClientUserDetails userDetails = (ClientUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        User clientUser = userDetails.getClientUser();

        OAuth2Token token = tokenService.getToken(code);
        System.out.println(">>>>>>9000 token：" + token);
        clientUser.setAccessToken(token.getAccessToken());

        Calendar tokenValidity = Calendar.getInstance();
        long validIn = System.currentTimeMillis() + Long.parseLong(token.getExpiresIn());
        tokenValidity.setTime(new Date(validIn));
        clientUser.setAccessTokenValidity(tokenValidity);

        //users.save(clientUser);

        return new ModelAndView("redirect:/mainpage");
    }

    @GetMapping("/mainpage")
    @ResponseBody
    public ModelAndView mainPage() {
        ClientUserDetails userDetails = (ClientUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User user = userDetails.getClientUser();
        if (user.getAccessToken() == null) {
            String authEndpoint = tokenService.getAuthorizationEndpoint();
            System.out.println(">>>>>>>授权站点authEndpoint:" + authEndpoint);
            return new ModelAndView("redirect:" + authEndpoint);
        }
        ModelAndView mv = new ModelAndView("mainpage");
        mv.addObject("user", user);

        tryToGetUserInfo(mv, user.getAccessToken());

        return mv;
    }

    private void tryToGetUserInfo(ModelAndView mv, String token) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + token);
        String endpoint = "http://localhost:8080/api/userinfo";

        try {
            RequestEntity<Object> request = new RequestEntity<>(
                    headers, HttpMethod.GET, URI.create(endpoint));

            ResponseEntity<User> userInfo = restTemplate.exchange(request, User.class);

            if (userInfo.getStatusCode().is2xxSuccessful()) {
                mv.addObject("userInfo", userInfo.getBody());
            } else {
                throw new RuntimeException("it was not possible to retrieve user profile");
            }
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("it was not possible to retrieve user profile");
        }
    }
}
