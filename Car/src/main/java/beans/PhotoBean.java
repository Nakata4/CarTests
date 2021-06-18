package beans;

import entities.Photo;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class PhotoBean {
    private UploadedFile uploadedFile;
    private List<InputStream> streams;
    private List<Photo> photos;
    private List<String> background;

    public void init() {
        streams = new ArrayList<>();
        photos = new ArrayList<>();
        background = new ArrayList<>();
        for (int i = 1; i <= 4; i++)
            background.add("img/background/background" + i + ".jpg");
    }
    public void uploadPhoto(FileUploadEvent e) throws IOException {
        this.uploadedFile = e.getFile();
        InputStream input = uploadedFile.getInputstream();
        streams.add(input);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File(s) Uploaded Successfully"));
    }
    public Boolean savePhotosToSystem() {
        if (streams.size() > 0) {
            for (InputStream input : streams) {
                Photo photo = new Photo();
                File f;
                try {
                    f = File.createTempFile("car", ".jpg", new File("E:\\CarsOnline\\src\\main\\webapp\\resources\\img\\"));
                    Files.copy(input, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    photo.setPath(f.getName());
                    photos.add(photo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            streams.clear();
            return true;
        }
        return false;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    public List<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    public List<String> getBackground() {
        return background;
    }
}
