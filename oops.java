import java.util.*;

public class oops {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
        Queen q2 = new Queen();
        q2.moves();
        Queen q3 = new Queen();
        q3.moves();
        System.out.println(q.count+" "+q2.count);
    }   
}


interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    static int count = 0;
    public void moves(){
        System.out.println("Up,Down,Right,Left,Diagonal");
        count++;
    }
    
    
    public void identity(){
        System.out.println("Is Queen");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("down,left,right,diagonal");
    }

    
    public void identity(){
        System.out.println("OverRidden");
    }
}

