package mvc.controller.utils ;

import java.utils.ArrayList ;

public class ReconRegex{

    public static String reconRegex(String fileName){
        ArrayList<String> resultBuffer = this.simpleRecon(filename) ;
        this.simplify(result) ;
        return this.toString(result) ;
    }

    private void simplify(ArrayList<String> subResult){
    }

    private void String getRegex(String regex){
        
    }

    private static ArrayList<String> simpleRecon(String filename){
        ArrayList<String> result = new ArrayList<String>() ;
        String[] buffer = filename.split("") ;

        for( String c : buffer )
            result.add( this.getRegex(buffer) ) ;

        return result ;
    }

}
