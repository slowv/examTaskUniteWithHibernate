package com.fintech.taskunite;

import com.fintech.taskunite.util.HibernateUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HibernateTest {
    @Test
    public void itShouldGetSessionNotNull() {
        assertThat(HibernateUtil.getSession()).isNotNull();
    }
}
