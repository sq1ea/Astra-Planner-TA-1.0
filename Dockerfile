FROM openjdk:11
ADD /build/libs/Java-Astra-TA.jar Java-Astra-TA.jar
ENTRYPOINT ["java", "-jar", "Java-Astra-TA.jar"]