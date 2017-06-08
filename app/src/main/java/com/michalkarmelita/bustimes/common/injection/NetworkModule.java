package com.michalkarmelita.bustimes.common.injection;

import com.michalkarmelita.bustimes.BuildConfig;
import com.michalkarmelita.bustimes.common.injection.scopes.PerApplication;
import com.michalkarmelita.bustimes.common.network.TflApi;
import com.michalkarmelita.bustimes.common.network.adapters.LiveDataCallAdapterFactory;
import com.michalkarmelita.bustimes.common.network.interceptors.LogInInterceptor;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://api.tfl.gov.uk";

    @Provides
    @PerApplication
    LogInInterceptor provideLogInInterceptor() {
        return new LogInInterceptor();
    }

    @Provides
    @PerApplication
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }

    @Provides
    @PerApplication
    OkHttpClient provideOkHttpClient(LogInInterceptor logInInterceptor, HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(logInInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @PerApplication
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(client)
                .build();
    }

    @Provides
    @PerApplication
    TflApi provideTflApiService(Retrofit retrofit) {
        return retrofit.create(TflApi.class);
    }

}
