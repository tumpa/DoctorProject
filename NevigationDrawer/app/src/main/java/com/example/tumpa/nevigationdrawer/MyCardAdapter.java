package com.example.tumpa.nevigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tumpa on 12/23/2015.
 */
public class MyCardAdapter extends RecyclerView.Adapter<MyCardAdapter.ViewHolder> {
    List <Doctor> doctorList;

    Context mContext;
    public MyCardAdapter(List<Doctor> doctorList, Context mContext) {
        super();
        this.doctorList = doctorList;
        this.mContext = mContext;

    }

    @Override
    public MyCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);

        return  new MyCardAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyCardAdapter.ViewHolder holder, int position) {
        final Doctor doctor = doctorList.get(position);
        holder.docName.setText(doctor.getDoctor_name());
        holder.docDegree.setText(doctor.getDoctor_degree());
        holder.docField.setText(doctor.getCaregory());

        holder.topLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TabActivity.class);
                intent.putExtra("doc_details", doctor);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docName;
        TextView docDegree;
        TextView docField;
        RelativeLayout topLayout;
        public View view;
        public ViewHolder(View itemView) {
            super(itemView);

            docName = (TextView)itemView.findViewById(R.id.doc_name_tv);
            docDegree = (TextView)itemView.findViewById(R.id.doc_degree);
            docField = (TextView)itemView.findViewById(R.id.doctor_field);
            topLayout = (RelativeLayout)itemView.findViewById(R.id.top_layout);

        }
    }
}
