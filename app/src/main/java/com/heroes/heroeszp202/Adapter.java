package com.heroes.heroeszp202;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String ENTRY="com.heroes.heroeszp202.Entry";

    private Context context;
    private LayoutInflater inflater;
    List<Hero> data;

    // create constructor to initialize context and data sent from SearchActivity
    public Adapter(Context context, List<Hero> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_heroes, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        Hero current = data.get(position);
        myHolder.textName.setText(current.getName());
        myHolder.textId.setText("ID: " + current.getId());
        myHolder.textPowerstats.setText(" Intelligence: " + current.getPowerstats());
        myHolder.textIntelligence.setText(" Strength:  " + current.getIntelligence());
        myHolder.textSpeed.setText(" Speed:  " + current.getSpeed());
        myHolder.textDurability.setText(" Durability:  " + current.getDurability());
        myHolder.textPower.setText(" Power:  " + current.getSpeed());



    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textName;
        TextView textId;
        TextView textPowerstats;
        TextView textIntelligence;
        TextView textStrength;
        TextView textSpeed;
        TextView textDurability;
        TextView textPower;






        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textId = (TextView) itemView.findViewById(R.id.textId);
            textPowerstats = (TextView) itemView.findViewById(R.id.textPowerstats);
            textIntelligence = (TextView) itemView.findViewById(R.id.textIntelligence);
            textStrength = (TextView) itemView.findViewById(R.id.textStrength);
            textSpeed = (TextView) itemView.findViewById(R.id.textSpeed);
            textDurability = (TextView) itemView.findViewById(R.id.textDurability);
            textPower = (TextView) itemView.findViewById(R.id.textPower);

            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            Intent goToNewEntryActivity = new Intent(context, NewEntryActivity.class);
            Hero hero = data.get(getAdapterPosition());

            goToNewEntryActivity.putExtra(ENTRY, hero);
            context.startActivity(goToNewEntryActivity);
        }
    }
}
