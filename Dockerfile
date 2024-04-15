FROM openjdk:11
ADD /build/libs/developer-test-task-fork.jar Java-Astra-TA.jar
ENTRYPOINT ["java", "-jar", "Java-Astra-TA.jar"]