import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


          //  //JSON ==>POJO
        ObjectMapper objectMapper=new ObjectMapper();
        Student student=objectMapper.readValue(new File("src/main/resources/sample.json"),Student.class);
        System.out.println(student);

        //POJO ==>JSON
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        mapper.writeValue(new File("src/main/resources/output.json"),student);
    }
}
