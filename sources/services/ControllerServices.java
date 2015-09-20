package services ;

import java.io.FileNotFoundException;
import java.lang.NullPointerException;

public interface ControllerServices{

    //Method that allow the user to parse a folder put in parameter.
    public void searchTagRecon(String path) throws NullPointerException, FileNotFoundException ;

}
