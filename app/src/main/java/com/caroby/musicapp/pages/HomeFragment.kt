package com.caroby.musicapp.pages

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.caroby.musicapp.R
import com.caroby.musicapp.Song
import com.caroby.musicapp.SoundPlayer
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {

    val songs = ArrayList<Song>();

    var soundPlayer=SoundPlayer();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        for (i in 0..10) {
            songs.add(
                Song(
                    "Soolking",
                    "La Liberty",
                    "https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3"
                )
            );
        }

        for (value in songs) {
            addSongContainer(value);

        }

        var space = Space(context);
        space.layoutParams = ViewGroup.LayoutParams(10, 150);
        getView()?.findViewById<LinearLayout>(R.id.linearLayout)?.addView(space);
    }


    private fun addSongContainer(value: Song) {
        var view = View.inflate(context, R.layout.song_container, null);

        view.findViewById<TextView>(R.id.text_song_name).text = value.getSongName;
        view.findViewById<TextView>(R.id.text_singer_name).text = value.getSingerName;

        view.setOnClickListener {
            soundPlayer.playSound(it.context,value.getLink);
        };


        getView()?.findViewById<LinearLayout>(R.id.linearLayout)?.addView(view);
    }

    fun showSnack(view: View, messaage: String) {
        Snackbar.make(view, messaage, Snackbar.LENGTH_SHORT).show();
    }

}