package com.muzix.Repository;

import com.muzix.Domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {



    @Query("{'trackRating':{$gt:4}}")
    List<Track> findAllTrackRating();

    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    List<Track> findAllTrackFromTrackArtist(String trackArtist);


}



