package com.caroby.musicapp

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri

class SoundPlayer {

    var mMediaPlayer: MediaPlayer? = null

    // 1. Plays the water sound
    fun playSound(c:Context,link:String) {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(c, Uri.parse(link));
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    // 2. Pause playback
    fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
    }

    // 3. Stops playback
    fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    // 4. Destroys the MediaPlayer instance when the app is closed
    fun onStop() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }
}