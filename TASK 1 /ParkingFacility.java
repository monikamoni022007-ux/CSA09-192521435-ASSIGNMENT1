
public class ParkingFacility {

    // slots[floor][slot] stores vehicle number
    // null means the slot is free
    private final String[][] slots;

    // Constructor
    public ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];

        for (int f = 0; f < slotsPerFloor.length; f++) {
            slots[f] = new String[slotsPerFloor[f]];
        }
    }

    // Allocate the first available parking slot
    public int[] allocate(String vehicleNo) {

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {

                if (slots[f][s] == null) {
                    slots[f][s] = vehicleNo;

                    return new int[]{f, s};
                }
            }
        }

        return null;
    }

    // Release a parking slot
    public boolean release(int floor, int slot) {

        // Validate floor and slot
        if (floor < 0 || floor >= slots.length) {
            return false;
        }

        if (slot < 0 || slot >= slots[floor].length) {
            return false;
        }

        // Check whether slot is already free
        if (slots[floor][slot] == null) {
            return false;
        }

        // Release the slot
        slots[floor][slot] = null;

        return true;
    }

    // Main method
    public static void main(String[] args) {

        ParkingFacility p =
            new ParkingFacility(new int[]{2, 1});

        System.out.println(java.util.Arrays.toString(
            p.allocate("TN01AB1234")));

        System.out.println(java.util.Arrays.toString(
            p.allocate("TN02CD5678")));

        System.out.println(java.util.Arrays.toString(
            p.allocate("TN03EF9999")));

        System.out.println(p.allocate("TN04GH4444"));

        System.out.println(
            p.release(0, 1) + " " +
            p.release(0, 1) + " " +
            p.release(5, 0));

        System.out.println(java.util.Arrays.toString(
            p.allocate("TN04GH4444")));
    }
}
