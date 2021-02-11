package catfact.services;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class CatFact {
    private String text;
    private Date createdAt;
    private Date updatedAt;

    URL catURL;
    BufferedReader inputFromCatUrl;

    ArrayList<Fact> factList = new ArrayList();

    public CatFact() {
        try {
            catURL = new URL("http://cat-fact.herokuapp.com/facts/random");
            inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String getSingle(){
        CatFact singleCatFact = new Gson().fromJson(inputFromCatUrl,CatFact.class);
        makePretty(singleCatFact);
        return text;
    }

    public ArrayList<Fact> getTen(){
        for(int i = 0; i < 10; i++){
            CatFact singleCatFact = new Gson().fromJson(inputFromCatUrl,CatFact.class);
            makePretty(singleCatFact);
            factList.add(new Fact(text));
        }
        return factList;
    }

    public void makePretty(CatFact catFact){
        text = catFact.text;
        createdAt = catFact.createdAt;
        updatedAt = catFact.updatedAt;
    }

    @Override
    public String toString() {
        return "CatFact {" +
                "text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
