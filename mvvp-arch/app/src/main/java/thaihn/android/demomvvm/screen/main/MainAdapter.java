package thaihn.android.demomvvm.screen.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import thaihn.android.demomvvm.data.model.Repository;
import thaihn.android.demomvvm.databinding.ItemRepoBinding;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {

    private List<Repository> mRepositories;
    private OnClickListener mOnClickListener;

    public MainAdapter(List<Repository> list) {
        this.mRepositories = list;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemRepoBinding binding = DataBindingUtil.inflate(layoutInflater,
                viewType, parent, false);
        return new ItemViewHolder(binding, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(mRepositories.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepositories == null ? 0 : mRepositories.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        private ItemRepoBinding mItemRepoBinding;
        private OnClickListener mOnClickListener;
        private ItemMain mItemMain;

        public ItemViewHolder(ItemRepoBinding binding, OnClickListener listener) {
            super(binding.getRoot());
            this.mItemRepoBinding = binding;
            this.mOnClickListener = listener;
            mItemMain = new ItemMain(listener);
            mItemRepoBinding.setViewModel(mItemMain);
        }

        public void bind(Repository repository) {
            mItemMain.setRepository(repository);
            mItemRepoBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            if (v == itemView) {
                mOnClickListener.onItemClicked(getAdapterPosition());
            }
        }
    }

    interface OnClickListener {
        void onItemClicked(int position);
    }
}
