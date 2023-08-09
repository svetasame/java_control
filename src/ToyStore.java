import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {
   private PriorityQueue<Toy> toyQueue;
   private Random random;

   public ToyStore(){
       toyQueue = new PriorityQueue<>((t1,t2) -> t2.getFrequency() - t1.getFrequency());
       random = new Random();
   }

   public void addToy(int id, String name, int frequency) {
       Toy toy = new Toy(id,name,frequency);
//       System.out.println("ID: " + toy.getId() + ", частота: " + toy.getFrequency() + ", игрушка: " + toy.getName());
       toyQueue.add(toy);
   }

   public String getRandomToyId() {
       int randomNumber = random.nextInt(10) + 1;
       int totalWeight = 0;
       for (Toy toy : toyQueue) {
           totalWeight += toy.getFrequency();
           if (randomNumber <= totalWeight) {
//               return "ID: " + toy.getId() + ", вес: " + toy.getFrequency() + ", игрушка: " + toy.getName();
               return String.valueOf(toy.getId());
           }
       }
       return " ";
   }

}
