package org.amossoma.reactiveexamples;

import reactor.core.publisher.Mono;

public class Example6 {

    public static void main(String[] args) {
        // Should write "Abc -> Def"
        Mono
                .zip(
                        Mono.just("Abc"),
                        Mono.just("Def")
                )
                .map(tuple -> {
                    var first = tuple.getT1();
                    var second = tuple.getT2();

                    return first + " -> " + second;
                })
                .doOnNext(System.out::println)
                .subscribe();
    }

}
