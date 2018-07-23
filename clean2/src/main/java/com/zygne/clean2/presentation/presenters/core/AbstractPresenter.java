package com.zygne.clean2.presentation.presenters.core;

import com.zygne.clean2.domain.thread.MainThread;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */
public abstract class AbstractPresenter {

    protected MainThread mainThread;

    public AbstractPresenter(MainThread mainThread){
        this.mainThread = mainThread;
    }
}
