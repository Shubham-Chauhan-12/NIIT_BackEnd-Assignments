FROM openjdk
WORKDIR usr/lib

ADD ./target/RabbitMQConsumer-0.0.1-SNAPSHOT.jar /usr/lib/RabbitMQConsumer-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","RabbitMQConsumer-0.0.1-SNAPSHOT.jar"]