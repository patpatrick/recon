package utils;

import java.util.ArrayList;

public class ReconRegex{

    public static String recon(String filename){
        ArrayList<String> simple = this.simpleRecon(filename);
        this.reduce(simple); 
    }

    private ArrayList<String> reduce(ArrayList<String> toRecon){

    }

    private static ArrayList<String> simpleRecon(String filename){
        String[] buffer = filename.split("");
        ArrayList<String> result = new ArrayList<String>();
        for(String c : buffer){
            String r = this.getLetterRegex(c);
            if( result.size > 0 && result.get( result.size() - 1 ).equals(r) && result.get( result.size()-1 ).matches(r+"+$") == false )  result.set( result.size()-1, r+"+" );
        }
    }

    private static String getLetterRegex(String c){
        if( c.matches("[a-aA-Z]") ) return "[a-zA-Z]";
        else if( c.matches("\\d") ) return "\\d";
        else if( c.matches("(\\^|\\|\\$|\\(|\\)|\\[|\\]|\\.|\\*|\\?)|\\+") ) return "\\"+c;
        return c;
    }

}
