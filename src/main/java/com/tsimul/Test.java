package com.tsimul;

import java.time.*;

public class Test {



    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Instant " + Instant.now());
        System.out.println("OffsetDateTime " + OffsetDateTime.now());
        System.out.println("ZonedDateTime " + ZonedDateTime.now());
        System.out.println("LocalDateTime " + LocalDateTime.now());
        LocalDateTime date = LocalDateTime.ofInstant(now, ZoneId.of("America/Los_Angeles"));
        System.out.println(date);

    }
}
