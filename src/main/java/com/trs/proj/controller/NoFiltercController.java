package com.trs.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nofilter")
public class NoFiltercController {
	@RequestMapping("/nofilter")
    public String nofilter(){
        return "static/nofilter";
    }
}
