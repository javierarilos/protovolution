package io.protovolution;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;

public class MessageWalker {
    DescriptorProto message;

    public MessageWalker(DescriptorProto message) {
        this.message = message;
    }

    public FieldDescriptorProto getPosition(int number) {
        for(FieldDescriptorProto field : message.getFieldList()) {
            if(field.getNumber() == number) {
                return field;
            }
        }
        throw new IllegalArgumentException(String.format("field nr=%d not found in message=%s", number, message.getName()));
    }
}
