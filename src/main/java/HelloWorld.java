import com.generatedclass.person.PersonOuterClass;
import com.google.protobuf.InvalidProtocolBufferException;

public class HelloWorld {
    public static void main(String[] args) {
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder().setName("Name").setAge(1).build();
        System.out.println(person.toString());
        PersonOuterClass.Person person2 = null;
        System.out.println(person.toByteString());

        try {
            person2 = PersonOuterClass.Person.parseFrom(person.toByteString());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(person2.toString());

    }
}
