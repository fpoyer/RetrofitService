package com.humanbooster.android.retrofitservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by fpoyer on 13/06/16.
 */
class GithubServiceConnection implements ServiceConnection {
    private GithubRepositoryManager githubRepositoryManager;
    private final Context context;

    public GithubServiceConnection(GithubRepositoryManager githubRepositoryManager, Context context) {
        this.githubRepositoryManager = githubRepositoryManager;
        this.context = context;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        // TODO use binder to request fresh list
        GithubBinder binder = (GithubBinder) service;
        binder.getFreshData(githubRepositoryManager);
        context.unbindService(this);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
