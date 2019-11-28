package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example15 {

    public static void main(String[] args) {
        // Should write [0, 1, 2, 3, 4]
        Mono
                .just(5)
                .flatMapMany(total -> Flux.range(0, total))
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
