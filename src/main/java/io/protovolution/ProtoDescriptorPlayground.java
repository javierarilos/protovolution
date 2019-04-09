package io.protovolution;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ProtoDescriptorPlayground {

    public static void main(String[] args) throws IOException, DescriptorValidationException {
        String personV1Path = "samples/person.v1.desc";
        String personV2Path = "samples/person.v2.desc";
        byte[] personV1Bytes = Files.readAllBytes(new File(personV1Path).toPath());
        byte[] personV2Bytes = Files.readAllBytes(new File(personV2Path).toPath());
        FileDescriptorSet personV1FileDescriptorSet = FileDescriptorSet.parseFrom(personV1Bytes);
        FileDescriptorSet personV2FileDescriptorSet = FileDescriptorSet.parseFrom(personV2Bytes);

        FieldDescriptorProto field3PersonV1 = personV1FileDescriptorSet.getFile(0)
                .getMessageType(0).getField(2);
        FieldDescriptorProto field3PersonV2 = personV2FileDescriptorSet.getFile(0)
                .getMessageType(0).getField(2);



        System.out.println(field3PersonV1);
        System.out.println(field3PersonV2);
    }

}