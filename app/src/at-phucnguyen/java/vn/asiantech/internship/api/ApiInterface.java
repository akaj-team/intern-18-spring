package vn.asiantech.internship.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.asiantech.internship.model.SingerInfo;

public interface ApiInterface {

    @GET("/artists/{Name}/")
    Call<SingerInfo> getSingerInfo(@Path("Name")String name, @Query("app_id") String app_id);
}
