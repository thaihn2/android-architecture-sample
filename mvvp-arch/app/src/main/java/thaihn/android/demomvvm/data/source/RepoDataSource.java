package thaihn.android.demomvvm.data.source;

import java.util.List;

import thaihn.android.demomvvm.data.model.Repository;

public interface RepoDataSource {

    interface RemoteDataSource {
        void getUserRemote(String url, OnFetchDataSource listener);
    }

    interface OnFetchDataSource {
        void onFetchDataSuccess(List<Repository> list);

        void onGetDataError(String message);
    }
}
