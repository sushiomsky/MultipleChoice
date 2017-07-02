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

    String ENDPOINT = "http://bitnaesser.xyz";

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
        }
    }

    class Response {
        @SerializedName("value")
        public Question[] questions;
    }

    @GET("/question/random")
    Observable<Response> getQuestions();
}
