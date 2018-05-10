package vn.asiantech.internship.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("/artists/{Name}")
    Call<ResponseData> getData(@Path("Name") String name, @Query("app_id") String id);
}
