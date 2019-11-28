package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

public class Example11 {

    public static void main(String[] args) {
        // Should write "Abc, Def"
        Flux
                .merge(
                        Flux
                                .create(fluxSink -> new Thread(() -> {
                                    try {
                                        Thread.sleep(2_000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    fluxSink.next("Abc");
                                    fluxSink.complete();
                                }).start()),
                        Flux
                                .create(fluxSink -> {
                                    fluxSink.next("Def");
                                    fluxSink.complete();
                                })
                )
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
