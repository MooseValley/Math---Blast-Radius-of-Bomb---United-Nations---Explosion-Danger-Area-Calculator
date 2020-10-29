/*
United Nations - Explosion danger area (IMAS)
https://www.un.org/disarmament/un-saferguard/explosion-danger-area/

Moose: Examining the web page, the JavaScript calculations are trivially easy !

The calculations recommend the public stay at least 35 Km away from the
20 kilo-ton Trinity Atomic Bomb explosion at Los Alamos !!

I think that's a decent distance !
Don't know if I'd want to be any closer ...

Moose


*** Sample Output:

----------------------------------------------------------
United Nations - Explosion danger area (IMAS)
----------------------------------------------------------

Note: The All Up Weight (AUW) is the total weight of the munition, or munitions, including packaging and palletisation.

For an explosion with an 'All Up Weight (AUW)' of:      1,200 Kg
the following Danger Area's apply:
* Fragmenting munitions when public access is possible to the demolition range area:      2,068 m
* Fragmenting munitions when public access is denied to the demolition range area:        1,448 m
* For bare exposed explosive only:                                                        1,382 m


----------------------------------------------------------
United Nations - Explosion danger area (IMAS)
----------------------------------------------------------

Note: The All Up Weight (AUW) is the total weight of the munition, or munitions, including packaging and palletisation.

For an explosion with an 'All Up Weight (AUW)' of: 20,000,000 Kg
the following Danger Area's apply:
* Fragmenting munitions when public access is possible to the demolition range area:     10,446 m
* Fragmenting munitions when public access is denied to the demolition range area:        7,316 m
* For bare exposed explosive only:                                                       35,288 m

Press any key to continue . . .

*/
public class BlastRadiusUNExplosionDangerAreaCalculator
{
   public static double calculateSafetyDistancePublic (double weightKg)
   {
      // Fragmenting munitions when public access is possible to the demolition range area:
      double distance = 634.0 * Math.pow (weightKg, 0.1666667);

      return Math.round (distance + 1.0);
   }

   public static double calculateSafetyDistanceNotPublic (double weightKg)
   {
      // Fragmenting munitions when public access is denied to the demolition range area:
      double distance = 444.0 * Math.pow (weightKg, 0.1666667);

      return Math.round (distance + 1.0);
   }

   public static double calculateSafetyDistanceBare (double weightKg)
   {
      // For bare exposed explosive only
      double distance = 130.0 * Math.pow(weightKg, 0.3333333);

      return Math.round (distance + 1.0);
   }

   public static void displayExplosionDangers (double weightKg)
   {
      System.out.println ();
      System.out.println ("----------------------------------------------------------");
      System.out.println ("United Nations - Explosion danger area (IMAS)");
      System.out.println ("----------------------------------------------------------");

      System.out.println ();
      System.out.println ("Note: The All Up Weight (AUW) is the total weight of the munition, or munitions, including packaging and palletisation.");

      System.out.println ();
      System.out.println ("For an explosion with an 'All Up Weight (AUW)' of: " +
                           String.format ("%,10.0f", weightKg) + " Kg");

      System.out.println ("the following Danger Area's apply:");

      System.out.println ("* Fragmenting munitions when public access is possible to the demolition range area: " +
                           String.format ("%,10.0f", calculateSafetyDistancePublic (weightKg) ) + " m");

      System.out.println ("* Fragmenting munitions when public access is denied to the demolition range area:   " +
                           String.format ("%,10.0f", calculateSafetyDistanceNotPublic (weightKg) ) + " m");

      System.out.println ("* For bare exposed explosive only:                                                   " +
                           String.format ("%,10.0f", calculateSafetyDistanceBare (weightKg) ) + " m");

      System.out.println ();
   }

   public static void main (String[] args)
   {
      displayExplosionDangers (1200.0); // 1200 Kg of TNT

      displayExplosionDangers (20_000_000.0); // 20 Kilo-tons of TNT.  20,000,000.  i.e. Trinity Atomic Bomb at Los Alamos
   }
}