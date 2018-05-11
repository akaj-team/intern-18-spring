package vn.asiantech.internship.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceApi {
    private static final String BASE_URL = "https://rest.bandsintown.com";

    private static ServiceApi sInstace;
    private ApiRequest mRequest;

    public static ServiceApi getInstance() {
        if (sInstace == null) {
            sInstace = new ServiceApi();
        }
        return sInstace;
    }

    private ServiceApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRequest = retrofit.create(ApiRequest.class);
    }

    public ApiRequest getRequest() {
        return mRequest;
    }
}
