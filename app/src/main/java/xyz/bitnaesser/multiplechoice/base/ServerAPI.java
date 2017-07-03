/**
 *
 *  @todo Keep it simple!
 *
 */

package xyz.bitnaesser.multiplechoice.base;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServerAPI extends JsonApi {

    String ENDPOINT = "http://bitnaesser.xyz";

    @GET("/question/random")
    Observable<Response> getQuestions();
}
