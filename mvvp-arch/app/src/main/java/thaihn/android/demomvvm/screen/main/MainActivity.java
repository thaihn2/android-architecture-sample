package thaihn.android.demomvvm.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import java.util.ArrayList;

import thaihn.android.demomvvm.R;
import thaihn.android.demomvvm.data.model.Repository;
import thaihn.android.demomvvm.data.repository.RepoRepository;
import thaihn.android.demomvvm.databinding.ActivityMainBinding;
import thaihn.android.demomvvm.screen.BaseActivity;

public class MainActivity extends BaseActivity {

    private MainViewModel mMainViewModel;
    private MainAdapter mMainAdapter;
    private ActivityMainBinding mBinding;

    @Override
    protected int getLayoutResource() {

        return R.layout.activity_main;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {
        DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        mMainAdapter = new MainAdapter(new ArrayList<Repository>());
        RepoRepository repoRepository = RepoRepository.getInstane();
        mMainViewModel = new MainViewModel(mMainAdapter, repoRepository);

        mMainViewModel.getRepo("https://api.github.com/users/google/repos");
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        Repository repository = new Repository();
//        repository.setName("Thaihn");
//        repository.setDescription("aaaaaaaa");
//        binding.setRepository(repository);
    }
}
