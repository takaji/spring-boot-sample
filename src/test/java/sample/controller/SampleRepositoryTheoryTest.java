package sample.controller;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.entity.Sample;
import sample.repository.SampleRepository;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SpringでTheoriesランナーを使うテスト
 */
@RunWith(Theories.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SampleRepositoryTheoryTest {
    @Autowired
    private SampleRepository sampleRepository;

    @DataPoints
    public static int[] ids = {1,2,3};

    @Before
    public void setUp() throws Exception {
        // テストクラスに対してDIが実行される
        new TestContextManager(this.getClass()).prepareTestInstance(this);
    }

    @Theory
    public void testSample(int id) throws Exception {
        val sample = new Sample(id, "taro");
        sampleRepository.save(sample);
        Sample result = sampleRepository.findOne(id);
        assertThat(result.id, is(id));
        assertThat(result.name, equalTo("taro"));
    }
}
