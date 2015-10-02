package utils;

import java.util.ArrayList;

public class ReconRegex{

    /*
     * Method that generate the most minimum regular expresssion of the String put in parameter.
     */
    public static String recon(String filename){
        ArrayList<String> simple = this.simpleRecon(filename);
        return this.reduce( simple ).get(0) ; 
    }

    /*
     * Mehtod that reduce the size of the regular expresion that matches the filename.
     */
    private static ArrayList<String> reduce(ArrayList<String> toRecon){
        int size = 0, pos = 0;

        while( toRecon.size() > 1 ){

            while(pos < toRecon.size()){

                this.melt(toRecon,size,pos);
                this.melt(toRecon,size,pos+1);

                while( this.fusion(toRecon,pos) )
                    this.melt(toRecon,size,pos+1);

                pos++;
            }

            pos = 0;
            size++; 
        }
    }

    /*
     * Method that fusion the regex at position start to that one at position start+1 if they are the same. 
     */
    private static boolean fusion(ArrayList<String> toRecon, int start){
        boolean result = false ;
        while( start < toRecon.size()-1 && this.isEquals(toRecon.get(start),toRecon.get(start+1)) )
            result = true ; 
        return result;
    }

    /*
     *
     */
    private static int isEquals(String source, String compare){
        if( source.equals(compare) )
            if( source.matches("\\(.*\\)\\+") ) return 1 ;
            else return 2;
        else if( source.equals("("+compare+")+") ) return 1;
        return 0;
    }

    /*
     * Method that melt size character(s) from the start.  
     */
    private static void melt(ArrayList<Strin> toRecon, int size, int start){
        int cpt = 0 ;
        while( cpt < size && this.melting(toRecon,start) )
            cpt++ ;
    }

    /*
     * Method that meelt the character from the position start to the character in position start + 1.
     */
    private static boolean melting(ArrayList<String> toRecon, int start){
        if(  toRecon.size() <= start ) return false ;
        toRecon.set(start, toRecon.get(start)+toRecon.get(start+1));
        return true ; 
    }

    /*
     * Method thar return a char's list that is the naive matching regular expression of the filename.
     */
    private static ArrayList<String> simpleRecon(String filename){
        String[] buffer = filename.split("");
        ArrayList<String> result = new ArrayList<String>();
        for(String c : buffer){
            String r = this.getLetterRegex(c);
            if( result.size > 0 && result.get( result.size() - 1 ).equals(r) && result.get( result.size()-1 ).matches(r+"+$") == false )  
                result.set( result.size()-1, r+"+" );
        }
        return result;
    }

    /*
     * Method that return the regular expresion  that match a character encoding in String put in parmeter.
     */
    private static String getLetterRegex(String c){
        if( c.matches("[a-aA-Z]") ) return "[a-zA-Z]";
        else if( c.matches("\\d") ) return "\\d";
        else if( c.matches("(\\^|\\|\\$|\\(|\\)|\\[|\\]|\\.|\\*|\\?)|\\+") ) return "\\"+c;
        return c;
    }

}
