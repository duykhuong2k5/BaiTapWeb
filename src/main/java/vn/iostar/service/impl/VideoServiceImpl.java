package vn.iostar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import vn.iostar.entity.Video;
import vn.iostar.repository.VideoRepository;
import vn.iostar.service.VideoService;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> findAll(){
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> findById(Integer id){
        return videoRepository.findById(id);
    }

    @Override
    public Video save(Video video){
        return videoRepository.save(video);
    }

    @Override
    public void deleteById(Integer id){
        videoRepository.deleteById(id);
    }

    @Override
    public List<Video> findByTitleContaining(String keyword){
        return videoRepository.findByTitleContaining(keyword);
    }


}
