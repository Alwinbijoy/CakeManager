FROM openjdk:17
LABEL maintainer="cakemanger.net"
ADD target/cakemanager-1.0.0.jar cakemanager.jar
ENTRYPOINT ["java", "-jar", "cakemanager.jar"]