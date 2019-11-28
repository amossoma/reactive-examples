package org.amossoma.reactiveexamples;

import reactor.core.publisher.Mono;

public class Example1 {

    public static void main(String[] args) {
        // should write "Result: Abc"
        System.out.println(
                "Result: " +
                        Mono
                                .just("Abc")
                                .block());
    }

}
