package mvc.utils ;

import java.utils.ArrayList ;

public class ReconRegex {

    private static String simplify(ArrayList<String> result){
        int size = 0 ;

        while( result.size() > 1 ){

            String buffer1 = null ;
            String buffer2 = null ;

                 

        }

        return result.get(0);
    }

    private static String getSplit( ArrayList<String> result, int size ){

    }

    private static ArrayList<String> simpleRecon(String filename){
        String[] buffer = filename.split("") ;
        ArrayList<String> result = new ArrayList<String>() ;
        for( String c : buffer )
           result.add( this.reconChar( c ) ) ;
        return result ;
    }

    private static String reconChar( String c ){
        if( c.matches("[a-zA-Z]") ) 
            return "[a-zA-Z]" ;
        else if( c.matches("\\d") ) 
            return "\\d";
        else if( c.matches("(\\?|\\^|\\|\\*|\\$|\\.|\\||\\$|\\[|\\]|\\(|\\))") )
            return "\\"+c ;
        return c ;
    }

}
