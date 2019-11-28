package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

public class Example17 {

    public static void main(String[] args) {
        // Should write [[], [0], [0, 1], [0, 1, 2], [0, 1, 2, 3]]
        Flux
                .range(0, 5)
                .flatMap(total -> Flux.range(0, total).collectList())
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
