FROM java:8

VOLUME /tmp

ADD uhms-oauth-server-0.0.1.SNAPSHOT.jar uhms-oauth-server.jar

RUN bash -c 'touch uhms-oauth-server.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/uhms-oauth-server.jar"]