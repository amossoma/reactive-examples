package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

public class Example10 {

    public static void main(String[] args) {
        // Should write "Abc, Def"
        Flux
                .concat(
                        Flux
                                .create(fluxSink -> {
                                    try {
                                        Thread.sleep(2_000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    fluxSink.next("Abc");
                                    fluxSink.complete();
                                }),
                        Flux
                                .create(fluxSink -> {
                                    fluxSink.next("Def");
                                    fluxSink.complete();
                                })
                ).collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
