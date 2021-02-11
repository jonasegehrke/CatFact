package catfact.services;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;


public class CatFact {
    //Fields for data
    private String text;
    private Date createdAt;
    private Date updatedAt;

    //Fields for Gson
    URL catURL;
    BufferedReader inputFromCatUrl;

    public CatFact() {  //Constructor, sets the URL
        try {
            catURL = new URL("http://cat-fact.herokuapp.com/facts/random");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getSingle() throws IOException {  //Get a single fact
        inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFact singleCatFact = new Gson().fromJson(inputFromCatUrl,CatFact.class);

        addToFields(singleCatFact);
        return text;
    }

    public ArrayList<Fact> getTen() throws IOException {    //Get 10 facts
        ArrayList<Fact> factList = new ArrayList<Fact>();

        for(int i = 0; i < 10; i++){
           inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
           CatFact singleCatFact = new Gson().fromJson(inputFromCatUrl,CatFact.class);
           addToFields(singleCatFact);
           factList.add(new Fact(text,createdAt,updatedAt));
        }
        return factList;
    }

    public ArrayList<Fact> getTenSortByDate() throws IOException {  //Get 10 facts and sort by date
        ArrayList<Fact> factList = new ArrayList<Fact>();

        for(int i = 0; i < 10; i++){
            inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFact singleCatFact = new Gson().fromJson(inputFromCatUrl,CatFact.class);
            addToFields(singleCatFact);
            factList.add(new Fact(text,createdAt,updatedAt));
        }
        factList.sort(Comparator.comparing(Fact::getCreatedAt));
        return factList;
    }

    public String contains(char character,int amount) throws IOException {  //returns fact if permissions are held
        inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFact singleCatFact = new Gson().fromJson(inputFromCatUrl,CatFact.class);

        addToFields(singleCatFact);

        int count = text.length() - text.replaceAll(character + "","").length();
        if(count >= amount){
            return text;
        }
        return "Sorry no luck";
    }

    public void addToFields(CatFact catFact){   //Add data to fields
        text = catFact.text;
        createdAt = catFact.createdAt;
        updatedAt = catFact.updatedAt;
    }

    @Override
    public String toString() {  //toString not currently in use
        return "CatFact {" +
                "text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
