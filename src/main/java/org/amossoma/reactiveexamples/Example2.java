package org.amossoma.reactiveexamples;

import reactor.core.publisher.Mono;

public class Example2 {

    public static void main(String[] args) {
        // Should write "Result: Abc".
        Mono
                .just("Abc")
                .doOnNext(result -> System.out.println("Result: " + result))
                .subscribe();
    }

}
