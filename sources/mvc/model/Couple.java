package mvc.model ;

public class Couple{

    private String get, replace ;

    public Couple(String get, String replace){
        this.get = get ;
        this.replace = replace ;
    }

    public String getGet(){
        return this.get ;
    }

    public String getReplace(){
        return this.replace ;
    }

    public void setGet(String get){
        this.get = get ;
    }

    public void setReplace(String replace){
        this.replace = replace ;
    }

    public String apply(String filename){
        return filename.replaceAll(this.get, this.replace) ;
    }
    
}
