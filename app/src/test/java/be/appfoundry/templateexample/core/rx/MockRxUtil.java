package be.appfoundry.templateexample.core.rx;

import be.appfoundry.core.rx.Transformers;
import rx.Observable;
import rx.schedulers.Schedulers;

public class MockRxUtil implements Transformers {
    @Override
    public <T> Observable.Transformer<T, T> applyComputationSchedulers() {
        return tObservable -> tObservable.subscribeOn(Schedulers.immediate())
            .observeOn(Schedulers.immediate());
    }

    @Override
    public <T> Observable.Transformer<T, T> applyIOSchedulers() {
        return tObservable -> tObservable.subscribeOn(Schedulers.immediate())
            .observeOn(Schedulers.immediate());
    }
}
