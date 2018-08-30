package bases;

public class FrameCounter {
    int count ;
    int limit;
    public boolean expried ;

    public FrameCounter(int limit) {
        this.limit = limit;
        this.expried = false;
        this.count = 0;
    }

    public void run(){
        count++;
        if(count>=limit) {
            expried = true;
        } else {
            count++;
        }
    }
    public void reset() {
        count = 0;
        expried = false;

    }
}
