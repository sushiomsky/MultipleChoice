/**
 *
 *  @todo Keep it simple!
 * /
 */

package xyz.bitnaesser.multiplechoice.base;

import android.text.Html;

import com.google.gson.annotations.SerializedName;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerAPI {

    String ENDPOINT = "http://bitnaesser.xyz";

    class Item {
        @SerializedName("question")
        public String text;

        @Override
        public String toString() {
            return Html.fromHtml(text).toString();
        }
    }

    class Response {
        @SerializedName("value")
        public Item[] items;
    }

    @GET("/question/random")
    Observable<Response> getItems(@Query("firstName") String firstName, @Query("lastName") String lastName);
}
