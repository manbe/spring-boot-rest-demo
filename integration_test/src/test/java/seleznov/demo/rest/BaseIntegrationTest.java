package seleznov.demo.rest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import seleznov.demo.rest.confg.TestConfig;

/**
 * Created by illcko on 13.09.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@WebIntegrationTest
@TestPropertySource(locations="classpath:test.properties")
public abstract class BaseIntegrationTest {
}
