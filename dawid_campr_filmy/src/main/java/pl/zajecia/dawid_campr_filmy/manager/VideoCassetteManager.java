package pl.zajecia.dawid_campr_filmy.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zajecia.dawid_campr_filmy.dao.VideoCassetteRepo;
import pl.zajecia.dawid_campr_filmy.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {
    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo){
        this.videoCassetteRepo=videoCassetteRepo;
    }
    public Optional<VideoCassette> findAllById(Long id){
        return videoCassetteRepo.findById(id);
    }
    public Iterable<VideoCassette> findAll(){
        return videoCassetteRepo.findAll();
    }
    public VideoCassette save(VideoCassette videoCassette){
        return videoCassetteRepo.save(videoCassette);
    }
    public void delete(Long id){
        videoCassetteRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new VideoCassette(1L, "Tytuł1", LocalDate.of(1999, 1, 1)));
        save(new VideoCassette(2L, "Tytuł2", LocalDate.of(1998, 2, 3)));
    }
}