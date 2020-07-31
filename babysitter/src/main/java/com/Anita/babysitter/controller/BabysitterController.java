package com.Anita.babysitter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class BabysitterController {

        @ResponseBody
        @GetMapping("calculateNightlyCharge")
        public String calculateNightlyCharge(){
            log.info("calculateNightlyCharge");
            return "You should charge $60.00";
        }
}
