package mvc.controller.minions ;

import java.io.File ;
import java.lang.Thread ;
import java.util.HashMap;
import java.util.ArrayList ;

import mvc.controller.utils.ReconRegex ;
import mvc.model.FileToTreat;
import mvc.model.Routine ;
import mvc.model.Model ;

public class MinionTagger extends Thread {

    private File toTreat ;
    private Model model ;
    private HashMap<String,ArrayList<FileToTreat>> listToTreat ;

    public MinionTagger(File toTreat, Model model, ArrayList<FileToTreat> lisToTreat){
        this.listToTreat = listToTreat ;
        this.toTreat = toTreat ;
        this.model = model ;
        this.start() ;
    }

    @Override
    public void run(){
        String regex = ReconRegex.reconRegex(this.toTreat.getName());
        Routine routine = null ;
        synchronized( this.model ){
            routine = this.model.getRoutine(regex);
        }
        FileToTreat ftt = new FileToTreat( this.toTreat.getName().replaceAll(".*\\.(.*)$","$1"), this.toTreat ) ;
        if( routine == null ){
             ArrayList<FileToTreat> list;
            synchronized( this.listToTreat ){
                list = this.listToTreat.get(regex) ;
                if( list == null ){
                    list = new ArrayList<FileToTreat>();
                    this.listToTreat.put(regex,list);
                }
            }/*else {*/
            /*}*/
            synchronized( list ){
                list.add( ftt );
            }
        }

    }

}
