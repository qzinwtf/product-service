package ru.nkuzin.task.integration;

import static org.mockito.Mockito.validateMockitoUsage;


import org.junit.After;

public abstract class AbstractTest {

    @After
    public void validateMockito() {
        validateMockitoUsage();
    }
}
