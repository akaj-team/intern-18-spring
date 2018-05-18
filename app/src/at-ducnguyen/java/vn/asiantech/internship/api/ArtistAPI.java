package vn.asiantech.internship.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import vn.asiantech.internship.model.Artist;

public interface ArtistAPI {

    @GET("/artists/{artistname}")
    Call<Artist> getArtistByName(@Path("artistname") String artistName, @Query("app_id") String appId);

}
