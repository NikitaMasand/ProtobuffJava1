
import com.generatedclass.complex.Complex;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        Complex.DummyMessage one_dummy = createNewDummyMessage(1, "n1");
        Complex.ComplexMessage.Builder builder = Complex.ComplexMessage.newBuilder();

        //singular message field
        builder.setOneDummyMessage(one_dummy);

        builder.addMultipleDummyMessages(createNewDummyMessage(2, "n2"));
        builder.addMultipleDummyMessages(createNewDummyMessage(3, "n3"));

        builder.addAllMultipleDummyMessages(Arrays.asList(createNewDummyMessage(4, "n4"), createNewDummyMessage(5, "n5")));

        Complex.ComplexMessage message = builder.build();
        System.out.println(message.toString());

    }

    public static Complex.DummyMessage createNewDummyMessage(int id, String name){
        Complex.DummyMessage.Builder dummyMessageBuilder = Complex.DummyMessage.newBuilder();
        Complex.DummyMessage dummyMessage = dummyMessageBuilder
                .setName(name)
                .setId(2)
                .build();

        return dummyMessage;
    }
}
