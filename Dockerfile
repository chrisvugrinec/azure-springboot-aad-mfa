FROM alpine
RUN apk --update add openjdk8-jre
EXPOSE 8080
COPY target/refapp-helloworld-1.0.jar /etc
CMD ["/usr/bin/java","-jar","/etc/refapp-helloworld-1.0.jar"]
