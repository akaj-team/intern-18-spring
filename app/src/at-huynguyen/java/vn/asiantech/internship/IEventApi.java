package vn.asiantech.internship;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IEventApi {

    @GET("/artists/{Name}/")
    Call<InformationSinger> getInformationSinger(@Path("Name")String name, @Query("app_id") String app_id);
}
