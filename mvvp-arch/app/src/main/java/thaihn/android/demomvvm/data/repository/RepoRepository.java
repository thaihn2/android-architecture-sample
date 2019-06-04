package thaihn.android.demomvvm.data.repository;

import thaihn.android.demomvvm.data.source.RepoDataSource;
import thaihn.android.demomvvm.data.source.remote.RepoRemoteDataSource;

public class RepoRepository implements RepoDataSource.RemoteDataSource {

    private static RepoRepository sRepoRepository;
    private static RepoDataSource.RemoteDataSource sRemoteDataSource;

    public static RepoRepository getInstane() {
        if (sRepoRepository == null) {
            sRepoRepository = new RepoRepository(RepoRemoteDataSource.getInstance());
        }
        return sRepoRepository;
    }

    @Override
    public void getUserRemote(String url, RepoDataSource.OnFetchDataSource listener) {
        if (sRemoteDataSource == null) return;
        sRemoteDataSource.getUserRemote(url, listener);
    }

    private RepoRepository(RepoDataSource.RemoteDataSource remote) {
        sRemoteDataSource = remote;
    }
}
