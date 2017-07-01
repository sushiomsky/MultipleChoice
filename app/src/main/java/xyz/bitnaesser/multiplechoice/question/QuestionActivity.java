/*
 * *
 *  * ${PROJECT_NAME}
 *  * Copyright (c) ${YEAR} Dennis Suchomsky <dennis.suchomsky@gmail.com>
 *  *
 *  *  This program is free software: you can redistribute it and/or modify
 *  *  it under the terms of the GNU General Public License as published by
 *  *  the Free Software Foundation, either version 3 of the License, or
 *  *  (at your option) any later version.
 *  *
 *  *  This program is distributed in the hope that it will be useful,
 *  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *  GNU General Public License for more details.
 *  *
 *  *  You should have received a copy of the GNU General Public License
 *  *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * *
 *  @todo Keep it simple!
 * /
 */

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
    }
}
