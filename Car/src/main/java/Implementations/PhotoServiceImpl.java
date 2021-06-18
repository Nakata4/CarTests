package Implementations;

import entities.Photo;
import repository.PhotoRepository;
import interfaces.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public void savePhoto(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void deletePhoto(Photo photo) {
        photoRepository.delete(photo);
    }

}
