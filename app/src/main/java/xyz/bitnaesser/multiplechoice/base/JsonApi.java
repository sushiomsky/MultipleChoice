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

package xyz.bitnaesser.multiplechoice.base;

import android.text.Html;

import com.google.gson.annotations.SerializedName;

import io.reactivex.Observable;

/**
 * Created by sushi on 03.07.17.
 */

public interface JsonApi {
	class Question {
		@SerializedName("question")
		public String text;

		@SerializedName("id")
		public String questionId;

		@Override
		public String toString() {
			return Html.fromHtml(text).toString();
		}

		@SerializedName("answers")
		public Answer[] answers;

		public class Answer{
			@SerializedName("answer")
			public String text;

			@SerializedName("id")
			public String answerId;

			@SerializedName("correct")
			public String correct;
		}
	}

	class Response {
		@SerializedName("value")
		public Question[] questions;
	}

	Observable<Response> getQuestions();
}
