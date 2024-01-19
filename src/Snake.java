public class Snake {
    public Node head, tail;
    public int growthAmount;
    public Snake(){
        head = new Node(new Point(15,29), null);
        tail = head;
        growthAmount = 3;
    }
    public void onPickup(){
        growthAmount += 30;
    }
//return 0 if moved normally, return 1 if snake grows, return -1 if snake dies
    public int move(Point direction) {
        Node temp = new Node(new Point(direction.x + this.head.position.x, direction.y + this.head.position.y), null);
        if(temp.position.x < 0 || temp.position.x >= 30 || temp.position.y < 0 || temp.position.y >= 30){
            return -1;
        }
        head.next = temp;
        head = head.next;
        if(growthAmount > 0){
            growthAmount -= 1;
            return 1;
        }else{
            tail = tail.next;
        }
        return 0;
    }
}
