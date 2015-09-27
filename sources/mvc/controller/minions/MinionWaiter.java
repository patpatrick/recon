package mvc.controller.minions;

import java.lang.Runnable;
import java.util.ArrayList;

public class MinionWaiter implements Runnable {

    private ArrayList<Runnable> waiting;

    public void MinionWaiter(){
        this.waiting = new ArrayList<Thread>();
        this.run() ;
    }

    public ArrayList<Runnable> getWainting(){
        return this.waiting;
    }

    public void addMinion(Runnable minion){
        synchronized(this.waiting){
            this.waiting.add(minion);
        }
    }

    @Override
    public void run(){
        while( true ){
            this.waiting.wait();
            synchronized( this.waiting ){
                while( this.waiting.size() > 0 )
                    this.waiting.remove(0).join();
            }
        } 
    }

} 
