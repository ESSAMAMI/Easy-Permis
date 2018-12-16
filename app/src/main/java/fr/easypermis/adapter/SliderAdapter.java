package fr.easypermis.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fr.easypermis.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }
    //Liste des images

    public int[] listImages = {

            R.drawable.eat,
            R.drawable.drink,
            R.drawable.coding
    };
    public String[] listTitre = {

            "ACCESSIBLE",
            "FLEXIBLE",
            "STAGE DE CODE"
    };

    public String[] listDesc = {

            "Située en face de la gare de LA FRETTE / MONTIGNY (Ligne J) et de nombreux arrêts de bus",
            "8h de cours de code par jours 10h de cours de conduite par jours.",
            "Pensez à réserver dés maintenant!"
    };

    @Override
    public int getCount() {
        return listTitre.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideImage);
        TextView slideHedding = (TextView) view.findViewById(R.id.slideheading);
        TextView slideDesc = (TextView) view.findViewById(R.id.slideDesc);

        slideImageView.setImageResource(listImages[position]);
        slideHedding.setText(listTitre[position]);
        slideDesc.setText(listDesc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
