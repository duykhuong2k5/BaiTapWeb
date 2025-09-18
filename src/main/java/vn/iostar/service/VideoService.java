package vn.iostar.service;

import vn.iostar.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    List<Video> findAll();
    Optional<Video> findById(Integer id);
    Video save(Video video);
    void deleteById(Integer id);
    List<Video> findByTitleContaining(String keyword);
}
