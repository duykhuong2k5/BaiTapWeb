package vn.iostar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iostar.entity.Video;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Integer> {
    List<Video> findByTitleContaining(String keyword);
}
