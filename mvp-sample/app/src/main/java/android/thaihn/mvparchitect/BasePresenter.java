package android.thaihn.mvparchitect;

public interface BasePresenter<T> {

    void setView(T view);

    void onStart();

    void onStop();

}
