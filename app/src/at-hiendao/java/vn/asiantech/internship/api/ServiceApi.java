package vn.asiantech.internship.api;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.asiantech.internship.BuildConfig;

public class ServiceApi {
    private static final int CONNECT_TIMEOUT_MILLS = 1000 * 120;
    private static ServiceApi sInstace;
    private static final String BASE_URL = "https://rest.bandsintown.com";
    private IEventRequest mRequest;

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
                .client(getOkHttpClientBuilder().build())
                .build();
        mRequest = retrofit.create(IEventRequest.class);
    }

    private OkHttpClient.Builder getOkHttpClientBuilder() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
                .readTimeout(CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
                .writeTimeout(CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        return okHttpClientBuilder;
    }

    public IEventRequest getRequest() {
        return mRequest;
    }
}
