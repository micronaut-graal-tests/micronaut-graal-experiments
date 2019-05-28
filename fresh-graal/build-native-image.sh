./gradlew assemble

REFLECT_JSON="build/classes/java/main/META-INF/reflect.json"
if [ -d "build/classes/kotlin" ]; then
  REFLECT_JSON="build/classes/kotlin/main/META-INF/reflect.json"
fi
native-image --no-server \
             --allow-incomplete-classpath -cp build/libs/fresh-graal-0.1-all.jar \
             -H:ReflectionConfigurationFiles="$REFLECT_JSON" \
             -H:EnableURLProtocols=http \
             -H:IncludeResources="logback.xml|application.yml" \
             -H:Name=fresh-graal \
             -H:Class=fresh.graal.Application \
             -H:+ReportUnsupportedElementsAtRuntime \
             -H:+AllowVMInspection \
             --rerun-class-initialization-at-runtime='sun.security.jca.JCAUtil$CachedSecureRandomHolder,javax.net.ssl.SSLContext' \
             --delay-class-initialization-to-runtime=io.micronaut.reactive.reactor.ReactorInstrumentation,io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom,com.sun.jndi.dns.DnsClient
