package fresh.graal;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
    	System.out.println("go");
        Micronaut.run(Application.class);
    }
}