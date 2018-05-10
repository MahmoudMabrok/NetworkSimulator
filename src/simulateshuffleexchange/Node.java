package simulateshuffleexchange;

public class Node {

    String path  = ""; 
    int current;
    Node right, left, parent;

    public Node(int n) {
        current = n; 
    }

    public void evaRight() {
        right = new Node(current);
        right.parent = this ;
        //path
        right.path = this.path + String.valueOf(current) ; 
    }

    public void evaLeft() {
       int val = Covert.exchange(current, 0);
       left = new Node (val) ; 
        
       left.parent = this ;
         //path
          left.path = this.path + String.valueOf(left.current) ; 
    }

    public void exchange() {
        evaLeft();
        evaRight();
    }

    public int shuffleValue(int current ) {
        switch (current) {
            case 0:
            case 7:
                return current;
            case 1:
            case 2:
            case 3:
                return current * 2;
            case 4:
                return 1;
            case 5:
                return 3;
            case 6:
                return 5;
            default:
                return -1;
        }
    }
    
//    public Node doShuffle(){
//        Node n = new Node(shuffleValue()) ; 
//        n.parent = this ; 
//        return n  ;
//       
//    }

    
    public void nn (){
         exchange() ;
      
        //right.right = new Node( shuffleValue(right.current) ) ;
        
        right.right = new Node( Covert.shuffle(right.current) ) ;
        right.right.path = right.path + String.valueOf(right.right.current) ; 
        right.left = null ;
        
      //  left.right = new Node( shuffleValue(left.current) ) ;
        
        int val =  Covert.shuffle(left.current) ; 
        left.right = new Node( val) ;
         left.right.path = left.path + String.valueOf(left.right.current) ; 
        left.left = null ; 
    }
    
    public void finalDest (){
    right.right.exchange(); 
    left.right.exchange(); 
    }

}
