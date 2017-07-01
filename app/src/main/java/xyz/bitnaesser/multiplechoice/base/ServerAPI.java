/**
 * { "type": "success", "value": [ { "id": 432, "joke": "Chuck Norris is the only man who has, literally, beaten the odds. With his fists.", "categories": [] }, { "id": 3, "joke": "Chuck Norris doesn't read books. He stares them down until he gets the information he wants.", "categories": [] }, { "id": 122, "joke": "Chuck Norris is responsible for China's over-population. He hosted a Karate tournament in Beijing and all women within 1,000 miles became pregnant instantly.", "categories": [] } ]  }
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

    String ENDPOINT = "http://api.icndb.com";

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

    @GET("/jokes/random/10")
    Observable<Response> getItems(@Query("firstName") String firstName, @Query("lastName") String lastName);
}
