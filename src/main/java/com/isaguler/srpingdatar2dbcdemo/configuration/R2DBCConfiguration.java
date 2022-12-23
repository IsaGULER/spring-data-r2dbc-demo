package com.isaguler.srpingdatar2dbcdemo.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class R2DBCConfiguration {

    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        log.info("migrating");

        r2dbcEntityTemplate.getDatabaseClient().sql("CREATE TABLE person (id INTEGER PRIMARY KEY, firstname VARCHAR(255), lastname VARCHAR(255), age INTEGER)");

        log.info("end of migrate");
    }
}
