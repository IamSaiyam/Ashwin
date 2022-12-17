package com.sih.dorec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapterPan extends RecyclerView.Adapter<ResultAdapterPan.ViewHolder>{
    ArrayList<AadharUtil> dataList;
    PanUtil selected;
    Context context;

    public ResultAdapterPan(ArrayList<AadharUtil> dataList, PanUtil selected, Context context) {
        this.dataList = dataList;
        this.context = context;
        this.selected = selected;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.result_item_view, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        TextView id, fName, lName, dob, father, address, percent;

        id = holder.itemView.findViewById(R.id.idDb2);
        fName = holder.itemView.findViewById(R.id.fNameDb2);
        lName = holder.itemView.findViewById(R.id.lNameDb2);
        dob = holder.itemView.findViewById(R.id.dobDb2);
        father = holder.itemView.findViewById(R.id.fatherDb2);
        address = holder.itemView.findViewById(R.id.addressDb2);
        percent = holder.itemView.findViewById(R.id.similarity);

        double similarityPercent = ((jaro_Winkler(selected.getFistName(), dataList.get(position).getFirstName())*100) + (jaro_Winkler(selected.getLastName(), dataList.get(position).getLastName())*100)
                + (jaro_Winkler(selected.getDob(), dataList.get(position).getDob())*100) + (jaro_Winkler(selected.getFatherName(), dataList.get(position).getFatherName())*100) + (jaro_Winkler(selected.getCity(), dataList.get(position).getCity())*100))/5;

        if(similarityPercent>74.0){
            percent.setText("Similarity Percent: " + similarityPercent + "%");
            id.setText(dataList.get(position).getAadhar());
            fName.setText(dataList.get(position).getFirstName());
            lName.setText(dataList.get(position).getLastName());
            dob.setText(dataList.get(position).getDob());
            father.setText(dataList.get(position).getFatherName());
            address.setText(dataList.get(position).getCity());
        }else{
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static double jaro_distance(String s1, String s2)
    {
        // If the strings are equal
        if (s1 == s2)
            return 1.0;

        // Length of two strings
        int len1 = s1.length(),
                len2 = s2.length();

        if (len1 == 0 || len2 == 0)
            return 0.0;

        // Maximum distance upto which matching
        // is allowed
        int max_dist = (int)Math.floor(Math.max(len1, len2) / 2) - 1;

        // Count of matches
        int match = 0;

        // Hash for matches
        int hash_s1[] = new int [s1.length()];
        int hash_s2[] = new int[s2.length()];

        // Traverse through the first string
        for (int i = 0; i < len1; i++)
        {

            // Check if there is any matches
            for (int j = Math.max(0, i - max_dist);
                 j < Math.min(len2, i + max_dist + 1); j++)

                // If there is a match
                if (s1.charAt(i) == s2.charAt(j) &&
                        hash_s2[j] == 0)
                {
                    hash_s1[i] = 1;
                    hash_s2[j] = 1;
                    match++;
                    break;
                }
        }

        // If there is no match
        if (match == 0)
            return 0.0;

        // Number of transpositions
        double t = 0;

        int point = 0;

        // Count number of occurrences
        // where two characters match but
        // there is a third matched character
        // in between the indices
        for (int i = 0; i < len1; i++)
            if (hash_s1[i] == 1)
            {

                // Find the next matched character
                // in second string
                while (hash_s2[point] == 0)
                    point++;

                if (s1.charAt(i) != s2.charAt(point++))
                    t++;
            }

        t /= 2;

        // Return the Jaro Similarity
        return (((double)match) / ((double)len1)
                + ((double)match) / ((double)len2)
                + ((double)match - t) / ((double)match))
                / 3.0;
    }

    // Jaro Winkler Similarity
    static double jaro_Winkler(String s1, String s2)
    {
        double jaro_dist = jaro_distance(s1, s2);

        // If the jaro Similarity is above a threshold
        if (jaro_dist > 0.4)
        {

            // Find the length of common prefix
            int prefix = 0;

            for (int i = 0;
                 i < Math.min(s1.length(), s2.length()); i++)
            {

                // If the characters match
                if (s1.charAt(i) == s2.charAt(i))
                    prefix++;

                    // Else break
                else
                    break;
            }

            // Maximum of 4 characters are allowed in prefix
            prefix = Math.min(4, prefix);

            // Calculate jaro winkler Similarity
            jaro_dist += 0.1 * prefix * (1 - jaro_dist);
        }
        return jaro_dist;
    }

}
