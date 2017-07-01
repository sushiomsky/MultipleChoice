package xyz.bitnaesser.multiplechoice.question;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nucleus5.factory.RequiresPresenter;
import nucleus5.view.NucleusActivity;
import xyz.bitnaesser.multiplechoice.R;



@RequiresPresenter(QuestionPresenter.class)
public class QuestionActivity extends NucleusActivity<QuestionPresenter> {

    private TextView textViewQuestion,
            textViewAnswer1,
            textViewAnswer2,
            textViewAnswer3,
            textViewAnswer4,
            textViewAnswer5,
            textViewAnswer6;

    private Button buttonNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            getPresenter().loadQuestion();
        setContentView(R.layout.activity_question);

        textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);
        textViewAnswer1 = (TextView)findViewById(R.id.textViewAnswer1);
        textViewAnswer2 = (TextView)findViewById(R.id.textViewAnswer2);
        textViewAnswer3 = (TextView)findViewById(R.id.textViewAnswer3);
        textViewAnswer4 = (TextView)findViewById(R.id.textViewAnswer4);
        textViewAnswer5 = (TextView)findViewById(R.id.textViewAnswer5);
        textViewAnswer6 = (TextView)findViewById(R.id.textViewAnswer6);

        buttonNext = (Button)findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getPresenter().next();
            }
        });

        textViewAnswer1.setOnClickListener(new View.OnClickListener(){
            /**
             * Called when a answer has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                textViewAnswer1.setBackgroundColor(0x00cc00);
            }
        });
    }
}
