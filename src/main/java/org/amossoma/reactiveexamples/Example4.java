package org.amossoma.reactiveexamples;

import reactor.core.publisher.Mono;

public class Example4 {

    public static void main(String[] args) {
        // Should write "Result: Abc".
        Mono
                .just("Abc")
                .flatMap(result -> Mono.just("Result: " + result))
                .doOnNext(System.out::println)
                .subscribe();
    }

}
