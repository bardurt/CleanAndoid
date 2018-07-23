package com.zygne.cleanandroid.domain.interactors.interfaces;


import com.zygne.clean2.domain.interactors.core.Interactor;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */
public interface UserInteractor extends Interactor {

    interface Callback{
        void usernameValid();
        void usernameInvalid();
    }
}
