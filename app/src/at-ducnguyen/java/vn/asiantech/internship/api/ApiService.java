package vn.asiantech.internship.api;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ApiService {
    private static final String BASE_URL = "https://rest.bandsintown.com";
    private Retrofit mRetrofit;

    public ApiService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ArtistAPI getArtistAPI() {
        return mRetrofit.create(ArtistAPI.class);
    }
}
