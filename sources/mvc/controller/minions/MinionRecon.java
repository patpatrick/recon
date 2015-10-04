package mvc.controller.minions;

import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;

import utils.ReconRegex;

public class MinionRecon extends Thread{

    private ArrayList<Thread> waiting;
    private File file;

    public MinionRecon(ArrayList<Thread> waiting, File file){
        this.wainting = waiting;
        this.file = file;
    }

    @Override
    public void run(){
        String regex = ReconRegex.recon( file.getName() );
    }

} 
