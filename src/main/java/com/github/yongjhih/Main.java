package com.github.yongjhih;

import rx.schedulers.*;
import rx.Observable;
import rx.functions.*;
import rx.observables.*;
import rx.Subscription;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String... args) {
        Subscription sub = Observable.interval(1, TimeUnit.SECONDS).subscribe(l -> System.out.println(l));

        Observable.just(sub).delay(3, TimeUnit.SECONDS).subscribe(s -> s.unsubscribe(), e -> {}, () -> System.out.println("Ctrl-C to exit"));
        while (true);
        // or
        //Observable.just(sub).delay(3, TimeUnit.SECONDS).toBlocking().single().unsubscribe();
    }
}
