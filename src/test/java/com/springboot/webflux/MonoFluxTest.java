package com.springboot.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString=Mono.just("mono1")
        .then(Mono.error(new RuntimeException("exception occured")))
        .log();
        monoString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
    }
    @Test
    public void testFlux(){
        Flux<String> fluxString=Flux.just("spring","hibernate","security")
                .concatWithValues("cloud")
                .concatWith(Flux.error(new RuntimeException("exception occured in Flux")))
                .log();
        fluxString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
    }



}
