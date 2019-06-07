package interview;


public class SleepThread extends Thread {
    private static int currentCount = 0;

    public SleepThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
       while (currentCount<10){
           switch (currentCount%3){
               case 0:{
                   if ("A".equals(getName())) {
                       printAndIncrease();
                   }
               }
               break;
               case 1:{
                   if ("B".equals(getName())) {
                       printAndIncrease();
                   }
               }
               break;
               case 2:{
                   if ("C".equals(getName())) {
                       printAndIncrease();
                   }
               }
               break;
           }
       }
    }

    private void printAndIncrease() {
        System.out.println(getName());
        currentCount++;
    }
}
