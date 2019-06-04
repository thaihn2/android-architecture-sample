package thaihn.android.demomvvm.data.source.remote;

import thaihn.android.demomvvm.data.source.RepoDataSource;
import thaihn.android.demomvvm.data.source.remote.network.GetDataInterator;

public class RepoRemoteDataSource implements RepoDataSource.RemoteDataSource {

    private static RepoRemoteDataSource sRepoRemoteDataSource;

    public static RepoRemoteDataSource getInstance() {
        if (sRepoRemoteDataSource == null) {
            sRepoRemoteDataSource = new RepoRemoteDataSource();
        }
        return sRepoRemoteDataSource;
    }

    @Override
    public void getUserRemote(String url, RepoDataSource.OnFetchDataSource listener) {
        GetDataInterator getDataInterator = GetDataInterator.getInstance(listener);
        getDataInterator.loadData(url);
    }
}
