package com.muzix.Services;

import com.muzix.Domain.Track;
import com.muzix.Exception.TrackAlreadyExistsException;
import com.muzix.Exception.TrackDidNotFoundException;

import java.util.List;

public interface ITrackService {

    Track saveTrackDetails(Track track) throws TrackAlreadyExistsException;
    public boolean deleteTrackDetails(int trackId) throws TrackDidNotFoundException;
    List<Track> fetchAllTrackDetails() throws TrackDidNotFoundException;
    List<Track> findAllTrackFromTrackArtist(String trackArtist) throws TrackDidNotFoundException;
    List<Track> findAllTrackRating() throws TrackDidNotFoundException;

}
