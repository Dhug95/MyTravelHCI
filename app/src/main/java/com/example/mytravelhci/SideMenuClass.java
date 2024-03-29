package com.example.mytravelhci;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.example.mytravelhci.activity.Currency;
import com.example.mytravelhci.activity.Documentation;
import com.example.mytravelhci.activity.LoggedHomeActivity;
import com.example.mytravelhci.activity.NotLoggedHomeActivity;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class SideMenuClass {

    public Drawer drawer;

    public SideMenuClass(final Activity activity) {
        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withTextColor(Color.parseColor("#FFFFFF"))
                .withHeaderBackground(R.drawable.bg_gradient_nocorn)
                .addProfiles(
                        new ProfileDrawerItem().withName("Keanu Reeves").withEmail("keanu.reeves@gmail.com")
                                .withIcon(activity.getResources().getDrawable(R.drawable.keanu))
                )
                .withSelectionListEnabledForSingleProfile(false)
                .build();

        // Questa riga non serve a un cazzo

        Drawable home_icn = activity.getDrawable(R.drawable.ic_home_side_24dp);
        SecondaryDrawerItem home = new SecondaryDrawerItem().withIdentifier(1).withName("Home")
                .withIcon(home_icn).withSelectable(false);

        Drawable tickets_icn = activity.getDrawable(R.drawable.ic_ticket_side_24dp);
        SecondaryDrawerItem tickets = new SecondaryDrawerItem().withIdentifier(2).withName("Tickets")
                .withIcon(tickets_icn).withSelectable(false);

        Drawable accommodation_icn = activity.getDrawable(R.drawable.ic_accommodation_side_24dp);
        SecondaryDrawerItem accommodation = new SecondaryDrawerItem().withIdentifier(3).withName("Accommodation")
                .withIcon(accommodation_icn).withSelectable(false);

        Drawable money_icn = activity.getDrawable(R.drawable.ic_money_side_24dp);
        SecondaryDrawerItem money = new SecondaryDrawerItem().withIdentifier(4).withName("Currency conversion")
                .withIcon(money_icn).withSelectable(false);

        Drawable profile_icn = activity.getDrawable(R.drawable.ic_person_side_24dp);
        SecondaryDrawerItem profile = new SecondaryDrawerItem().withIdentifier(5).withName("My profile")
                .withIcon(profile_icn).withSelectable(false);

        Drawable trips_icn = activity.getDrawable(R.drawable.ic_card_travel_side_24dp);
        SecondaryDrawerItem trips = new SecondaryDrawerItem().withIdentifier(6).withName("My trips")
                .withIcon(trips_icn).withSelectable(false);

        Drawable logout_icn = activity.getDrawable(R.drawable.ic_exit_to_app_side_24dp);
        SecondaryDrawerItem logout = new SecondaryDrawerItem().withIdentifier(7).withName("Logout")
                .withIcon(logout_icn).withSelectable(false);

        Drawable help_icn = activity.getDrawable(R.drawable.ic_help_side_24dp);
        SecondaryDrawerItem help = new SecondaryDrawerItem().withIdentifier(8).withName("Help")
                .withIcon(help_icn).withSelectable(false);

        Drawable contact_icn = activity.getDrawable(R.drawable.ic_email_side_24dp);
        SecondaryDrawerItem contact = new SecondaryDrawerItem().withIdentifier(9).withName("Contact us")
                .withIcon(contact_icn).withSelectable(false);

        drawer = new DrawerBuilder()
                .withActivity(activity)
                .withSelectedItem(-1)
                .addDrawerItems(
                        home,
                        tickets,
                        accommodation,
                        money,
                        new DividerDrawerItem(),
                        profile,
                        trips,
                        logout,
                        new DividerDrawerItem(),
                        help,
                        contact
                )
                .withAccountHeader(headerResult)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Log.i("HAI PREMUTO NEL DRAWER: ", String.valueOf(position));
                        switch (position) {
                            case 1: {
                                Intent intent = new Intent(activity, LoggedHomeActivity.class);
                                intent.putExtra("frag_to_set", "home");
                                activity.startActivity(intent);
                                break;
                            }
                            case 4: {
                                Intent intent = new Intent(activity, Currency.class);
                                activity.startActivity(intent);
                                break;
                            }
                            case 6: {
                                Intent intent = new Intent(activity, LoggedHomeActivity.class);
                                intent.putExtra("frag_to_set", "profile");
                                activity.startActivity(intent);
                                break;
                            }
                            case 7: {
                                Intent intent = new Intent(activity, LoggedHomeActivity.class);
                                intent.putExtra("frag_to_set", "trips");
                                activity.startActivity(intent);
                                break;
                            }
                            case 8: {
                                Intent intent = new Intent(activity, NotLoggedHomeActivity.class);
                                intent.putExtra("logged_out", true);
                                activity.startActivity(intent);
                                break;
                            }

                            case 10:{
                                Intent intent = new Intent(activity, Documentation.class);
                                activity.startActivity(intent);
                                break;
                            }

                            case 11: {
                                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                        "mailto","admin@gmail.com", null));
                                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MyTravel Help");
                                emailIntent.putExtra(Intent.EXTRA_EMAIL, "");
                                activity.startActivity(Intent.createChooser(emailIntent, "Send email..."));

                            }

                            default: {
                                break;
                            }
                        }
                        return false;
                    }
                })
                .build();
    }
}
