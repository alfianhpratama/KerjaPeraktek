package id.alfiandroid.kpsukses;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import id.alfiandroid.kpsukses.APIServer.ApiServer;
import id.alfiandroid.kpsukses.APIServer.AppController;
import id.alfiandroid.kpsukses.Adapter.Jadwal;
import id.alfiandroid.kpsukses.Adapter.JadwalAdapter;

public class HomeActivity extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLaymanager;
    private ArrayList<Jadwal> mJadwalData;
    private JadwalAdapter mAdapter;

    final String id_user = "alfian";

    public HomeActivity() {
    }

    ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mLaymanager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLaymanager);
        mJadwalData = new ArrayList<>();
        mAdapter = new JadwalAdapter(getActivity(), mJadwalData);
        mRecyclerView.setAdapter(mAdapter);

        loadJadwal();
        loadData();

        return rootView;
    }

    private void loadData() {
    }

    private void loadJadwal() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, ApiServer.URL_DATA, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("volley", "response : " + response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                Jadwal jadwal = new Jadwal();
                                jadwal.setNama_kelas(data.getString("nama_kelas"));
                                jadwal.setWaktu_pengajaran(data.getString("waktu_pengajaran"));
                                mJadwalData.add(jadwal);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(request);
    }

}
