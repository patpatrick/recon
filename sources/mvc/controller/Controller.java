package mvc.controller ;

import java.io.File ;
import java.lang.Thread ;
import java.utils.ArrayList ;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;

import services.ControllerServices ;

public class Controller implements ControllerServices{

    private ArrayList<Thread> minions ;

    public Controller(){
        this.minions = new ArrayList<Thread>() ;
    }

    @Override
    public void searchTagRecon(String path)throws NullPointerException, FileNotFound Exception {
        if( path == null || path.mathes("^\\s*$") ) 
            throw new NullPointerException("[:(][searchTagRecon] The path to recon is empty![):]") ;

        File file = new File(path) ;

        if( file.exists() == false ) 
            throw new FileNotFoundException("[:(][searchTagRecon] The path to recon doesn't exists.[):]") ;

        if( file.isFile() ) 
            this.tagThis(file) ;
        else 
            this.reconThat(file) ;
    }

    private void tagThis(File file){
        this.minions.add( new MinionTagger(file) ) ;
    }

    private void reconThat(File file){
        for( File content : file.listFiles() ){
            if( content.isFile() )
                this.tagThis(file);
            else if( content.isDirectory() && content.getName().equals(".") == false && content.getName().equals("..") )
                this.reconThis(content);
        }
    }

}
