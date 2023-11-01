package musictrack.mc1.Services;

import musictrack.mc1.Domain.Track;

import java.util.List;
import java.util.Optional;

public interface ITrackService {


    public Track saveTracks(Track track);
    public boolean deleteTrack(int trackId);
    List<Track> fetchAllTracks();
    Optional<Track> fetchTrackById(int trackId);
    public Track updateTrackData(Track track);
    List<Track> findByTrackName(String trackName);

}
