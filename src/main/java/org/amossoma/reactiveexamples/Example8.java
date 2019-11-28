package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

public class Example8 {

    public static void main(String[] args) {
        // Should write "Abc, Def"
        Flux
                .just("Abc", "Def")
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();
    }

}
