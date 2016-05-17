package be.appfoundry.templateexample.ui.detail;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class DetailPresenterTest {

    private DetailPresenter presenter;
    private MockDetailView detailView;

    @Before
    public void setUp() throws Exception {
        presenter = new DetailPresenter();
        detailView = new MockDetailView();
    }

    @Test
    public void preConditions() {
        assertNotNull(presenter);
        assertNotNull(detailView);
    }

    @Test
    public void testGetData() {
        presenter.attachView(detailView);
        presenter.getData();
        assertTrue(detailView.snackbarShown);
    }

    @Test
    public void testGetDataViewNotAttached() {
        presenter.getData();
        assertFalse(detailView.snackbarShown);
    }
}
