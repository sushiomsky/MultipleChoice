package xyz.bitnaesser.multiplechoice.question;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nucleus5.factory.RequiresPresenter;
import nucleus5.view.NucleusActivity;
import xyz.bitnaesser.multiplechoice.R;
import xyz.bitnaesser.multiplechoice.base.ServerAPI;


@RequiresPresenter(QuestionPresenter.class)
public class QuestionActivity extends NucleusActivity<QuestionPresenter> {

    private TextView textViewQuestion;

    private LinearLayout answersContainer;
    private ArrayList<CheckBox> checkBoxAnswers;

    private Button buttonNext;
    private Button buttonShowResults;

    ArrayAdapter<ServerAPI.Question> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if (savedInstanceState == null)
            getPresenter().request();



        textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);
        answersContainer = (LinearLayout)findViewById(R.id.answers_container);

        registerButtonNext();
    }

    public void onQuestions(ServerAPI.Question[] questions, String user) {
        //check1.setChecked(user.equals(MainPresenter.NAME_1));
        //check2.setChecked(user.equals(MainPresenter.NAME_2));

        adapter.clear();
        adapter.addAll(questions);
    }

    public void onNetworkError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
    /**
     * Register onclickhandler for buttonNext
     */
    private void registerButtonNext(){
        buttonNext = (Button)findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getPresenter().request();
            }
        });
    }

    /**
     * Setting a question is only allowed with a list of Answers
     * @param question
     * @param answers
     */
    public void setQuestion(String question, ArrayList<String> answers){
        setQuestionString(question);
        setAnswerStrings(answers);
    }

    private void setQuestionString(String question){
        textViewQuestion.setText(question);
    }

    private void setAnswerStrings(ArrayList<String> answers){
        for (String answer: answers){
            CheckBox cb = new CheckBox(this);
            cb.setText(answer);
            cb.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                }
            });
            answersContainer.addView(cb);
        }
    }
}
