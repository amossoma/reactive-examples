package org.amossoma.reactiveexamples;

import reactor.core.publisher.Flux;

public class Example18 {

    public static void main(String[] args) {
        // Should write {1=A, 2=B, 3=C, 4=D, 5=E}
        Flux
                .range(0, 5)
                .collectMap(index -> index + 1, "ABCDEFGHIJ"::charAt)
                .doOnNext(System.out::println)
                .subscribe();
    }

}
