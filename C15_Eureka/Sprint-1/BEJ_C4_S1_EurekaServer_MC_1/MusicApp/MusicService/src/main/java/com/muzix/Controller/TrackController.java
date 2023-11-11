package com.muzix.Controller;


import com.muzix.Domain.Track;
import com.muzix.Exception.TrackAlreadyExistsException;
import com.muzix.Exception.TrackDidNotFoundException;
import com.muzix.Services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/track/v1")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/save-details")
    public ResponseEntity<?> saveDetails(@RequestBody Track track) throws TrackAlreadyExistsException {
        try {
            return new ResponseEntity<>(trackService.saveTrackDetails(track), HttpStatus.CREATED);
        }
        catch (TrackAlreadyExistsException e){
            throw new TrackAlreadyExistsException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/fetch-trackdetails")
    public ResponseEntity<?> fetchAllTrack() throws TrackDidNotFoundException {

        try {
            return new ResponseEntity<>(trackService.fetchAllTrackDetails(),HttpStatus.FOUND);
        }
        catch (TrackDidNotFoundException e){
            throw new TrackDidNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch-trackArtist/{artistName}")
    public ResponseEntity<?> fetchTrackArtist(@PathVariable String artistName) throws TrackDidNotFoundException {
        try {
            return new ResponseEntity<>(trackService.findAllTrackFromTrackArtist(artistName), HttpStatus.FOUND);
        }
        catch (TrackDidNotFoundException e){
            throw new TrackDidNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch-ratingabovefour")
    public ResponseEntity<?> fetchRatingAboveFour() throws TrackDidNotFoundException {
        try {
            return new ResponseEntity<>(trackService.findAllTrackRating(), HttpStatus.FOUND);
        }
        catch (TrackDidNotFoundException e){
            throw new TrackDidNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-details/{trackId}")
    public ResponseEntity<?> deleteDetailsById(int trackId) throws TrackDidNotFoundException {
        try {
            trackService.deleteTrackDetails(trackId);
            return new ResponseEntity<>("Data Deleted SuccessFully", HttpStatus.ACCEPTED);
        }
        catch (TrackDidNotFoundException e){
            throw new TrackDidNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
