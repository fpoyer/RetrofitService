package com.humanbooster.android.retrofitservice;

import android.os.Binder;

/**
 * Created by fpoyer on 13/06/16.
 */
public class GithubBinder extends Binder{
    private GithubRepositoryListSyncService service;

    public GithubBinder(GithubRepositoryListSyncService service) {
        this.service = service;
    }

    public void getFreshData(GithubRepositoryManager githubRepositoryManager) {
        service.getFreshData(githubRepositoryManager);
    }
}
