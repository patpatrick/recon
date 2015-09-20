package mvc.controller.minions ;

import java.io.File ;
import java.lang.Thread ;

import mvc.controller.utils.ReconRegex ;

public class MinionTagger extends Thread {

    private File toTreat ;

    public MinionTagger(File toTreat){
        this.toTreat = toTreat ;
        this.start() ;
    }

    @Override
    public void run(){
        
    }

}
