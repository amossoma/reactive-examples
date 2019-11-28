package org.amossoma.reactiveexamples;

import reactor.core.publisher.Mono;

public class Example3 {

    public static void main(String[] args) {
        // Should write "Result: Abc".
        Mono
                .just("Abc")
                .map(result -> "Result: " + result)
//                .doOnNext(result -> System.out.println(result))
                .doOnNext(System.out::println)
                .subscribe();
    }

}
