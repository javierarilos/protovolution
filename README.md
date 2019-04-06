# protovolution
protovolution

## depencencies and related projects
1. download protoc-jar: [protoc-jar Github](https://github.com/os72/protoc-jar)

## generating the file_descriptors
```bash
java -jar out/protoc-jar-3.7.0.1.jar --descriptor_set_out samples/person.v1.desc --proto_path samples person.v1.proto
java -jar out/protoc-jar-3.7.0.1.jar --descriptor_set_out samples/person.v2.desc --proto_path samples person.v2.proto
```

## references and related reading

* https://deliveroo.engineering/2019/02/05/improving-stream-data-quality-with-protobuf-schema-validation.html
* https://codeburst.io/using-dynamic-messages-in-protocol-buffers-in-scala-9fda4f0efcb3
* https://developers.google.com/protocol-buffers/docs/techniques#self-description
