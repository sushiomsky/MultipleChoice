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
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xyz.bitnaesser.multiplechoice.R;
import xyz.bitnaesser.multiplechoice.model.Question;

/**
 * A fragment containing a simple view.
 */
public class QuestionActivityFragment extends Fragment implements QuestionContract.View{
    private TextView textViewQuestion,
                        textViewAnswer1,
                        textViewAnswer2,
                        textViewAnswer3,
                        textViewAnswer4,
                        textViewAnswer5,
                        textViewAnswer6;

    public QuestionActivityFragment() {}

    public static QuestionActivityFragment newInstance() {
        return new QuestionActivityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void setPresenter(QuestionContract.Presenter presenter) {

    }

    @Override
    public void showQuestion(Question question) {

    }

    @Override
    public void showAnswerSelected(int answerId) {

    }

    private static class QuestionsAdapter extends BaseAdapter {

        private List<Question> mQuestions;
        private QuestionAnswerListener mQuestionAnswerListener;

        public QuestionsAdapter(List<Question> questions, QuestionAnswerListener questionAnswerListener) {
            setList(questions);
            mQuestionAnswerListener = questionAnswerListener;
        }

        public void replaceData(List<Question> questions) {
            setList(questions);
            notifyDataSetChanged();
        }

        private void setList(List<Question> questions) {
            mQuestions = questions;
        }

        @Override
        public int getCount() {
            return mQuestions.size();
        }

        @Override
        public Question getItem(int i) {
            return mQuestions.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View rowView = view;
            if (rowView == null) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                rowView = inflater.inflate(R.layout.fragment_question, viewGroup, false);
            }

            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mQuestionAnswerListener.onAnswerClick(view);
                }
            });

            return rowView;
        }
    }

    public interface QuestionAnswerListener {
        void onAnswerClick(View clickedAnswer);
    }

}
