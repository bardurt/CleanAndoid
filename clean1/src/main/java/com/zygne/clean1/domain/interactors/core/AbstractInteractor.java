package com.zygne.clean1.domain.interactors.core;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */
public abstract class AbstractInteractor {

    private boolean running;

    protected boolean isRunning(){
        return running;
    }

    protected void setRunning(boolean b){
        this.running = b;
    }

}
