package com.muzix.ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muzix.Controller.TrackController;
import com.muzix.Domain.Artist;
import com.muzix.Domain.Track;
import com.muzix.Services.TrackService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TrackService trackService;

    @InjectMocks
    private TrackController trackController;

    private Track track;
    private Artist artist;


    @BeforeEach
    public void setUp(){

        artist = new Artist(150,"Jack-knight");
        track = new Track(12,"Shadows x Jack night",8,artist);

        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();

    }

    @AfterEach
    public void tearDown(){

        artist = null;
        track = null;

    }

    @Test
    public void giveTrackDetailsToSaveAndReturningSuccessCode() throws Exception {
        when(trackService.saveTrackDetails(any())).thenReturn(track);
        mockMvc.perform(post("/track/v1/save-details")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(track)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

        verify(trackService,times(1)).saveTrackDetails(any());
    }

    @Test
    public void fetchAllTrackDetailsFromGetAndReturnSuccessCode() throws Exception{
        List<Track> trackList= new ArrayList<>();
        artist = new Artist(150,"Jack-knight");
        track = new Track(12,"Shadows x Jack night",8,artist);
        trackList.add(track);

        when(trackService.fetchAllTrackDetails()).thenReturn(trackList);
        mockMvc.perform(MockMvcRequestBuilders.get("/track/v1/fetch-trackdetails")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$",hasSize(1))).andExpect(jsonPath("$[0].trackArtist.artistName", Matchers.is("Jack-knight")));

    }

    @Test
    public void deleteByIdAndReturnSuccessCode() throws Exception {

        when(trackService.deleteTrackDetails(anyInt())).thenReturn(true);
               mockMvc.perform(MockMvcRequestBuilders.delete("/track/v1/delete-details/12")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(track)))
                .andExpect(status().isAccepted())
                .andDo(MockMvcResultHandlers.print());

        verify(trackService,times(1)).deleteTrackDetails(anyInt());

    }


}
