package dev.abhinav.IRCTC.dao;

import dev.abhinav.IRCTC.entity.Train;
import dev.abhinav.IRCTC.entity.TrainScheduleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.util.List;

public interface TrainScheduleRepository extends JpaRepository<TrainScheduleRecord,Long> {
    @Query(value = "select new dev.abhinav.IRCTC.dao.SourceDestinationPair(s,d) from TrainScheduleRecord s, TrainScheduleRecord d where s.train.id=d.train.id and s.stopNumber < d.stopNumber and s.sourceStartDayOfWeek=d.sourceStartDayOfWeek order by s.train.id asc, s.stopNumber asc,d.stopNumber asc")
    List<SourceDestinationPair> getAllPossibleSourceDestinationCombination();

    List<TrainScheduleRecord> getAllBySourceStartDayOfWeek(DayOfWeek dayOfWeek);
}
