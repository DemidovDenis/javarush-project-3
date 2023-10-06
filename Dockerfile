FROM maven:3.8-amazoncorretto-17 AS MAVE_BUILD
COPY ./ ./
RUN mvn clean package

FROM tomcat:9.0.65-jdk17-corretto
COPY --from=MAVE_BUILD /target/javarush-project-3.war /usr/local/tomcat/webapps/ROOT.war

#FROM tomcat:9.0.65
#
#EXPOSE 8080
#
#COPY ./target/javarush-project-3.war /usr/local/tomcat/webapps/ROOT.war