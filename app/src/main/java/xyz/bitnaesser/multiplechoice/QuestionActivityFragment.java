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

package xyz.bitnaesser.multiplechoice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A fragment containing a simple view.
 */
public class QuestionActivityFragment extends Fragment implements View.OnClickListener{
    private TextView textViewQuestion,
                        textViewAnswer1,
                        textViewAnswer2,
                        textViewAnswer3,
                        textViewAnswer4,
                        textViewAnswer5,
                        textViewAnswer6;

    public QuestionActivityFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        textViewQuestion = (TextView)container.findViewById(R.id.textViewQuestion);
        textViewAnswer1 = (TextView)container.findViewById(R.id.textViewAnswer1);
        textViewAnswer2 = (TextView)container.findViewById(R.id.textViewAnswer2);
        textViewAnswer3 = (TextView)container.findViewById(R.id.textViewAnswer3);
        textViewAnswer4 = (TextView)container.findViewById(R.id.textViewAnswer4);
        textViewAnswer5 = (TextView)container.findViewById(R.id.textViewAnswer5);
        textViewAnswer6 = (TextView)container.findViewById(R.id.textViewAnswer6);

        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        answerSelected((TextView) view);
    }

    void answerSelected(TextView answerTextView){
        answerTextView.setBackgroundColor(0);
    }

    void hideAnswerTextView(TextView answerTextView){
        answerTextView.setVisibility(View.GONE);
    }

    void setTextViewQuestion(String questionString){}

    void setAnswerTextViews(ArrayList<String> answerStrings){

    }

}
