package xyz.bitnaesser.multiplechoice.question;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import nucleus5.factory.RequiresPresenter;
import nucleus5.view.NucleusActivity;
import xyz.bitnaesser.multiplechoice.R;


@RequiresPresenter(QuestionPresenter.class)
public class QuestionActivity extends NucleusActivity<QuestionPresenter> {

    private TextView textViewQuestion;

    private LinearLayout answersContainer;
    private ArrayList<CheckBox> checkBoxAnswers;

    private Button buttonNext;
    private Button buttonShowResults;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            getPresenter().loadQuestion();

        setContentView(R.layout.activity_question);

        textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);
        answersContainer = (LinearLayout)findViewById(R.id.answers_container);

        registerButtonNext();
    }

    /**
     * Register onclickhandler for buttonNext
     */
    private void registerButtonNext(){
        buttonNext = (Button)findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getPresenter().next();
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
