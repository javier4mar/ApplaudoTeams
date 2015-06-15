package com.applaudo.applaudoteams.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.applaudo.applaudoteams.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class TeamDetailFragment extends Fragment {

    private TextView title_team;
    private TextView history_team;
    private VideoView video_team;
    private ImageView img_team;
    private ProgressDialog pDialog;

    String videoTeam;
    String longitute ;
    String latitude ;
    String teamname;
    String imageTeam ;
    String history;
    private GoogleMap mMap;
    String stadium;

    public static final String ARG_ID_ENTRADA_SELECIONADA = "item_id";

    public static TeamDetailFragment newInstance() {
        TeamDetailFragment fragment = new TeamDetailFragment();
        return fragment;
    }

    public TeamDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        teamname = getArguments().getString("team_name");
        history = getArguments().getString("team_history");
        videoTeam =getArguments().getString("team_video");
        imageTeam = getArguments().getString("team_img");
        latitude = getArguments().getString("team_lat");
        longitute = getArguments().getString("team_log");
        longitute = getArguments().getString("team_log");

        stadium = getArguments().getString("team_sta");


        Toast.makeText(getActivity(), teamname,Toast.LENGTH_SHORT).show();


    }

    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_team_detail, container, false);

        title_team = (TextView) rootView.findViewById(R.id.TitleeditText);
        title_team.setText(teamname);

        history_team = (TextView) rootView.findViewById(R.id.HistoryeditText);
        history_team.setText(history);

        video_team = (VideoView) rootView.findViewById(R.id.TeamvideoView);



        if (!videoTeam.equals("")) {

            pDialog = new ProgressDialog(getActivity());
            pDialog.setTitle("Video Streaming ");
            pDialog.setMessage("Buffering...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();

            try {
                // Start the MediaController
                MediaController mediacontroller = new MediaController(getActivity());
                mediacontroller.setAnchorView(video_team);

                // Get the URL from String VideoURL
                Uri video = Uri.parse(videoTeam);
                video_team.setMediaController(mediacontroller);
                video_team.setVideoURI(video);

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }

            video_team.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                // Close the progress bar and play the video
                public void onPrepared(MediaPlayer mp) {
                    pDialog.dismiss();
                    video_team.start();
                }
            });
        } else {
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion >= Build.VERSION_CODES.JELLY_BEAN){
                BitmapDrawable bg=(BitmapDrawable)getResources().getDrawable(R.drawable.video_not_found);
                video_team.setBackground(bg);

            } else{

            }

        }

        img_team = (ImageView) rootView.findViewById(R.id.TeamimageView);
        Glide.with(getActivity())
                .load(imageTeam)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.no_available_img)
                .into(img_team);


        try {
            LatLng Points = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitute));

            mMap = ((SupportMapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            MarkerOptions mp = new MarkerOptions();
            mp.position(Points);
            mp.title(stadium);
                mp.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_logo));

                mMap.addMarker(mp);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Points, 15));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Points, 14));


        } catch (Exception e) {
            e.printStackTrace();
        }

        video_team.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
               Toast.makeText(getActivity(),"Team without video",Toast.LENGTH_LONG);
                return true;
            }
        });

        return rootView;
    }


}
