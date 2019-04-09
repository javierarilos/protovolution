package io.protovolution;

import static org.junit.Assert.*;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.Before;
import org.junit.Test;

public class MessageWalkerTest {

    private DescriptorProto messageType;

    @Before
    public void setUp() throws IOException {
        /*
        message Person {
            string name = 1;
            uint32 id = 2;
            reserved 3;
            string telephone_number = 4;
            repeated Person friends = 5;
        }
        */
        String personV2Path = "samples/person.v2.desc";
        byte[] personV2Bytes = Files.readAllBytes(new File(personV2Path).toPath());
        FileDescriptorSet personV2FileDescriptorSet = FileDescriptorSet.parseFrom(personV2Bytes);
        messageType = personV2FileDescriptorSet.getFile(0).getMessageType(0);
    }

    @Test
    public void givenPersonDescriptor_whenGetPosition1_thenReturnRightField() {
        // given
        DescriptorProto personDescriptor = messageType;
        MessageWalker messageWalker = new MessageWalker(personDescriptor);

        // when
        FieldDescriptorProto resultField = messageWalker.getPosition(1);

        // then
        assertEquals(
                "name",
                resultField.getName()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenPersonDescriptor_whenGetPosition99_thenException() {
        // given
        DescriptorProto personDescriptor = messageType;
        MessageWalker messageWalker = new MessageWalker(personDescriptor);

        // when
        FieldDescriptorProto resultField = messageWalker.getPosition(99);

        // then - IllegalArgumentException
    }

}