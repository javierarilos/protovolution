package io.protovolution;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ProtoDescriptorPlayground {

    public static void main(String[] args) throws IOException, DescriptorValidationException {
//        https://github.com/os72/protoc-jar
//        java -jar protoc-jar-3.7.0.1.jar -v3.7.0 -o yuyuyeah --proto_path /Users/javierarias/mywork/streaming-quote-pipeline/quote-wormhole/vendor/proto/engines/quotepipelineschema quote.proto
//        https://deliveroo.engineering/2019/02/05/improving-stream-data-quality-with-protobuf-schema-validation.html
        // https://codeburst.io/using-dynamic-messages-in-protocol-buffers-in-scala-9fda4f0efcb3
//        https://developers.google.com/protocol-buffers/docs/techniques#self-description
        String x = "/Users/javierarias/mywork/streaming-quote-pipeline/quote-wormhole/vendor/proto/engines/quotepipelineschema/quote.proto";
        String pathname = "/Users/javierarias/Downloads/yuyuyeah";
        String pathnameRes = "/Users/javierarias/Downloads/yuyuyeahres";
        byte[] bytes = Files.readAllBytes(new File(pathname).toPath());
        byte[] bytesRes = Files.readAllBytes(new File(pathnameRes).toPath());
        FileDescriptorSet fds = FileDescriptorSet.parseFrom(bytes);
        FileDescriptorSet fdsRes = FileDescriptorSet.parseFrom(bytesRes);

        FieldDescriptorProto field2 = fds.getFile(0)
                .getMessageTypeList().get(0).getFieldList().get(1);
        FieldDescriptorProto field2Res = fdsRes.getFile(0)
                .getMessageTypeList().get(0).getFieldList().get(1);



        System.out.println(field2);
    }

}