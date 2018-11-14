package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30.ActivityStyle30Activity.RECEIVE_AUDIO;
import static com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30.ActivityStyle30Activity.RECEIVE_IMAGE;
import static com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30.ActivityStyle30Activity.RECEIVE_MAP;
import static com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30.ActivityStyle30Activity.RECEIVE_MESSAGE;
import static com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30.ActivityStyle30Activity.SEND_MESSAGE;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle30Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<ActivityStyle30Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private Activity activity;

    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private boolean isPlaying = false;
    private TextView txtNow;
    private SeekBar seekbar;

    public ActivityStyle30Adapter(Activity act, ArrayList<ActivityStyle30Model> data) {
        activity = act;
        context = activity.getApplicationContext();
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class SendMessageItemViewHolder extends RecyclerView.ViewHolder {
        private TextView sendMessage;
        private TextView sendTime;

        public SendMessageItemViewHolder(View itemView) {
            super(itemView);

            sendMessage = (TextView) itemView.findViewById(R.id.sendMessage);
            sendTime = (TextView) itemView.findViewById(R.id.sendTime);
        }

    }

    public class ReceiveMessageItemViewHolder extends RecyclerView.ViewHolder {
        private TextView receiveMessage;
        private TextView receiveTime;

        public ReceiveMessageItemViewHolder(View itemView) {
            super(itemView);

            receiveMessage = (TextView) itemView.findViewById(R.id.receiveMessage);
            receiveTime = (TextView) itemView.findViewById(R.id.receiveTime);
        }

    }

    public class ReceiveImageItemViewHolder extends RecyclerView.ViewHolder {
        private TextView receiveMessage;
        private TextView receiveTime;

        public ReceiveImageItemViewHolder(View itemView) {
            super(itemView);

            receiveMessage = (TextView) itemView.findViewById(R.id.receiveMessage);
            receiveTime = (TextView) itemView.findViewById(R.id.receiveTime);
        }

    }

    public class ReceiveAudioItemViewHolder extends RecyclerView.ViewHolder {
        private SeekBar seekbar;
        private TextView txtNow, txtTotal;
        private ImageView buttonAudio;

        public ReceiveAudioItemViewHolder(View itemView) {
            super(itemView);

            txtNow = (TextView) itemView.findViewById(R.id.presentTime);
            txtTotal = (TextView) itemView.findViewById(R.id.totalTime);
            seekbar = (SeekBar) itemView.findViewById(R.id.seekbar);
            buttonAudio = (ImageView) itemView.findViewById(R.id.buttonAudio);
        }

    }

    public class ReceiveMapItemViewHolder extends RecyclerView.ViewHolder implements OnMapReadyCallback {
        GoogleMap mMap;
        MapView map;

        public ReceiveMapItemViewHolder(View itemView) {
            super(itemView);
            map = (MapView) itemView.findViewById(R.id.mapPreview);

            if (map != null) {
                map.onCreate(null);
                map.onResume();
                map.getMapAsync(this);
            }


        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            //initialize the Google Maps Android API if features need to be used before obtaining a map
            MapsInitializer.initialize(context);
            mMap = googleMap;

            LatLng myLocation = new LatLng(39.2363477,-77.0823048);
            mMap.addMarker(new MarkerOptions().position(myLocation).title("My Location"));

            CameraUpdate center = CameraUpdateFactory.newLatLng(myLocation);
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
            mMap.moveCamera(center);
            mMap.animateCamera(zoom);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case SEND_MESSAGE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity30_send_message, parent, false);
                return new SendMessageItemViewHolder(view);
            case RECEIVE_MESSAGE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity30_receive_message, parent, false);
                return new ReceiveMessageItemViewHolder(view);
            case RECEIVE_IMAGE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity30_receive_image, parent, false);
                return new ReceiveImageItemViewHolder(view);
            case RECEIVE_AUDIO:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity30_receive_audio, parent, false);
                return new ReceiveAudioItemViewHolder(view);
            case RECEIVE_MAP:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity30_receive_map, parent, false);
                return new ReceiveMapItemViewHolder(view);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()){
            case SEND_MESSAGE:
                SendMessageItemViewHolder sendMessageHolder = (SendMessageItemViewHolder) holder;
                sendMessageHolder.sendMessage.setText(dataList.get(position).getMessage());
                sendMessageHolder.sendTime.setText(dataList.get(position).getTime());
                break;
            case RECEIVE_MESSAGE:
                ReceiveMessageItemViewHolder receiveMessageHolder = (ReceiveMessageItemViewHolder) holder;
                receiveMessageHolder.receiveMessage.setText(dataList.get(position).getMessage());
                receiveMessageHolder.receiveTime.setText(dataList.get(position).getTime());
                break;
            case RECEIVE_IMAGE:
                ReceiveImageItemViewHolder receiveImageHolder = (ReceiveImageItemViewHolder) holder;
                break;
            case RECEIVE_AUDIO:
                final ReceiveAudioItemViewHolder receiveAudioHolder = (ReceiveAudioItemViewHolder) holder;
                mediaPlayer = MediaPlayer.create(context, R.raw.audio);

                receiveAudioHolder.seekbar.setClickable(false);

                finalTime = mediaPlayer.getDuration();

                receiveAudioHolder.txtTotal.setText(String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalTime)))
                );


                receiveAudioHolder.buttonAudio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(isPlaying){
                            mediaPlayer.pause();
                            isPlaying = false;

                            receiveAudioHolder.buttonAudio.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_play));
                        }else {
                            mediaPlayer.start();

                            receiveAudioHolder.buttonAudio.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_pause));

                            startTime = mediaPlayer.getCurrentPosition();
                            receiveAudioHolder.seekbar.setMax((int) finalTime);

                            receiveAudioHolder.txtNow.setText(String.format("%02d:%02d",
                                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                                    startTime)))
                            );

                            receiveAudioHolder.seekbar.setProgress((int) startTime);

                            txtNow = receiveAudioHolder.txtNow;
                            seekbar = receiveAudioHolder.seekbar;

                            myHandler.postDelayed(UpdateSongTime, 100);

                            isPlaying = true;
                        }

                    }
                });
                break;
            case RECEIVE_MAP:
                ReceiveMapItemViewHolder receiveMapHolder = (ReceiveMapItemViewHolder) holder;

                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            txtNow.setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}
