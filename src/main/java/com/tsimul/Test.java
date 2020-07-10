package com.tsimul;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.tsimul.base.Metadata;

import java.time.*;
import java.util.Collections;
import java.util.List;

public class Test {

    static void date() {
        Instant now = Instant.now();
        System.out.println("Instant " + Instant.now());
        System.out.println("OffsetDateTime " + OffsetDateTime.now());
        System.out.println("ZonedDateTime " + ZonedDateTime.now());
        System.out.println("LocalDateTime " + LocalDateTime.now());
        LocalDateTime date = LocalDateTime.ofInstant(now, ZoneId.of("America/Los_Angeles"));
        System.out.println(date);
    }

    static void listReference() {

        Metadata metadata = new Metadata("testName", "testVersion", "testDescription");
        List<Metadata> test = Lists.newArrayList();
        List<Metadata> test2 = Lists.newArrayList();
        test.add(metadata);
        test2.add(metadata);
        System.out.println(test2);;
        metadata.setName("alpha");

        System.out.println(test2);;

        /*
        List<Metadata> metadataList = ImmutableList.copyOf(test);
        System.out.println(metadataList);
        metadata.setName("alpha");
        System.out.println(metadataList);*/

    }

    public static void main(String[] args) {
        /*Registry r = new Registry();
        r.get("").subscribe(aDouble -> {
            System.out.println(aDouble);
        });*/
    }
}
