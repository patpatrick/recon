package mvc.controller.minions;

import java.io.File;
import java.lang.Runnable;
import java.lang.ArrayList;

import utils.ReconRegex;

public class MinionRecon implements Runnable{

    private ArrayList<Runnable> waiting;
    private File file;

    public MinionRecon(ArrayList<Runnable> waiting, File file){
        this.wainting = waiting;
        this.file = file;
    }

    @Override
    public void run(){
        String regex = ReconRegex.recon( file.getName() );
    }

} 
