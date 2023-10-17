FROM openjdk:8
EXPOSE 8760
ADD target/GestionClasses-0.0.1-SNAPSHOT.jar GestionClasses-0.0.1.jar
ENTRYPOINT ["java", "-jar", "GestionClasses-0.0.1.jar"]