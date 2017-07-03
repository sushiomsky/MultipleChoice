/**
 *
 *  @todo Keep it simple!
 *
 */

package xyz.bitnaesser.multiplechoice.base;

import android.text.Html;

import com.google.gson.annotations.SerializedName;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServerAPI {

    String ENDPOINT = "https://api.myjson.com";
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

    @GET("/bins/q7cx3")
    Observable<Response> getQuestions();


}
