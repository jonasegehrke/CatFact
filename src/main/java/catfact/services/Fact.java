package catfact.services;

public class Fact {
    private String fact;

    public Fact(String fact){
        this.fact = fact;
    }

    public String getFact() {
        return fact;
    }

    @Override
    public String toString(){
        return fact + "\n";
    }
}
