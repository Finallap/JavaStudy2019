package sys.collection;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String [] args){
        Queue<String> queue = new LinkedList<>();
        queue.offer("Beijing");
        queue.offer("Nanjing");
        queue.offer("Shanghai");
        queue.offer("Hangzhou");
        queue.offer("Kunming");

        while (queue.size()>0){
            System.out.print(queue.remove()+" ");
        }
    }
}
