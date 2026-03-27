import 'package:flutter/material.dart';
import 'package:my_business/screens/DashboardScreen.dart';
import 'themes/themes.dart';
import 'package:home_widget/home_widget.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  HomeWidget.registerInteractivityCallback(backgroundCallback);
  runApp(const MyApp());
}

Future<void> backgroundCallback(Uri? uri) async {
  if (uri?.host == 'update') {
    // Handle widget tap - could navigate to specific screen
  }
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'MyBusinessTracker',
      debugShowCheckedModeBanner: false,
      theme: sunnyCitrusTheme,
      darkTheme: darkModeTheme,
      themeMode: ThemeMode.system,
      home: const DashboardScreen(),
    );
  }
}
