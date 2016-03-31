package sample.controller;

import lombok.val;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.entity.Sample;
import sample.repository.SampleRepository;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by takahashi on 2016/03/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SampleRepositoryTest {
    @Autowired
    private SampleRepository sampleRepository;

    @Test
    public void testSample() throws Exception {
        val sample = new Sample(1, "taro");
        sampleRepository.save(sample);
        List<Sample> result = sampleRepository.findAll();
        assertThat(result.size(), is(1));
        assertThat(result.get(0).id, is(1));
        assertThat(result.get(0).name, equalTo("taro"));
    }

}
