package com.greenwooddev.Loren.Ipsum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index(@RequestParam(required = false) Integer howmany,
                        @RequestParam(required = false) String modetype,
                        ModelMap modelMap) {
        if (howmany != null) {
            modelMap.put("result", new LoremIpsumGenerator(howmany, modetype).generate());
            modelMap.put("howmany", howmany);
            modelMap.put("modetype", modetype);
        }
        return "index";
    }
}




