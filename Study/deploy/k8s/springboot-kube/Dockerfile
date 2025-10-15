FROM openjdk:17
VOLUME /tmp
COPY target/springboot-kube.jar springboot-kube.jar
ENTRYPOINT ["java","-jar","/springboot-kube.jar"]