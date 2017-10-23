package dreamteam.com.school.ui.school.pupils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamteam.com.school.R;
import dreamteam.com.school.common.mvp.MvpFragment;
import dreamteam.com.school.entity.DbPupil;
import dreamteam.com.school.ui.pupil.PupilInfoActivity;
import dreamteam.com.school.ui.school.pupils.adapter.PupilAdapter;
import dreamteam.com.school.ui.school.school.SchoolFragment;
import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 15.09.17.
 */

public class PupilListFragment extends MvpFragment<PupilListPresenter> implements PupilListView, PupilAdapter.PupilActionListener {
    private final static String LOG_TAG = Logger.getClassTag(PupilListFragment.class);


    @BindView(R.id.pupilsRecyclerView)
    RecyclerView pupilsRecyclerView;

    PupilAdapter pupilAdapter;

    public static PupilListFragment newInstance(int schoolId) {
        PupilListFragment pupilListFragment = new PupilListFragment();
        Bundle args = new Bundle();
        args.putInt(SchoolFragment.SCHOOL_ID, schoolId);
        pupilListFragment.setArguments(args);
        return pupilListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_pupil_list, null);

        setUnbinder(ButterKnife.bind(this, view));
        initAdapter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().getAllSchoolPupils(getArguments().getInt(SchoolFragment.SCHOOL_ID));
    }

    private void initAdapter() {
        pupilsRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        pupilsRecyclerView.setLayoutManager(llm);

        pupilAdapter = new PupilAdapter(getActivity());
        pupilAdapter.setOnPupilActionListener(this);
        pupilsRecyclerView.setAdapter(pupilAdapter);
    }

    @Override
    public void onPupilsLoaded(List<DbPupil> dbPupils) {
        if (pupilAdapter == null) {
            pupilAdapter = new PupilAdapter(getActivity());
            pupilsRecyclerView.setAdapter(pupilAdapter);
        }
        pupilAdapter.addPupils(dbPupils);
        pupilAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPupilClicked(DbPupil dbPupil) {
        startActivity(PupilInfoActivity.newInstance(getActivity(), dbPupil.getPupilId()));
    }

    @Override
    public PupilListPresenter createPresenter() {
        return new PupilListPresenter();
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
