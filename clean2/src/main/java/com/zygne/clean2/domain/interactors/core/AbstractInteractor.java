package com.zygne.clean2.domain.interactors.core;

import com.zygne.clean2.domain.thread.MainThread;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */
public abstract class AbstractInteractor {

    private volatile boolean running;

    /* Reference to the main thread, for allowing the interactor
       to post updates from a background thread to the main thread. */
    protected MainThread mainThread;

    public AbstractInteractor(MainThread mainThread){
        this.mainThread = mainThread;
    }

    protected boolean isRunning(){
        return running;
    }

    protected void setRunning(boolean b){
        this.running = b;
    }

}
