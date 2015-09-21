package mvc.model ;

import java.util.ArrayList;

public class Routine{

    private String tag ;
    private ArrayList<Couple> couples ;


    public Routine(String tag){
        this.tag = tag ;
        this.couples = couples ;
    }

    public String getTag(){
        return this.tag;
    }

    public void addCouple(Couple couple){
        this.couples.add(couple);
    }

    public String apply(String filename){
        StringBuilder sb = new StringBuilder(filename);
        for(Couple c : this.couples)
            sb.replace(0,sb.length(),c.apply(sb.toString()));
        return sb.toString();
    }

}
