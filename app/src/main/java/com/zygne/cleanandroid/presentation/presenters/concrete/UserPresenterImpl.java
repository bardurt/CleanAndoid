package com.zygne.cleanandroid.presentation.presenters.concrete;

import com.zygne.clean2.domain.thread.MainThread;
import com.zygne.clean2.presentation.presenters.core.AbstractPresenter;
import com.zygne.cleanandroid.domain.interactors.concrete.UserInteractorImpl;
import com.zygne.cleanandroid.domain.interactors.interfaces.UserInteractor;
import com.zygne.cleanandroid.presentation.presenters.interfaces.UserPresenter;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */
public class UserPresenterImpl extends AbstractPresenter implements UserPresenter,
        UserInteractor.Callback{

    private View view;

    public UserPresenterImpl(MainThread mainThread, View view){
        super(mainThread);
        this.view = view;
    }

    @Override
    public void usernameValid() {

        if(view != null) {

            view.hideProgress();

            view.usernameValid();
        }
    }

    @Override
    public void usernameInvalid() {

        if(view != null) {

            view.hideProgress();

            view.usernameInvalid();
        }
    }

    @Override
    public void validateUsername(String username) {

        if(view != null) {

            view.showProgress();

            UserInteractorImpl interactor = new UserInteractorImpl(
                    mainThread,
                    this,
                    username
            );

            interactor.execute();
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

        view = null;
    }
}
