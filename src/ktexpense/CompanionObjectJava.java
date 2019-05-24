package ktexpense;

public class CompanionObjectJava {
    private static final String man = "我是最帅的,不接受反驳！";
    public static final CompanionObjectJava.Companion Companion = new CompanionObjectJava.Companion();

    public final String getGoodMan() {
        return Companion.access$getVersion$p(Companion);
    }

    public static String access$getVersion$cp() {
        return man;
    }

    public static final class Companion {
        private static String access$getVersion$p(Companion companion) {
            return companion.getGoodMan();
        }

        private String getGoodMan() {
            return CompanionObjectJava.access$getVersion$cp();
        }
    }
}
