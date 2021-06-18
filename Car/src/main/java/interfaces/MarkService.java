package interfaces;

import entities.Mark;

import java.util.List;

public interface MarkService {

    List<Mark> getAllMarks();

    Mark getMarkById(Integer id);

    void saveMark(final Mark mark);
}
