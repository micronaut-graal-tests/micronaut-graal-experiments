FROM oracle/graalvm-ce:19.0.0 as graalvm
COPY . /home/app/kaftest
WORKDIR /home/app/kaftest
RUN gu install native-image
RUN native-image --no-server -cp build/libs/kaftest-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/kaftest .
ENTRYPOINT ["./kaftest"]
