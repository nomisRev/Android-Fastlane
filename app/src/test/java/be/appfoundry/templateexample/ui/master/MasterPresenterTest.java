package be.appfoundry.templateexample.ui.master;

import be.appfoundry.templateexample.core.rx.MockRxUtil;
import be.appfoundry.templateexample.core.service.MockGithubAPI;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class MasterPresenterTest {
    private MasterPresenter presenter;
    private MockMasterView view;
    private MockGithubAPI githubAPI;

    @Before
    public void setUp() {
        githubAPI = new MockGithubAPI();
        presenter = new MasterPresenter(githubAPI, new MockRxUtil());
        view = new MockMasterView();
    }

    @Test
    public void preConditions() {
        assertNotNull(presenter);
        assertFalse(view.printedRepo);
    }

    //This is "a" MVP lib so should not be tested.
    //@Test
    //public void testAssertViewAttached() throws Exception {
    //    presenter.attachView(view);
    //    assertNotNull(presenter.getView());
    //}

    @Test
    public void testRepoPrinted() {
        presenter.attachView(view);
        assertFalse(view.printedRepo);
        presenter.getRepos();
        assertTrue(view.printedRepo);
    }

    @Test
    public void testRetrofitError() {
        presenter.attachView(view);
        assertFalse(view.errorShown);
        githubAPI.throwError = true;
        presenter.getRepos();
        assertTrue(view.errorShown);
    }
}
