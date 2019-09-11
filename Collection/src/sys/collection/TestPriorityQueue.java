package sys.collection;

import java.util.Collections;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args){
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("Beijing");
        priorityQueue.offer("Nanjing");
        priorityQueue.offer("Shanghai");
        priorityQueue.offer("Hangzhou");
        priorityQueue.offer("Kunming");

        System.out.println(priorityQueue);

        while (priorityQueue.size()>0){
            System.out.print(priorityQueue.remove()+" ");
        }
        System.out.println();

        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue1.offer("Beijing");
        priorityQueue1.offer("Nanjing");
        priorityQueue1.offer("Shanghai");
        priorityQueue1.offer("Hangzhou");
        priorityQueue1.offer("Kunming");

        while (priorityQueue1.size()>0){
            System.out.print(priorityQueue1.remove()+" ");
        }
    }
}
