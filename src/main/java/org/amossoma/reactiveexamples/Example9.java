package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

public class Example9 {

    public static void main(String[] args) {
        // Should write "Abc, Def"
        Flux
                .create(fluxSink -> {
                    fluxSink.next("Abc");
                    fluxSink.next("Def");
                    fluxSink.complete();
                })
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
