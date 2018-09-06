package bases;

public class Vector2D {
    public float x,y;
    public Vector2D(float x,float y){
        this.x = x;
        this.y = y;}
    public Vector2D() {
    this(0,0);
    }

    public void print() {
        System.out.println("x =" + this.x );
        System.out.println("y =" + this.y);
    }
    public void addUp(float x,float y) {
        this.x += x;
        this.y += y;
    }
    public Vector2D add(float x, float y) {

        return new Vector2D(this.x +x,this.y +y);


    }
    public void  addUp(Vector2D other) {
        this.addUp(other.x,other.y);
    }

    Vector2D add(Vector2D other) {
        return  this.add(other.x,other.y);
    }

    void SubtrackBy(float x,float y) {
        this.x -= x;
        this.y -= y;
    }

    void SubtrackBy(Vector2D other){
        this.SubtrackBy(other.x,other.y);
    }
    public Vector2D Sub(float x, float y){
        return new Vector2D(this.x - x,this.y - y);
    }
    public Vector2D Sub(Vector2D other){
        return this.Sub(this.x-other.x, this.y-other.y);
    }
    void ScaleBy(int m) {
        this.x = m*this.x;
        this.y = m*this.y;
    }
    Vector2D Scale(float a) {
        return new Vector2D(this.x*a,this.y*a);
    }
    float length() {
        float length = (float) Math.sqrt(this.x*this.x + this.y*this.y);
        return length;
    }
    Vector2D normalize() {
        float length = this.length();
        return new Vector2D(this.x/length,this.y/length);
    }






    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(2,3);
        Vector2D v2 = new Vector2D(2,5);
        v1.SubtrackBy(1,1);
        Vector2D v3 = v1.Sub(v2);
        //v3.print();
        //v1.print();
       // v2.print();
       // v1.ScaleBy(3);
       // bases.Vector2D v4 = v1.Scale(3);
        //v4.print();
        //v1.print();
        System.out.println("v1 length : " + v1.length());
        v1.normalize();







    }
}
