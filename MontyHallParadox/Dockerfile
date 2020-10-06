FROM maven:3.6.3-openjdk-8-slim

RUN useradd montyhall 

WORKDIR /home/montyhall

RUN mvn archetype:generate -DgroupId=com.mycompany.app \
-DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart \
-DarchetypeVersion=1.4 -DinteractiveMode=false

WORKDIR /home/montyhall/my-app

COPY ./src/Main.java ./src/main/java/com/mycompany/app/Main.java

COPY ./src/MontyHall.java ./src/main/java/com/mycompany/app/MontyHall.java

COPY ./src/TestMontyHall.java ./src/test/java/com/mycompany/app/TestMontyHall.java

COPY ./pom.xml ./pom.xml

RUN mvn package

USER montyhall

WORKDIR /home/montyhall/my-app/target/classes

CMD ["java", "Main"]