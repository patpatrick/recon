package mvc.model ;

import java.util.HashMap ;

import services.ModelServices ;

public class Model implements ModelServices {

    private Hashmap<String,Routine> routines ;

    @Override
    public Routine getRoutine(String regex){
        return this.routines.get(regex) ;
    } 

}
