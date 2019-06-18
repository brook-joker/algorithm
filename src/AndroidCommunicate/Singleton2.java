package AndroidCommunicate;

public class Singleton2 {


    public static Singleton2 getInstance(){
        return Instance.INSTANCE;
    }


    private static class Instance{
       private static final Singleton2 INSTANCE = new Singleton2();
    }
}
