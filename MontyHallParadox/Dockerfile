FROM openjdk:8-slim-stretch

COPY . /home/MontyHallParadox

WORKDIR /home/MontyHallParadox/bin

RUN javac ../src/*.java -d ./

RUN useradd montyhall 

RUN chown montyhall:montyhall *

USER montyhall

CMD ["java", "Main"]