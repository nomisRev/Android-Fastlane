package be.appfoundry.templateexample.ui.master;

public class MockMasterView implements MasterContract.MvpView {

    public boolean printedRepo;
    public boolean errorShown;

    @Override
    public void printRepo(final String repoName) {
        printedRepo = true;
    }

    @Override
    public void showError() {
        errorShown = true;
    }
}
