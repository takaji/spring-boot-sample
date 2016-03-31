package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.entity.Sample;

/**
 * Created by takahashi on 2016/03/10.
 */
@Repository
public interface SampleRepository extends JpaRepository<Sample, Integer> {

}
