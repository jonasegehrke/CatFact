package catfact.controller;

import catfact.services.CatFact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingle() throws IOException {
        CatFact catFact = new CatFact();
        return catFact.getSingle();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTen() throws IOException {
        CatFact catFact = new CatFact();
        return catFact.getTen() + "";
    }
}
