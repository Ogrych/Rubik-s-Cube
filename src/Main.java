//import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Cube cube = new Cube();
		System.out.println(cube.toString() + "\n");
		
		//System.out.println(cube.randomScramble(25));
		//cube.scramble("D' R' F2 F L' U U' U2 R D L' B' F L U2 U' B' U2 R B2 R' D2 L2 B F"); 

		System.out.println(cube.determine_cross_set_elements());
		System.out.println(cube.determine_cross_correct_elements(cube.determine_cross_set_elements()));
		System.out.println(cube.noInput_cross_determine_wrong_colors());
		
		cube.cross_rename_white_edges();
		cube.cross_determine_good_pieces();
		cube.cross_determine_neutral_pieces();
		cube.cross_determine_bad_pieces();
		cube.cross_determine_very_bad_pieces();
		cube.cross_determine_misplaced_pieces();
		
		

		System.out.println(cube.toString() + "\n");
		System.out.println(cube.toString_backup() + "\n");

	
	}

}
