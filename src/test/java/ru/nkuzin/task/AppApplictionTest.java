package ru.nkuzin.task;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import ru.nkuzin.task.integration.AbstractIT;

public class AppApplictionTest extends AbstractIT {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextShouldNotBeNull(){
        assertThat(applicationContext).isNotNull();
    }
}
