package com.example.mytravelhci;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class SideMenuClass {

    public SideMenuClass(Activity activity) {
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

        Drawable home_icn = activity.getDrawable(R.drawable.ic_home_side_24dp);
        SecondaryDrawerItem home = new SecondaryDrawerItem().withIdentifier(0).withName("Home")
                .withIcon(home_icn);

        Drawable tickets_icn = activity.getDrawable(R.drawable.ic_ticket_side_24dp);
        SecondaryDrawerItem tickets = new SecondaryDrawerItem().withIdentifier(1).withName("Tickets")
                .withIcon(tickets_icn);

        Drawable accommodation_icn = activity.getDrawable(R.drawable.ic_accommodation_side_24dp);
        SecondaryDrawerItem accommodation = new SecondaryDrawerItem().withIdentifier(2).withName("Accommodation")
                .withIcon(accommodation_icn);

        Drawable money_icn = activity.getDrawable(R.drawable.ic_money_side_24dp);
        SecondaryDrawerItem money = new SecondaryDrawerItem().withIdentifier(3).withName("Currency conversion")
                .withIcon(money_icn);

        Drawable profile_icn = activity.getDrawable(R.drawable.ic_person_side_24dp);
        SecondaryDrawerItem profile = new SecondaryDrawerItem().withIdentifier(4).withName("My profile")
                .withIcon(profile_icn);

        Drawable trips_icn = activity.getDrawable(R.drawable.ic_card_travel_side_24dp);
        SecondaryDrawerItem trips = new SecondaryDrawerItem().withIdentifier(5).withName("My trips")
                .withIcon(trips_icn);

        Drawable logout_icn = activity.getDrawable(R.drawable.ic_exit_to_app_side_24dp);
        SecondaryDrawerItem logout = new SecondaryDrawerItem().withIdentifier(6).withName("Logout")
                .withIcon(logout_icn);

        Drawable help_icn = activity.getDrawable(R.drawable.ic_help_side_24dp);
        SecondaryDrawerItem help = new SecondaryDrawerItem().withIdentifier(7).withName("Help")
                .withIcon(help_icn);

        Drawable contact_icn = activity.getDrawable(R.drawable.ic_email_side_24dp);
        SecondaryDrawerItem contact = new SecondaryDrawerItem().withIdentifier(8).withName("Contact us")
                .withIcon(contact_icn);

        new DrawerBuilder()
                .withActivity(activity)
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
                .build();
    }
}
