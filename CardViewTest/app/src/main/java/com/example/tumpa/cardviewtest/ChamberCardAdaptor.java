package com.example.tumpa.cardviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tumpa on 1/10/2016.
 */
public class ChamberCardAdaptor extends RecyclerView.Adapter<ChamberCardAdaptor.ViewHolder>{
    List <Chamber> chamberList;
    Context mContext;
    public ChamberCardAdaptor(List <Chamber> chamberList,Context mContext ){
        super();
        this.chamberList = chamberList;
        this.mContext = mContext;

    }
    @Override
    public ChamberCardAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chamber_c_view, parent, false);
        return new ChamberCardAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChamberCardAdaptor.ViewHolder holder, int position) {
        final Chamber chamber = chamberList.get(position);
        holder.address.setText(chamber.getChamberAddress());
        holder.appointment.setText(chamber.getAppointmentOn());
        holder.fee.setText(chamber.getVisitingFee());
        holder.arrive.setText(chamber.getArrivalTime());
        holder.leave.setText(chamber.getLeaveTime());

    }

    @Override
    public int getItemCount() {
        return chamberList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView appointment;
        TextView fee;
        TextView arrive;
        TextView leave;
        public ViewHolder(View v) {
            super(v);
            address = (TextView) v.findViewById(R.id.address);
            appointment = (TextView) v.findViewById(R.id.appointment);
            fee = (TextView) v.findViewById(R.id.visiting_fees);
            arrive = (TextView) v.findViewById(R.id.arrival_time);
            leave = (TextView) v.findViewById(R.id.leave_time);
        }
    }
}
