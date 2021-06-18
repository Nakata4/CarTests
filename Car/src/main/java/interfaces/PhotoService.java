package interfaces;

import entities.Photo;

public interface PhotoService {

    void savePhoto(Photo photo);

    void deletePhoto(Photo photo);
}
