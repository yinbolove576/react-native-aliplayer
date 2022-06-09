package com.rnaliplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;

public class AliSurfaceView extends FrameLayout {
    public AliPlayer aliyunVodPlayer;

    public AliSurfaceView(Context context) {
        super(context);
        aliyunVodPlayer = AliPlayerFactory.createAliPlayer(context);
        TextureView textureView = new TextureView(context);
        textureView.setOpaque(false);
        addView(textureView);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {

            @Override
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
                aliyunVodPlayer.setSurface(new Surface(surface));
            }

            @Override
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
                aliyunVodPlayer.surfaceChanged();
            }

            @Override
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
                aliyunVodPlayer.setSurface(null);
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {

            }
        });
    }
}