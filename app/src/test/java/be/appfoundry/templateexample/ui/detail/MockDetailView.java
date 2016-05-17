package be.appfoundry.templateexample.ui.detail;

public class MockDetailView implements DetailContract.MvpView {

    public boolean snackbarShown;

    @Override
    public void showSnackbar(final String data) {
        snackbarShown = true;
    }
}
