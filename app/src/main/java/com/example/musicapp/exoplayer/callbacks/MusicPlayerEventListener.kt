package com.example.musicapp.exoplayer.callbacks

import android.widget.Toast
import com.example.musicapp.exoplayer.MusicService
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player

@Suppress("DEPRECATION")
class MusicPlayerEventListener(
    private val musicService: MusicService
) : Player.Listener{

    @Deprecated("Deprecated in Java")
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)

        if (playbackState == Player.STATE_READY && !playWhenReady){
            musicService.stopForeground(false)
        }

    }

    override fun onPlayerError(error: PlaybackException) {
        super.onPlayerError(error)
        Toast.makeText(musicService, "An unknown error occurred.", Toast.LENGTH_SHORT).show()
    }

}