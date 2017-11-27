package com.example.anggarisky.pandalogin.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Usuario;
import com.example.anggarisky.pandalogin.principal.MainActivity;
import com.example.anggarisky.pandalogin.telas.AreaUsuario;
import com.example.anggarisky.pandalogin.telas.TelaCompeticoes;
import com.example.anggarisky.pandalogin.telas.TelaEquipes;
import com.example.anggarisky.pandalogin.telas.TelaRanking;

public class MainNavigationMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_navigation_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initApp();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        selectedMenuScreen(R.id.nav_principal);

    }

    private void initApp() {
        fillNavigationView();


    }

    //preenche informações do usuário
    private void fillNavigationView() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //TextView tv_content = (TextView)findViewById(R.id.tv_menu_content);

        it = getIntent();
        long codigo = -1;
        if(it !=null) {
            codigo = it.getLongExtra("codigo", -1);
        }

        if(codigo != -1){
            View headerView = navigationView.getHeaderView(0);

            TextView tv_tittle = (TextView)headerView.findViewById(R.id.tv_menu_tittle);
            //TextView tv_content = (TextView)headerView.findViewById(R.id.tv_menu_content);
            if(tv_tittle!=null ){//&& tv_content!=null
                Usuario u = Usuario.findById(Usuario.class,codigo);
                tv_tittle.setText(u.getNome());
                //tv_content.setText(u.get);
            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            it = new Intent(MainNavigationMenu.this,MainActivity.class);
            startActivity(it);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void selectedMenuScreen(int id){

        Fragment fragment = null;

        if (id == R.id.nav_principal) {
            fragment = new AreaUsuario();
        } else if (id == R.id.nav_equipes) {
            fragment = new TelaEquipes();
        } else if (id == R.id.nav_competicoes) {
            fragment = new TelaCompeticoes();//Trabalhando...
        }else if (id == R.id.nav_ranking){
            fragment = new TelaRanking();
        }


        if(fragment!= null ){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area,fragment);
            ft.commit();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        selectedMenuScreen(id);

        return true;
    }


}
