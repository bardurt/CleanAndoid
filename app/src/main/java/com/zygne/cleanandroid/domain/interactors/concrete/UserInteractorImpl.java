package com.zygne.cleanandroid.domain.interactors.concrete;

import com.zygne.clean2.domain.interactors.core.AbstractInteractor;
import com.zygne.clean2.domain.thread.MainThread;
import com.zygne.cleanandroid.domain.interactors.interfaces.UserInteractor;

import java.util.Random;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */
public class UserInteractorImpl extends AbstractInteractor implements
        UserInteractor {

    private Callback callback;
    private String username;

    public UserInteractorImpl(MainThread mainThread, Callback callback, String username) {
        super(mainThread);

        this.callback = callback;
        this.username = username;
    }

    @Override
    public void execute() {

        // interactor does the job on a background thread
        Runnable r = () -> {

            setRunning(true); // mark interactor as running

            int seconds = new Random().nextInt(5000);

            try {
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(username.length() > 4){
                mainThread.post(() -> callback.usernameValid());
            } else {
                mainThread.post(() -> callback.usernameInvalid());
            }

            setRunning(false); // mark interactor as completed
        };

        Thread t = new Thread(r);
        t.start();



    }
}
