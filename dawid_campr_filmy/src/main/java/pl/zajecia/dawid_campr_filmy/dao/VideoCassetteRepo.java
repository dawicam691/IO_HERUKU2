package pl.zajecia.dawid_campr_filmy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zajecia.dawid_campr_filmy.dao.entity.VideoCassette;

@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette,Long> {

}
