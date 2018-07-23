package com.zygne.cleanandroid.presentation.presenters.interfaces;

import com.zygne.clean2.presentation.base.BaseView;
import com.zygne.clean2.presentation.presenters.core.Presenter;

/**
 * TODO define class.
 *
 * @author Bardur Thomsen
 * @version 1.0 22/07/2018.
 */
public interface UserPresenter extends Presenter {

    interface View extends BaseView {
        void usernameValid();
        void usernameInvalid();
    }

    void validateUsername(String username);
}
