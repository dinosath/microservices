package com.crazyfly;

import com.crazyfly.resources.ApicurioEventsHandler;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class MyReactiveMessagingApplicationTest {

    @Inject
    ApicurioEventsHandler apicurioEventsHandler;

    @Test
    void test() {
    }
}
