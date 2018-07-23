package com.zygne.clean2.threading;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */

import android.os.Handler;
import android.os.Looper;

import com.zygne.clean2.domain.thread.MainThread;

/**
 * Implementation of the MainThread interface.
 *
 * This class is used to send tasks from a background thread to the main thread
 */
public class AndroidThread implements MainThread {

    private static AndroidThread androidThread;

    private final Handler handler;

    private AndroidThread() {
        handler = new Handler(Looper.getMainLooper());
    }

    // post the runnable to the main thread
    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }

    public static MainThread getInstance() {
        if (androidThread == null) {
            androidThread = new AndroidThread();
        }

        return androidThread;
    }
}