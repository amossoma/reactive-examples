package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Example14 {

    public static void main(String[] args) {
        // Should write [0, 1, 2, 3, 4]
        Flux
                .range(0, 10)
                .filter(index -> index < 5)
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
