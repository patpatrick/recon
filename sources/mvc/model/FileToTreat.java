package mvc.model ;

import java.io.File ;

public class FileToTreat{

    private File file ;
    private String extention ;

    public FileToRead(String extention, File file){
        this.file = file ;
        this.extention = extention ;
    }

    public String getExtetion(){
        return this.extention ;
    }

    public File getFile(){
        return this.file ;
    }

}
