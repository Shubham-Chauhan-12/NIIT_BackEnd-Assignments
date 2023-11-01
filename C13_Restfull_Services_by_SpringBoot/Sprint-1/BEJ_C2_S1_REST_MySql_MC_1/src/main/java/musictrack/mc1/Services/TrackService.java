package musictrack.mc1.Services;

import musictrack.mc1.Domain.Track;
import musictrack.mc1.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrackService implements ITrackService{

    private TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTracks(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public boolean deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> fetchAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> fetchTrackById(int trackId) {
        return trackRepository.findById(trackId);
    }

    @Override
    public Track updateTrackData(Track track) {

        Track updatedTrack = null;
        Optional<Track> trackId1 = trackRepository.findById(track.getTrackId());
        if(trackId1.isPresent()){
            updatedTrack = trackId1.get();
            updatedTrack.setTrackName(track.getTrackName());
            updatedTrack.setTrackArtist(track.getTrackArtist());
            updatedTrack.setTrackComments(track.getTrackComments());
            updatedTrack.setTrackRating(track.getTrackRating());
            trackRepository.save(updatedTrack);

        }
        else {
            return new Track();
        }
        return updatedTrack;
    }

    @Override
    public List<Track> findByTrackName(String trackName) {
        return trackRepository.findByTrackName(trackName);
    }
}
