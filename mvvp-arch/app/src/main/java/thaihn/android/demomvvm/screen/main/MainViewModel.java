package thaihn.android.demomvvm.screen.main;

import android.databinding.ObservableField;
import android.util.Log;

import java.util.List;

import thaihn.android.demomvvm.data.model.Repository;
import thaihn.android.demomvvm.data.repository.RepoRepository;
import thaihn.android.demomvvm.data.source.RepoDataSource;
import thaihn.android.demomvvm.screen.BaseViewModel;

public class MainViewModel extends BaseViewModel implements
        RepoDataSource.OnFetchDataSource, MainAdapter.OnClickListener {

    public static final String TAG = MainViewModel.class.getSimpleName();

    public ObservableField<String> errorGetData = new ObservableField<>();

    private RepoRepository mRepoRepository;
    private MainAdapter mMainAdapter;

    public MainViewModel(MainAdapter adapter, RepoRepository repoRepository) {
        this.mRepoRepository = repoRepository;
        this.mMainAdapter = adapter;
    }

    public void getRepo(String url) {
        mRepoRepository.getUserRemote(url, this);
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onStop() {

    }

    @Override
    public void onFetchDataSuccess(List<Repository> list) {
        Log.i(TAG, "onFetchDataSuccess: " + list.size());
    }

    @Override
    public void onGetDataError(String message) {
        Log.i(TAG, "onGetDataError: " + message);
    }

    public MainAdapter getMainAdapter() {
        return mMainAdapter;
    }

    @Override
    public void onItemClicked(int position) {
        Log.i(TAG, "onItemClicked: id " + position);
    }
}
