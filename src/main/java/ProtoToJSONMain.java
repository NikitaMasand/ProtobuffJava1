import com.generatedclass.simple.Simple;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.util.Arrays;

public class ProtoToJSONMain {
    public static void main(String[] args) {
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

        //print this as JSON format
        String jsonString = null;
        try {
            jsonString = JsonFormat.printer().print(builder);
            System.out.println(jsonString);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        //parse JSON to protobuf

        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
        try {
            JsonFormat.parser().ignoringUnknownFields().merge(jsonString, builder2);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        System.out.println(builder2);
    }
}
