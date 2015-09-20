package mvc.controller.utils ;

import java.utils.ArrayList ;

public class ReconRegex {

    private static void sizedMelt(ArrayList<String> result,int position,int size){
        int cpt = 0 ;
        while(cpt < size && this.melt(result,position)) 
            cpt++;
    }

    private static boolean melt(ArrayList<String> result,int position){
        if( position+1 > result.size()-1 ) return false;
        result.set(position,result.get(position)+result.get(position+1));
        result.remove(position+1);
        return true;
    }

    private static boolean eat(ArrayList<String> result,int position,int size){
        if( postion > result.size()-2 ) return false ;
        if( result.get(position).matches("^"+result.get(position+1)+"$") ){
            if( result.get(position).matches("\\("+result.get(position+1)+"\\)\\+") == false )
                result.set(position,"("+result.get(position)+")+") ;
            result.remove(position+1);
            return true ;
        }else if( result.get(position).matches("\\("+result.get(position+1)+"\\)\\+") ){
            result.remove( position+1 );
            return true ;
        }
        return false;
    }

    private static int eatMore(ArrayList<String> result, int position, int size){
        if( position > result.size()-1 ) return 0 ;
        this.sizedMelt(result,position+1,size) ;

        int cpt = 0 ;
        while( eat(result,position,size) ){
            cpt++ ;
            this.sizedMelt(result,position+1,size) ;
        }

        return cpt ; 
    }

    private static String reduce(ArrayList<String> result){
        int size = 0, position = 0 ;
        while(result.size()>1){
            position = 0 ;
            this.sizedMelt(result,position,size);
            while(position < result.size() ){
                this.eatMore(result,position,size) ;
                position++ ;
            }
            size++;
        }
        return result.get(0);
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

    private static void simpleReduce(ArrayList<String> result){
        int pos1 = result.size()-1 ;
        int pos2 = result.size() - 2 ;

        if( result.get(pos1).matches( "^"+result.get(pos2)+"$" ) ){
            result.set( pos1, result.get(pos1)+"+" ) ;
            result.remove( pos2 ) ;
        }else if( result.get(pos1).matches( "^\\("+result.get(pos2)+"\\)\\+$") )
            result.remove( pos2 ) ; 
    }

    public static String reconRegex(String filename){
        ArrayList<String> result = this.simpleRecon(filename);
        this.reduce(result); 
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

}
