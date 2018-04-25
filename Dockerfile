FROM java:8-jre-alpine

ENV PORT 8081

ADD target/JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-jar-with-dependencies.jar /JrebelBrains.jar
CMD java -jar /JrebelBrains.jar -p $PORT

