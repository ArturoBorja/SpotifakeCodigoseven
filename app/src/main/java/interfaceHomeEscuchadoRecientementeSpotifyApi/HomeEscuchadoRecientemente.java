package interfaceHomeEscuchadoRecientementeSpotifyApi;

import modelHomeEscuchadoRecientemente.RecientementeEscuchado;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface HomeEscuchadoRecientemente {

    @Headers({
            "Authorization: Bearer BQA_OeYKC00-2kM6zjWFXRxnjb1za6soL6TTuV4paxNCZMqPYOUw1E5rptScdyg7CRmMFHISgHkGL6UTdBkAr7DRznM9TvqPz8tZbWndmKjWuszxGKfIclYoQnW2U_ItfxLLTo3xFuVWUT15mZM6FJoChNfl7rTszTlDPhsIEhVY2OYANLKVnbtAf1gHabm6z8HrL_qrePHDMrlXs2ugxLVVypW3VUv_2Hs06Th622VBrHhzlKOcQn6IhpBL3Dw63MobJjDYsS4"
    })
    @GET("me/player/recently-played")
    Call<RecientementeEscuchado> getRecientementeEscuchadoId();
}
