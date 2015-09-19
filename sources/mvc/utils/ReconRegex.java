package mvc.utils ;

import java.utils.ArrayList ;

public class ReconRegex {

    public static String reconRegex(String filename){
        ArrayList<String> result = this.simpleRecon(filename);
        this.simplify(result);
    }

    private static String simplify(ArrayList<String> result){
        int size = 0 ;
        int position = 0 ;

        while( result.size() > 1 ){

            this.reduce(result,position,size) ;

        }

    }

    private static boolean eat(ArrayList<String> result, int size, int position){
        this.reduce(result,position+1,size) ;
        if( result.get(position).matches( "^"+result.get(position+1)+"$" ) ){
            if( result.get(position+1).matches( "\\(.*\\)\\+" ) )
                result.remove(position+1) ;
            else{
                result.set(position, "("+result.get(position)+")+") ;
                result.remove(position+1);
            } 
        }else if( result.get(position).matches("\\("+result.get(position)+"\\)\\+") )
            result.remove(position+1) ;
    }

    private static void reduce(ArrayList<String> result, int start, int size){
        int cpt = start, max = start + size ;
        while( cpt < result.size() && cpt < max ){
            result.set(start,result.get(start)+result.get(start+1)) ;
            result.remove(start+1);
            cpt++ ;
        } 
    }

    private static ArrayList<String> simpleRecon(String filename){
        String[] buffer = filename.split("") ;
        ArrayList<String> result = new ArrayList<String>() ;
        for( String c : buffer ){
            result.add( this.reconChar( c ) ) ;
            this.simpleReduce(result) ;
        }
        return result ;
    }

    private static void simplereduce(ArrayList<String> result){
        int pos1 = result.size()-1 ;
        int pos2 = result.size() - 2 ;

        if( result.get(pos1).matches( "^"+result.get(pos2)+"$" ) ){
            result.set( pos1, result.get(pos1)+"+" ) ;
            result.remove( pos2 ) ;
        }else if( result.get(pos1).matches( "^\\("+result.get(pos2)+"\\)\\+$") )
            result.remove( pos2 ) ; 
    }

    private static String reconChar( String c ){
        if( c.matches("[a-zA-Z]") ) 
            return "[a-zA-Z]" ;
        else if( c.matches("\\d") ) 
            return "\\d";
        else if( c.matches("\\s") )
            return "\\s" ;
        else if( c.matches("(\\?|\\^|\\|\\*|\\$|\\.|\\||\\$|\\[|\\]|\\(|\\))") )
            return "\\"+c ;
        return c ;
    }

}
