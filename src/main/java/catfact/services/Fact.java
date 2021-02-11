package catfact.services;

import javax.xml.crypto.Data;
import java.util.Date;

public class Fact {
    private String fact;
    private Date createdAt;
    private Date updatedAt;

    public Fact(String fact, Date createdAt, Date updatedAt){
        this.fact = fact;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString(){
        return fact + "";
    }
}
