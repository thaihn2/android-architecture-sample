package thaihn.android.demomvvm.screen.main;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import thaihn.android.demomvvm.data.model.Repository;

public class ItemMain extends BaseObservable {

    public ObservableField<Repository> mListObservableField = new ObservableField<>();
    private MainAdapter.OnClickListener mOnClickListener;

    public ItemMain(MainAdapter.OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    public void setRepository(@NonNull Repository repository) {
        mListObservableField.set(repository);
    }

    public void onItemClicked(View view) {
        if (mOnClickListener == null && mListObservableField.get() == null) {
            return;
        }
        mOnClickListener.onItemClicked(mListObservableField.get().getId());
    }
}
