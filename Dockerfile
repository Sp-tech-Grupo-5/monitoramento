FROM openjdk:19
WORKDIR /target
COPY . .
RUN ls
ENTRYPOINT java -jar rxmonitoramento-grupo5-CLI.jar
CMD ["bash","java","-jar" "Main"]