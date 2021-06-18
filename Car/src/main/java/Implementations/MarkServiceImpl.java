package Implementations;

import entities.Mark;
import repository.MarkRepository;
import interfaces.MarkService;

import java.util.List;

public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;

    public MarkServiceImpl(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<Mark> getAllMarks(){
       return markRepository.findAll();
    }

    public Mark getMarkById(Integer id){
        return markRepository.findOne(id);
    }

    public void saveMark(final Mark mark){
        markRepository.save(mark);
    }
}
