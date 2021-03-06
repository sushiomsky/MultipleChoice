package xyz.bitnaesser.multiplechoice.question;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.CheckBox;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import nucleus5.presenter.Factory;
import nucleus5.presenter.RxPresenter;
import xyz.bitnaesser.multiplechoice.base.App;
import xyz.bitnaesser.multiplechoice.base.ServerAPI;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

public class QuestionPresenter extends RxPresenter<QuestionActivity> {

    public static final String NAME_1 = "Chuck Norris";
    public static final String DEFAULT_NAME = NAME_1;

    private static final int REQUEST_ITEMS = 1;

    private static final String NAME_KEY = QuestionPresenter.class.getName() + "#name";

    private String name = DEFAULT_NAME;

    private ServerAPI.Question[] questions;
    private int questionsIndex = 0;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        if (savedState != null)
            name = savedState.getString(NAME_KEY);

        /**
             This is a shortcut that can be used instead of combining together restartable(int, Factory),
             deliverLatestCache(), split(BiConsumer, BiConsumer).

             Parameters:
             restartableId - an id of the restartable.
             observableFactory - a factory that should return an Observable when the restartable should run.
             onNext - a callback that will be called when received data should be delivered to view.
             onError - a callback that will be called if the source observable emits onError.
         */
        restartableLatestCache(REQUEST_ITEMS,
                new Factory<Observable<ServerAPI.Response>>() {
                    @Override
                    public Observable<ServerAPI.Response> create() {
                        return App.getServerAPI()
                                .getQuestions()
                                .subscribeOn(io())
                                .observeOn(mainThread());
                    }
                },

               /**
                public interface BiConsumer<T1, T2>
                A functional interface (callback) that accepts two values (of possibly different types).
               */
                new BiConsumer<QuestionActivity, ServerAPI.Response>() {

                    /**
                     * Model data changed the View will be informed via Callback
                     * Data->Model->Presenter->View Flow
                     */
                    @Override
                    public void accept(QuestionActivity activity, ServerAPI.Response response) throws Exception {

                        /**
                         * Cache the Questions[] from ServerApi response
                         */
                       if(questions == null) questions = response.questions;

                       activity.showQuestion(questions[questionsIndex].text, convertAnswers(questions[questionsIndex].answers));
                       questionsIndex++;
                    }
                },
                new BiConsumer<QuestionActivity, Throwable>() {
                    @Override
                    public void accept(QuestionActivity activity, Throwable throwable) throws Exception {
                        /**
                         * Exception, View will be informed via Callback
                         * Data->Model->Presenter->View Flow
                         */
                        activity.onNetworkError(throwable);
                    }
                });

        if (savedState == null)
            start(REQUEST_ITEMS);
    }

    @Override
    public void onSave(@NonNull Bundle state) {
        super.onSave(state);
        state.putString(NAME_KEY, name);
    }

    /**
     * View->Presenter->Model Flow
     */
    public void request() {
        start(REQUEST_ITEMS);
    }

    public static ArrayList<String> convertAnswers(ServerAPI.Question.Answer[] answers){
        ArrayList<String> answerList = new ArrayList<String>();

        for (ServerAPI.Question.Answer answer:  answers) {
            answerList.add(answer.text);
        }
        return answerList;
    }
    /**
     * View->Presenter->Model Flow
     */
    public void selectedAnswers(ArrayList<CheckBox> checkBoxes){
        ArrayList<Integer> answerIds = new ArrayList();
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isSelected()){
                answerIds.add(checkBoxes.get(i).getId());
            }
        }
    }
}
