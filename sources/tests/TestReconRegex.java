package tests ;

import mvc.controller.utils.ReconRegex ;

public class TestReconRegex {

    public static void main(String[] args){

        String[] reg = { "All-Star Section Eight 02 (of 06) (2015) (Digital) (Cypher 2.0-Empire).cbr", "Batman - Superman 022 (2015) (Digital-Empire).cbr", "Batman v2 042 (2015) (Webrip) (The Last Kryptonian-DCP).cbr", "Catwoman 042 (2015) (Digital-Empire).cbr", "Coffin Hill 020 (2015) (digital) (Son of Ultron-Empire).cbr", "Constantine - The Hellblazer 002 (2015) (Digital) (Mephisto-Empire).cbr" } ;

        for( String filename : reg ){
            String regex = ReconRegex.reconRegex(filename) ;
            if( filename.matches(regex) ) 
                System.out.println(filename+"\n"+regex+"\nMATCHES\n");
            else System.out.println(filename+" not matches:\n\t"+regex+"\nNOT MATCHES\n");
        }

    }

} 

