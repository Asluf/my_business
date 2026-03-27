package com.example.my_business;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RemoteViews;
import es.antonborri.home_widget.HomeWidgetPlugin;

public class HomeWidgetExampleProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            // Get data from SharedPreferences (set from Flutter)
            SharedPreferences prefs = context.getSharedPreferences("HomeWidgetPreferences", Context.MODE_PRIVATE);
            String projectCount = prefs.getString("project_count", "0");
            String totalIncome = prefs.getString("total_income", "$0");
            String totalExpenses = prefs.getString("total_expenses", "$0");

            // Update the widget views
            views.setTextViewText(R.id.widget_title, "My Business");
            views.setTextViewText(R.id.project_count, "Projects: " + projectCount);
            views.setTextViewText(R.id.total_income, "Income: " + totalIncome);
            views.setTextViewText(R.id.total_expenses, "Expenses: " + totalExpenses);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}