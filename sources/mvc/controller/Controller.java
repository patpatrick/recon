package mvc.controller;

import java.io.File;
import java.io.IOException;

import mvc.services.minions.MinionWaiter;
import mvc.services.minions.MinionRecon;

import services.ControllerServices;

public class Controller implements ControllerServices{

    private MinionWaiter threadWaiter;

    public Controller(){
        this.threadWaiter = new MinionWaiter();
    }

    @Override
    public void parsePath(String path) throws IOException{
        if( path == null || path.matches("^\\s*^$") || new File(path).exists() == false )
            throw new IOException("[CONTROLLER][parsePath] The path is null or empty.[):]");

        File toRecon = new File(path);

        if( toRecon.isFile() ) this.reconFile(toRecon);
        else if( toRecon.isDirecory() ) this.reconFolder(toRecon);
    }

    private void reconFile(File toRecon){
        this.threadWaiter.addMinion( new MinionRecon(this.threadWaiter,toRecon) );
    }

    private void reconFolder(File toRecon){
        for(File content : toRecon.listFile() ){
            if( content.isFile() ) this.reconFile(content);
            else if( content.isDirectory() ) this.reconFolder(content);
        }
    } 

}
