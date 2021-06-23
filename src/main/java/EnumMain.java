import com.generatedclass.enumtry.EnumTry;

public class EnumMain {
    public static void main(String[] args) {
        EnumTry.EnumMessage.Builder builder = EnumTry.EnumMessage.newBuilder();

        builder.setName("Name");
        //set mood has 2 options that either takes mood as a parameter or
        //an int value. taking int value option is dangerous as we don't
        //know what integer represents what option

        builder.setMood(EnumTry.Mood.INSPIRED);

        EnumTry.EnumMessage message = builder.build();
        System.out.println(message);
    }
}
