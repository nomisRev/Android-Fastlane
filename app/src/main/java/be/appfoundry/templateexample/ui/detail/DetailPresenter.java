package be.appfoundry.templateexample.ui.detail;

import be.appfoundry.core.mvp.MVPPresenter;
import javax.inject.Inject;

public class DetailPresenter extends MVPPresenter<DetailContract.MvpView>
    implements DetailContract.MvpPresenter<DetailContract.MvpView> {

    public static final String DATA = "DATA";

    @Inject
    public DetailPresenter() {
        //empty constructor
    }

    @Override
    public void getData() {
        if (isViewAttached()) {
            getView().showSnackbar(DATA);
        }
    }
}
