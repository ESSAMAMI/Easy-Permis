package fr.easypermis.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import fr.easypermis.Fragment.ArretStationnementFragment;
import fr.easypermis.Fragment.CroisementFragment;
import fr.easypermis.Fragment.DepassementFragment;
import fr.easypermis.Fragment.DiverseFragment;
import fr.easypermis.Fragment.EcoConduiteFragment;
import fr.easypermis.Fragment.FeuxFragment;
import fr.easypermis.Fragment.KlaxonFragment;
import fr.easypermis.Fragment.MecaniqueFragment;
import fr.easypermis.Fragment.PrioriteFragment;
import fr.easypermis.Fragment.RegleCerculationFragment;
import fr.easypermis.R;
import fr.easypermis.adapter.ViewPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        /** ICI THEMEM PAR CLIENT **/

        viewPagerAdapter.addFragment(new DepassementFragment(), "Dépassement");
        viewPagerAdapter.addFragment(new DiverseFragment(), "Notions diverses");
        viewPagerAdapter.addFragment(new PrioriteFragment(), "Priorité");
        viewPagerAdapter.addFragment(new CroisementFragment(), "Croisement");
        viewPagerAdapter.addFragment(new  ArretStationnementFragment(), "Arrêt et stationnement");
        viewPagerAdapter.addFragment(new FeuxFragment(), "Feux");
        viewPagerAdapter.addFragment(new RegleCerculationFragment(), "Régle de circulation");
        viewPagerAdapter.addFragment(new MecaniqueFragment(), "Mécanique");
        viewPagerAdapter.addFragment(new EcoConduiteFragment(), "Eco conduite");
        viewPagerAdapter.addFragment(new KlaxonFragment(), "Klaxon");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        /** ICI SESSION **/

        TextView nom = (TextView) findViewById(R.id.nom);
        nom.setText("Bonjour Hamza");

    }

    public void test(){

        Intent intent = new Intent(HomeActivity.this, TestVideoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
