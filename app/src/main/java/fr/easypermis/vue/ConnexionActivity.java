package fr.easypermis.vue;

import android.animation.TimeAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.ConnectException;

import fr.easypermis.R;
import fr.easypermis.adapter.SliderAdapter;

public class ConnexionActivity extends AppCompatActivity {

    TextView alert ;
    private Handler handler = new Handler();
    private ViewPager viewPager ;
    private LinearLayout linearLayout ;
    private SliderAdapter sliderAdapter;
    private TextView[] nDots ;
    private Button dialogueForget;
    private Dialog dialog ;
    private EditText emailForget;
    EditText mdp, email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_activity);

        email = (EditText) findViewById(R.id.email);
        mdp = (EditText) findViewById(R.id.mdp);

        viewPager = (ViewPager) findViewById(R.id.slideViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.dots);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        setDotsIndicators(0);
        viewPager.addOnPageChangeListener(viewListener);

        dialogueForget = (Button) findViewById(R.id.btnForgeten);

        dialogueForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(ConnexionActivity.this);
                dialog.setContentView(R.layout.dialogue_layout);
                emailForget = (EditText) dialog.findViewById(R.id.emailMdpOublie);
                Button btnMdpDialogue = (Button) dialog.findViewById(R.id.mdpBtnOublier);

                btnMdpDialogue.setEnabled(true);
                emailForget.setEnabled(true);
                dialog.create();
                dialog.show();
                btnMdpDialogue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String email = emailForget.getText().toString();

                        /** ICI MODIFICATION MDP OUBLIÉ **/
                    }
                });

            }
        });
    }

    public void show(final View v){

            /*alert = (TextView) findViewById(R.id.alert);
            alert.setVisibility(v.VISIBLE);

            final Intent intent = new Intent(this, ConnexionActivity.class);
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    alert.setVisibility(v.INVISIBLE);
                }
            }, 4000);*/

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

            /***
             *  ICI FAUT FAIRE UNE VERIFICATION DU LOGIN / MDP
             * */


    }

    public void setDotsIndicators(int position){

        nDots = new TextView[3];
        linearLayout.removeAllViews();
        for(int i = 0; i < nDots.length; i++){

            nDots[i] = new TextView( this);
            nDots[i].setText(Html.fromHtml("&#8226;"));
            nDots[i].setTextSize(35);
            nDots[i].setTextColor(getResources().getColor(R.color.colorAccent));

            linearLayout.addView(nDots[i]);
        }

        if(nDots.length > 0){

            nDots[position].setTextColor(getResources().getColor(R.color.colorSlideAfter));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {

            setDotsIndicators(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
