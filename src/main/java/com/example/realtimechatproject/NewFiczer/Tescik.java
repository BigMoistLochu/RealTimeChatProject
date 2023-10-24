package com.example.realtimechatproject.NewFiczer;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Arrays;
import java.util.List;

public class Tescik extends HttpServletRequestWrapper {

    private List<Cookie> listOfCookie;
    public Tescik(HttpServletRequest request) {
        super(request);
        this.listOfCookie = Arrays.stream(request.getCookies()).toList();
    }

    public List<Cookie> getAllCookie()
    {
        return listOfCookie;
    }


}
