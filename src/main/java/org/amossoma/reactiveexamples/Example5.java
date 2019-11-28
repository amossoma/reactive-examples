package org.amossoma.reactiveexamples;

import reactor.core.publisher.Mono;

public class Example5 {

    public static void main(String[] args) {
        // Should throw an error
        Mono
                .just("Abc")
                .flatMap(result -> Mono.error(new RuntimeException("Test runtime exception")))
                // it's possible to use functional version
//                .flatMap(result -> Mono.error(() -> new RuntimeException("Test runtime exception")))
                .doOnNext(System.out::println)
                .subscribe();
    }

}
