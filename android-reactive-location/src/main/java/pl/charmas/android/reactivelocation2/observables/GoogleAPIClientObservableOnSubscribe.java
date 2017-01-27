package pl.charmas.android.reactivelocation2.observables;

import android.content.Context;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class GoogleAPIClientObservableOnSubscribe extends BaseObservableOnSubscribe<GoogleApiClient> {

    @SafeVarargs
    public static Observable<GoogleApiClient> create(Context context, Api<? extends Api.ApiOptions.NotRequiredOptions>... apis) {
        return Observable.create(new GoogleAPIClientObservableOnSubscribe(context, apis));
    }

    @SafeVarargs
    private GoogleAPIClientObservableOnSubscribe(Context ctx, Api<? extends Api.ApiOptions.NotRequiredOptions>... apis) {
        super(ctx, apis);
    }

    @Override
    protected void onGoogleApiClientReady(GoogleApiClient apiClient, ObservableEmitter<GoogleApiClient> emitter) {
        emitter.onNext(apiClient);
    }
}
