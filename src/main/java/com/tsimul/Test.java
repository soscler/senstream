package com.tsimul;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.tsimul.base.Metadata;

import java.time.*;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Instant " + Instant.now());
        System.out.println("OffsetDateTime " + OffsetDateTime.now());
        System.out.println("ZonedDateTime " + ZonedDateTime.now());
        System.out.println("LocalDateTime " + LocalDateTime.now());
        LocalDateTime date = LocalDateTime.ofInstant(now, ZoneId.of("America/Los_Angeles"));
        System.out.println(date);


        Metadata metadata = new Metadata("testName", "testVersion", "testDescription");
        List<Metadata> test = Lists.newArrayList();
        test.add(metadata);
        List<Metadata> metadataList = ImmutableList.copyOf(test);
        System.out.println(metadataList);
        metadata.setName("alpha");
        System.out.println(metadataList);


    }
}
