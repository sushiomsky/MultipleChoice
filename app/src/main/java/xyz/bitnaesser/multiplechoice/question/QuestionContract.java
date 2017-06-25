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

import xyz.bitnaesser.multiplechoice.BasePresenter;
import xyz.bitnaesser.multiplechoice.BaseView;
import xyz.bitnaesser.multiplechoice.model.Question;

/**
 * Created by sushi on 25.06.17.
 */

/**
 * This specifies the contract between the view and the presenter.
 */

public interface QuestionContract {

    interface View extends BaseView<Presenter> {

        void showQuestion(Question question);

        void showAnswerSelected(int answerId);
    }

    interface Presenter extends BasePresenter {

        void loadQuestions();

    }
}
