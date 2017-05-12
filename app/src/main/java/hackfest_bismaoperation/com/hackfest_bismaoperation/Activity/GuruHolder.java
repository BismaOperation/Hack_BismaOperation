package hackfest_bismaoperation.com.hackfest_bismaoperation.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hackfest_bismaoperation.com.hackfest_bismaoperation.R;

/**
 * Created by Ryan Bagus Susilo on 5/12/2017.
 */
public class GuruHolder extends RecyclerView.ViewHolder{

    TextView tvsub;
    TextView tvtit;
    TextView tvStatus;
    String tempalamat;
    RelativeLayout item;

    public GuruHolder(View view)
    {
        super(view);
        this.tvsub = (TextView) view.findViewById(R.id.tv_subtitle);
        this.tvtit = (TextView) view.findViewById(R.id.tv_title);
        this.tvStatus=(TextView) view.findViewById(R.id.tv_status);
        this.item = (RelativeLayout) view.findViewById(R.id.itemGuru);


    }
}
