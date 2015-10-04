package mvc.controller.minions;

import java.lang.Thread;
import java.util.ArrayList;

public class MinionWaiter extends Thread {

    private ArrayList<Thread> waiting;

    public void MinionWaiter(){
        this.waiting = new ArrayList<Thread>();
        this.run() ;
    }

    public ArrayList<Thread> getWaiting(){
        return this.waiting;
    }

    public void addMinion(Thread minion){
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
