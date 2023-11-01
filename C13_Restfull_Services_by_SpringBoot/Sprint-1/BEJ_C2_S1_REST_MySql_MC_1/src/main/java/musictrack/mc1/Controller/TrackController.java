package musictrack.mc1.Controller;


import musictrack.mc1.Domain.Track;
import musictrack.mc1.Services.TrackService;
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

    @PostMapping("/save-Track")
    public ResponseEntity<?> saveTrackFunction(@RequestBody Track trackObj){
        trackService.saveTracks(trackObj);
        return new ResponseEntity<>("Data Saved Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/fetch-Track")
    public ResponseEntity<?> fetchAllTrackFunction(){
        return new ResponseEntity<>(trackService.fetchAllTracks(),HttpStatus.FOUND);
    }

    @GetMapping("/fetch-TrackId/{trackId}")
    public ResponseEntity<?> fetchByIdFunction(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.fetchTrackById(trackId),HttpStatus.FOUND);
    }


    @GetMapping("fetch-TrackName/{trackName}")
    public ResponseEntity<?> fetchAllTrackName(@PathVariable String trackName){
        return new ResponseEntity<>(trackService.findByTrackName(trackName),HttpStatus.FOUND);
    }


    @DeleteMapping("/delete-Track/{trackId}")
    public ResponseEntity<?> deleteTrackByIdFunction(@PathVariable int trackId){
        trackService.deleteTrack(trackId);
        return new ResponseEntity<>("Data Deleted SuccessFully",HttpStatus.OK);
    }

    @PutMapping("/put-Track")
    public ResponseEntity<?> updateTrackFunction(@RequestBody Track track){
        return new ResponseEntity<>(trackService.updateTrackData(track),HttpStatus.ACCEPTED);
    }
}
