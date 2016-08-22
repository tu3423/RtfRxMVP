package me.pwcong.rtfrxmvp.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.NewTabFragmentAdapter;
import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsTabFragmentPresenter;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsTabFragment extends BaseFragment implements BaseView.NewsTabFragmentView {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    NewsTabFragmentPresenter presenter;

    @Override
    protected void initVariable() {

        tabLayout.setupWithViewPager(viewPager);

        presenter=new NewsTabFragmentPresenter(this);

    }

    @Override
    protected void doAction() {

        presenter.initNewsFragmentTab();

    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_news;
    }


    @Override
    public void showError() {

    }

    @Override
    public void setData(List<NewsTab> data) {

        viewPager.setAdapter(new NewTabFragmentAdapter(getChildFragmentManager(),data));

    }
}