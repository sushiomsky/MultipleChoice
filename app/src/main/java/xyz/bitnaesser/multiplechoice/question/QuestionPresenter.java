package xyz.bitnaesser.multiplechoice.question;

import android.os.Bundle;
import android.support.annotation.NonNull;

import nucleus5.presenter.RxPresenter;

public class QuestionPresenter extends RxPresenter<QuestionActivity> {

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
    }

    @Override
    public void onSave(@NonNull Bundle state) {
        super.onSave(state);
    }


    public void loadQuestion(){

        //get a Question object
    }

    public void next() {
  //      start(REQUEST_ITEMS);
    }
}
