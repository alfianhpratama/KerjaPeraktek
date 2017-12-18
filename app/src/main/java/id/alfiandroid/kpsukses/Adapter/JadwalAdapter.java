package id.alfiandroid.kpsukses.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.alfiandroid.kpsukses.DetailActivity;
import id.alfiandroid.kpsukses.R;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {

    private ArrayList<Jadwal> mJadwalData;
    private Context mContext;

    public JadwalAdapter(Context context, ArrayList<Jadwal> jadwalData) {
        this.mJadwalData = jadwalData;
        this.mContext = context;
    }


    @Override
    public JadwalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(JadwalAdapter.ViewHolder holder, int position) {
        Jadwal currentJadwal = mJadwalData.get(position);
        holder.bindTo(currentJadwal);
    }


    @Override
    public int getItemCount() {
        return mJadwalData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleText;
        private TextView mInfoText;
        private Jadwal currentJadwal;


        ViewHolder(View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);

            itemView.setOnClickListener(this);

        }

        void bindTo(Jadwal currentJadwal) {
            mTitleText.setText(currentJadwal.getNama_kelas());
            mInfoText.setText(currentJadwal.getWaktu_pengajaran());
            this.currentJadwal = currentJadwal;

        }

        @Override
        public void onClick(View view) {
            Intent detailIntent	=	new	Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentJadwal.getNama_kelas());

            mContext.startActivity(detailIntent);
        }
    }
}
