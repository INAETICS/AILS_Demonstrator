import static org.junit.Assert.*;

import java.io.IOException;

import org.inaetics.ails.api.common.model.User;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class UserSerializeTest {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\": \"test\", \"accuracy\": \"off\", \"uuid\": \"e76a875a-5563-47eb-b9dc-9d3e8c3b3dd6\", \"key\": \"twaalf\"}";
        
        System.out.println(((User) mapper.readValue(jsonString, User.class)).getUuid());
    }

}
