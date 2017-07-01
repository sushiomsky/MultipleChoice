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
        LinearLayout answersContainer = (LinearLayout) findViewById(R.id.answers_container);

        for(int i = 0; i < 6; i++) {
            CheckBox cb = new CheckBox(this);
            cb.setText("I'm dynamic!");
            answersContainer.addView(cb);
        }

        buttonNext = (Button)findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getPresenter().next();
            }
        });
    }
}
