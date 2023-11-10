package com.muzix.Services;

import com.muzix.Domain.Track;
import com.muzix.Exception.TrackAlreadyExistsException;
import com.muzix.Exception.TrackDidNotFoundException;
import com.muzix.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackService implements ITrackService{

    private TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrackDetails(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.findById(track.getTrackId()).isPresent()){
            throw new TrackAlreadyExistsException();
        }
        return trackRepository.save(track);
    }

    @Override
    public boolean deleteTrackDetails(int trackId) throws TrackDidNotFoundException {
        if (trackRepository.findById(trackId).isEmpty()){
            throw new TrackDidNotFoundException();
        }
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> fetchAllTrackDetails() throws TrackDidNotFoundException {
        if (trackRepository.findAll().isEmpty()){
            throw new TrackDidNotFoundException();
        }
        return trackRepository.findAll();
    }

    @Override
    public List<Track> findAllTrackFromTrackArtist(String trackArtist) throws TrackDidNotFoundException {
        if (trackRepository.findAllTrackFromTrackArtist(trackArtist).isEmpty()){
            throw new TrackDidNotFoundException();
        }

        return trackRepository.findAllTrackFromTrackArtist(trackArtist);
    }

    @Override
    public List<Track> findAllTrackRating() throws TrackDidNotFoundException {

        if (trackRepository.findAllTrackRating().isEmpty()){
            throw new TrackDidNotFoundException();
        }
        return trackRepository.findAllTrackRating();
    }

}
