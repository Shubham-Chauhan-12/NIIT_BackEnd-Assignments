package com.muzix.ServiceTest;

import com.muzix.Domain.Artist;
import com.muzix.Domain.Track;
import com.muzix.Exception.TrackAlreadyExistsException;
import com.muzix.Exception.TrackDidNotFoundException;
import com.muzix.Repository.TrackRepository;
import com.muzix.Services.TrackService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrackServiceTest {

    @Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private TrackService trackService;

    private Track track;
    private Artist artist;

    @BeforeEach
    public void setUp(){
        artist = new Artist(547,"HoneySingh");
        track = new Track(106,"Brown Rang",10,artist);

    }

    @AfterEach
    public void tearDown(){
        track = null;
        artist = null;
    }

    @Test
    public void saveTrackAndReturnTrack() throws TrackAlreadyExistsException {
        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(null));
        when(trackRepository.save(any())).thenReturn(track);
        assertEquals(track,trackService.saveTrackDetails(track));
        verify(trackRepository,times(1)).save(any());
        verify(trackRepository,times(1)).findById(any());
    }

    @Test
    public void saveTrackAndReturnException() throws TrackAlreadyExistsException{
        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(track));
        assertThrows(TrackAlreadyExistsException.class,()->trackService.saveTrackDetails(track));
        verify(trackRepository,times(0)).save(any());
    }

    @Test
    public void fetchAllTracksAndCheck() throws TrackDidNotFoundException{

        List<Track> fetchList = new ArrayList<>();
        artist = new Artist(547,"HoneySingh");
        track = new Track(106,"Brown Rang",10,artist);
        fetchList.add(track);

        when(trackRepository.findAll()).thenReturn(fetchList);
        assertEquals(1,trackService.fetchAllTrackDetails().size());
        verify(trackRepository,times(2)).findAll();
    }


    @Test
    public void fetchAllTrackByTrackArtist() throws TrackDidNotFoundException {

        List<Track> fetchList = new ArrayList<>();
        artist = new Artist(547,"HoneySingh");
        track = new Track(106,"Brown Rang",10,artist);
        fetchList.add(track);

        when(trackRepository.findAllTrackFromTrackArtist(track.getTrackArtist().getArtistName())).thenReturn(fetchList);
        assertEquals(1,trackService.findAllTrackFromTrackArtist(track.getTrackArtist().getArtistName()).size());
        verify(trackRepository,times(2)).findAllTrackFromTrackArtist(any());
    }

    @Test
    public void fetchAllTrackByTrackRating() throws TrackDidNotFoundException {
        List<Track> fetchList = new ArrayList<>();
        artist = new Artist(547,"HoneySingh");
        track = new Track(106,"Brown Rang",10,artist);
        fetchList.add(track);

        when(trackRepository.findAllTrackRating()).thenReturn(fetchList);
        assertEquals(1,trackService.findAllTrackRating().size());
        verify(trackRepository,times(2)).findAllTrackRating();
    }


    @Test
    public void deleteByIdCheck() throws TrackDidNotFoundException, TrackAlreadyExistsException {

        /*when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.of(track));
        when(trackRepository.deleteById(track.getTrackId())).thenReturn()*/
       /* artist = new Artist(547,"HoneySingh");
        track = new Track(106,"Brown Rang",10,artist);
        trackService.saveTrackDetails(track);
        trackService.deleteTrackDetails(106);
        verify(trackRepository,times(1)).deleteById(106);*/
    }

}
