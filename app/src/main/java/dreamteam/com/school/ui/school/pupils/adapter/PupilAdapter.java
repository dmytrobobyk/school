package dreamteam.com.school.ui.school.pupils.adapter;

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
import dreamteam.com.school.entity.DbPupil;
import dreamteam.com.school.util.ClassUtil;
import dreamteam.com.school.util.GlideUtil;

/**
 * Created by dima on 15.09.17.
 */

public class PupilAdapter extends RecyclerView.Adapter<PupilAdapter.PupilViewHolder> {

    private Context context;
    private List<DbPupil> pupilList = new ArrayList<>();
    private PupilActionListener pupilActionListener;


    public PupilAdapter(Context context) {
        this.context = context;
    }

    public interface PupilActionListener {
        void onPupilClicked(DbPupil dbPupil);
    }

    public void setOnPupilActionListener(PupilActionListener pupilActionListener) {
        this.pupilActionListener = pupilActionListener;
    }

    public void addPupils(List<DbPupil> dbPupils) {
        this.pupilList = dbPupils;
        notifyDataSetChanged();
    }

    @Override
    public PupilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_pupil, parent, false);
        return new PupilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PupilViewHolder holder, int position) {
        DbPupil dbPupil = pupilList.get(position);

        GlideUtil.setRoundedImage(dbPupil.getPhotoUrl(), holder.pupilImageView);
        holder.pupilNameTextView.setText(String.format(context.getString(R.string.two_words_with_space),
                dbPupil.getFirstName(), dbPupil.getLastName()));
        holder.pupilClassNameTextView.setText(String.valueOf(dbPupil.getSchoolClassId()));
        holder.ratingTextView.setText(ClassUtil.formatRating(dbPupil.getRating()));
    }

    @Override
    public int getItemCount() {
        return pupilList.size();
    }

    public class PupilViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pupilImageView)
        ImageView pupilImageView;
        @BindView(R.id.pupilNameTextView)
        TextView pupilNameTextView;
        @BindView(R.id.pupilClassNameTextView)
        TextView pupilClassNameTextView;
        @BindView(R.id.ratingTextView)
        TextView ratingTextView;

        public PupilViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.pupilLayout)
        public void onPupilClicked(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && pupilActionListener != null) {
                pupilActionListener.onPupilClicked(pupilList.get(position));
            }
        }
    }
}
