package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Example12 {

    public static void main(String[] args) {
        var counter = new AtomicInteger(0);

        // Should write "Abc, Def"
        Flux
                .generate(fluxSink -> {
                    if (counter.get() == 0) {
                        fluxSink.next("Abc");
                    }
                    if (counter.get() == 1) {
                        fluxSink.next("Def");
                    }
                    if (counter.get() == 1) {
                        fluxSink.complete();
                    }
                    counter.incrementAndGet();
                })
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();

        // Should write [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        var counter2 = new AtomicInteger(0);
        Flux
                .generate(fluxSink -> fluxSink.next(counter2.getAndIncrement()))
                .takeWhile(index -> (int)index < 10)
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
