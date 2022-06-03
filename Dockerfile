FROM openjdk:11
COPY . .
EXPOSE 8080
ENTRYPOINT java -jar rxmonitoramento-grupo5.jar
CMD ["bash", "java", "-jar" "main"]
