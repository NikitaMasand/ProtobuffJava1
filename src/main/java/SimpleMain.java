import com.generatedclass.simple.Simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        //simple fields
        builder.setId(1)
                .setIsSimple(true)
                .setName("Name of message"); //set returns a builder and thus we can chain it

        //repeated fields
        builder.addSampleList(1);
        builder.addSampleList(2)
                .addSampleList(3);

        builder.addAllSampleList(Arrays.asList(4,5,6));

        System.out.println(builder.toString());

        Simple.SimpleMessage message = builder.build();

        //write the message to a file
        try {
            FileOutputStream outputStream = new FileOutputStream("simple message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //send the message to network as bytes array
        byte[] bytes = message.toByteArray();

        //reading the message from file

        try {
            System.out.println("Reading from file...");
            FileInputStream fileInputStream = new FileInputStream("simple message.bin");
            Simple.SimpleMessage messageFromFile = Simple.SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
