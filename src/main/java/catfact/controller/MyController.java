package catfact.controller;

import catfact.services.CatFact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate() throws IOException {
        CatFact catFact = new CatFact();
        return catFact.getTenSortByDate() + "";
    }

    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam char character, int amount) throws IOException {
        CatFact catFact = new CatFact();
        return catFact.contains(character,amount) + "";
    }
}
