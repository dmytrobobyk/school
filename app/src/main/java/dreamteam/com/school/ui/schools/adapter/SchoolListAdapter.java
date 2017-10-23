package dreamteam.com.school.ui.schools.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dreamteam.com.school.R;
import dreamteam.com.school.entity.DbSchool;

/**
 * Created by dima on 13.04.17.
 */

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.SchoolsViewHolder> {

    private Context context;
    private List<DbSchool> schoolsList = new ArrayList<>();
    private SchoolActionListener schoolActionListener;

    public SchoolListAdapter(Context context) {
        this.context = context;
    }

    public interface SchoolActionListener {
        void onSchoolItemClicked(DbSchool dbSchool);
    }

    public void setOnSchoolActionListener(SchoolActionListener schoolActionListener) {
        this.schoolActionListener = schoolActionListener;
    }

    public void addSchools(List<DbSchool> schoolsList) {
        this.schoolsList = schoolsList;
        notifyDataSetChanged();
    }

    @Override
    public SchoolListAdapter.SchoolsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_school, parent, false);
        return new SchoolsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SchoolListAdapter.SchoolsViewHolder holder, int position) {
        DbSchool school = schoolsList.get(position);

        Glide.with(context)
                .load(school.getPhotoUrl())
                .centerCrop()
                .into(holder.schoolImageView);
        holder.schoolNameTextView.setText(school.getSchoolName());
        holder.schoolCountryTextView.setText(school.getSchoolCountry());
        holder.schoolCityTextView.setText(school.getSchoolCity());
    }

    @Override
    public int getItemCount() {
        return schoolsList.size();
    }

    public class SchoolsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.schoolImageView)
        ImageView schoolImageView;
        @BindView(R.id.schoolNameTextView)
        TextView schoolNameTextView;
        @BindView(R.id.schoolCountryTextView)
        TextView schoolCountryTextView;
        @BindView(R.id.schoolCityTextView)
        TextView schoolCityTextView;

        public SchoolsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.schoolLayout)
        public void onSchoolClicked(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && schoolActionListener != null) {
                schoolActionListener.onSchoolItemClicked(schoolsList.get(position));
            }
        }
    }
}
