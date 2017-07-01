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

        @Override
        public String toString() {
            return Html.fromHtml(text).toString();
        }

        @SerializedName("answers")
        public String[] answers;
    }
    class Response {
        @SerializedName("value")
        public Question[] questions;
    }

    @GET("/question/random")
    Observable<Response> getQuestions();
}
