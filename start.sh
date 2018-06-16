
#!/bin/sh
# # modify permission
# # chmod a+x start.sh

/Users/weishi/Downloads/SpringBootDemo/initial/mvnw  clean package

java -jar /Users/weishi/Downloads/SpringBootDemo/initial/target/gs-spring-boot-0.1.0.jar --server.port=8081 &

java -jar /Users/weishi/Downloads/SpringBootDemo/initial/target/gs-spring-boot-0.1.0.jar --server.port=8082 &
java -jar /Users/weishi/Downloads/SpringBootDemo/initial/target/gs-spring-boot-0.1.0.jar --server.port=8083 &

java -jar /Users/weishi/Downloads/SpringBootDemo/initial/target/gs-spring-boot-0.1.0.jar --server.port=8084 &

java -jar /Users/weishi/Downloads/SpringBootDemo/initial/target/gs-spring-boot-0.1.0.jar --server.port=8085 &


# input any key to stop all Web services



