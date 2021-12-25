import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cube {
	ArrayList<String> F = new ArrayList<String>();
	ArrayList<String> B = new ArrayList<String>();
	ArrayList<String> L = new ArrayList<String>();
	ArrayList<String> R = new ArrayList<String>();
	ArrayList<String> U = new ArrayList<String>();
	ArrayList<String> D = new ArrayList<String>();
	
	ArrayList<String> F_backup = new ArrayList<String>();
	ArrayList<String> B_backup = new ArrayList<String>();
	ArrayList<String> L_backup = new ArrayList<String>();
	ArrayList<String> R_backup = new ArrayList<String>();
	ArrayList<String> U_backup = new ArrayList<String>();
	ArrayList<String> D_backup = new ArrayList<String>();
	boolean CROSS = false;
	boolean F2L = false;
	boolean OLL = false;
	boolean PLL = false;
	
	Cube () {
		for (int i = 0; i < 9; i++) {
			this.F.add("g");
			this.B.add("b");
			this.L.add("r");
			this.R.add("o");
			this.U.add("y");
			this.D.add("w");
			
		}
		for (int i = 0; i < 9; i++) {
			this.F_backup.add("g");
			this.B_backup.add("b");
			this.L_backup.add("r");
			this.R_backup.add("o");
			this.U_backup.add("y");
			this.D_backup.add("w");
			
		}
	}
	public String toString() {
		return "F: " + this.F + "\n" + "B: " + this.B + "\n" + "L: " + this.L + "\n" + 
				"R: " + this.R + "\n" + "U: " + this.U + "\n" + "D: " + this.D;
	}
	public String toString_backup() {
		return "F_backup: " + this.F_backup + "\n" + "B_backup: " + this.B_backup + "\n" + "L_backup: " + this.L_backup + "\n" + 
				"R_backup: " + this.R_backup + "\n" + "U_backup: " + this.U_backup + "\n" + "D_backup: " + this.D_backup;
	}
	public void sideBackup() {
		for (int i = 0; i < 9; i++) {
			this.F_backup.set(i, this.F.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.B_backup.set(i, this.B.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.L_backup.set(i, this.L.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.R_backup.set(i, this.R.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.U_backup.set(i, this.U.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.D_backup.set(i, this.D.get(i));
		}
		/*this.F_backup = this.F;
		this.B_backup = this.B;
		this.L_backup = this.L;
		this.R_backup = this.R;
		this.U_backup = this.U;
		this.D_backup = this.D;*/
	}
	public void sideRecover() {
		for (int i = 0; i < 9; i++) {
			this.F.set(i, this.F_backup.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.B.set(i, this.B_backup.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.L.set(i, this.L_backup.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.R.set(i, this.R_backup.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.U.set(i, this.U_backup.get(i));
		}
		for (int i = 0; i < 9; i++) {
			this.D.set(i, this.D_backup.get(i));
		}
	}
	public String[] makeTemp(ArrayList<String> al) {
		int size = al.size();
		String[] temp = new String[size];
		for(int i = 0; i < size; i++) {
			temp[i] = al.get(i);
		}
		return temp;
	}
	public void swap(ArrayList<String> side1, int[] side1_elem,
			ArrayList<String> side2, int[] side2_elem,
			ArrayList<String> side3, int[] side3_elem,
			ArrayList<String> side4, int[] side4_elem,
			ArrayList<String> side5, int[] side5_new_order)
	{
		int hManyElements = side1_elem.length;
		String[] temp1 = makeTemp(side2);
		for (int i = 0; i < hManyElements; i++) {
			side2.set(side2_elem[i], side1.get(side1_elem[i]));
		}
		String[] temp2 = makeTemp(side3);
		for (int i = 0; i < hManyElements; i++) {
			side3.set(side3_elem[i], temp1[side2_elem[i]]);
		}
		String[] temp3 = makeTemp(side4);
		for (int i = 0; i < hManyElements; i++) {
			side4.set(side4_elem[i], temp2[side3_elem[i]]);
		}
		for (int i = 0; i < hManyElements; i++) {
			side1.set(side1_elem[i], temp3[side4_elem[i]]);
		}
		String[] temp4 = makeTemp(side5);
		for (int i = 0; i < 9; i++) {
			side5.set(i, temp4[side5_new_order[i]]);
		}
	}
	
	public void swap(ArrayList<String> side1, int[] side1_elem,
			ArrayList<String> side2, int[] side2_elem,
			ArrayList<String> side3, int[] side3_elem,
			ArrayList<String> side4, int[] side4_elem)
	{
		int hManyElements = side1_elem.length;
		String[] temp1 = makeTemp(side2);
		for (int i = 0; i < hManyElements; i++) {
			side2.set(side2_elem[i], side1.get(side1_elem[i]));
		}
		String[] temp2 = makeTemp(side3);
		for (int i = 0; i < hManyElements; i++) {
			side3.set(side3_elem[i], temp1[side2_elem[i]]);
		}
		String[] temp3 = makeTemp(side4);
		for (int i = 0; i < hManyElements; i++) {
			side4.set(side4_elem[i], temp2[side3_elem[i]]);
		}
		for (int i = 0; i < hManyElements; i++) {
			side1.set(side1_elem[i], temp3[side4_elem[i]]);
		}

	}
	
	public void R() {
		int[] side1_elements = {2, 5, 8};
		int[] side2_elements = {2, 5, 8};
		int[] side3_elements = {6, 3, 0};
		int[] side4_elements = {2, 5, 8};
		int[] side5_new_order = {6, 3, 0, 7, 4, 1, 8, 5, 2};
		
		swap(this.F, side1_elements,
			this.U, side2_elements,
			this.B, side3_elements,
			this.D, side4_elements,
			this.R, side5_new_order);
	}
	public void R_() {
		int[] side1_elements = {2, 5, 8};
		int[] side2_elements = {2, 5, 8};
		int[] side3_elements = {6, 3, 0};
		int[] side4_elements = {2, 5, 8};
		int[] side5_new_order = {2, 5, 8, 1, 4, 7, 0, 3, 6};
		
		swap(this.F, side1_elements,
			this.D, side2_elements,
			this.B, side3_elements,
			this.U, side4_elements,
			this.R, side5_new_order);
	}
	public void R2() {
		R();
		R();
	}
	public void L() {
		int[] side1_elements = {0, 3, 6};
		int[] side2_elements = {0, 3, 6};
		int[] side3_elements = {8, 5, 2};
		int[] side4_elements = {0, 3, 6};
		int[] side5_new_order = {6, 3, 0, 7, 4, 1, 8, 5, 2};
		
		swap(this.F, side1_elements,
			this.D, side2_elements,
			this.B, side3_elements,
			this.U, side4_elements,
			this.L, side5_new_order);
	}
	public void L_() {
		int[] side1_elements = {0, 3, 6};
		int[] side2_elements = {0, 3, 6};
		int[] side3_elements = {8, 5, 2};
		int[] side4_elements = {0, 3, 6};
		int[] side5_new_order = {2, 5, 8, 1, 4, 7, 0, 3, 6};
		
		swap(this.F, side1_elements,
			this.U, side2_elements,
			this.B, side3_elements,
			this.D, side4_elements,
			this.L, side5_new_order);
	}
	public void L2() {
		L();
		L();
	}
	public void U() {
		int[] side1_elements = {0, 1, 2};
		int[] side2_elements = {0, 1, 2};
		int[] side3_elements = {0, 1, 2};
		int[] side4_elements = {0, 1, 2};
		int[] side5_new_order = {6, 3, 0, 7, 4, 1, 8, 5, 2};
		
		swap(this.F, side1_elements,
			this.L, side2_elements,
			this.B, side3_elements,
			this.R, side4_elements,
			this.U, side5_new_order);
	}
	public void U_() {
		int[] side1_elements = {0, 1, 2};
		int[] side2_elements = {0, 1, 2};
		int[] side3_elements = {0, 1, 2};
		int[] side4_elements = {0, 1, 2};
		int[] side5_new_order = {2, 5, 8, 1, 4, 7, 0, 3, 6};
		
		swap(this.F, side1_elements,
			this.R, side2_elements,
			this.B, side3_elements,
			this.L, side4_elements,
			this.U, side5_new_order);
	}
	public void U2() {
		U();
		U();
	}
	public void F() {
		int[] side1_elements = {6, 7, 8};
		int[] side2_elements = {0, 3, 6};
		int[] side3_elements = {2, 1, 0};
		int[] side4_elements = {8, 5, 2};
		int[] side5_new_order = {6, 3, 0, 7, 4, 1, 8, 5, 2};
		
		swap(this.U, side1_elements,
			this.R, side2_elements,
			this.D, side3_elements,
			this.L, side4_elements,
			this.F, side5_new_order);
	}
	public void F_() {
		int[] side1_elements = {6, 7, 8};
		int[] side2_elements = {8, 5, 2};
		int[] side3_elements = {2, 1, 0};
		int[] side4_elements = {0, 3, 6};
		int[] side5_new_order = {2, 5, 8, 1, 4, 7, 0, 3, 6};
		
		swap(this.U, side1_elements,
			this.L, side2_elements,
			this.D, side3_elements,
			this.R, side4_elements,
			this.F, side5_new_order);
	}
	public void F2() {
		F();
		F();
	}
	public void B() {
		int[] side1_elements = {0, 1, 2};
		int[] side2_elements = {6, 3, 0};
		int[] side3_elements = {8, 7, 6};
		int[] side4_elements = {2, 5, 8};
		int[] side5_new_order = {6, 3, 0, 7, 4, 1, 8, 5, 2};
		
		swap(this.U, side1_elements,
			this.L, side2_elements,
			this.D, side3_elements,
			this.R, side4_elements,
			this.B, side5_new_order);
	}
	public void B_() {
		int[] side1_elements = {0, 1, 2};
		int[] side2_elements = {2, 5, 8};
		int[] side3_elements = {8, 7, 6};
		int[] side4_elements = {6, 3, 0};
		
		int[] side5_new_order = {2, 5, 8, 1, 4, 7, 0, 3, 6};
		
		swap(this.U, side1_elements,
			this.R, side2_elements,
			this.D, side3_elements,
			this.L, side4_elements,
			this.B, side5_new_order);
	}
	public void B2() {
		B();
		B();
	}
	public void D() {
		int[] side1_elements = {6, 7, 8};
		int[] side2_elements = {6, 7, 8};
		int[] side3_elements = {6, 7, 8};
		int[] side4_elements = {6, 7, 8};
		
		int[] side5_new_order = {6, 3, 0, 7, 4, 1, 8, 5, 2};
		
		swap(this.F, side1_elements,
			this.R, side2_elements,
			this.B, side3_elements,
			this.L, side4_elements,
			this.D, side5_new_order);
	}
	public void D_() {
		int[] side1_elements = {6, 7, 8};
		int[] side2_elements = {6, 7, 8};
		int[] side3_elements = {6, 7, 8};
		int[] side4_elements = {6, 7, 8};
		
		int[] side5_new_order = {2, 5, 8, 1, 4, 7, 0, 3, 6};
		
		swap(this.F, side1_elements,
			this.L, side2_elements,
			this.B, side3_elements,
			this.R, side4_elements,
			this.D, side5_new_order);
	}
	public void D2() {
		D();
		D();
	}
	
	public void S() {
		int[] side1_elements = {3, 4, 5};
		int[] side2_elements = {1, 4, 7};
		int[] side3_elements = {5, 4, 3};
		int[] side4_elements = {7, 4, 1};
		
		swap(this.U, side1_elements,
			this.R, side2_elements,
			this.D, side3_elements,
			this.L, side4_elements);
	}
	
	public void S_() {
		int[] side1_elements = {3, 4, 5};
		int[] side2_elements = {7, 4, 1};
		int[] side3_elements = {5, 4, 3};
		int[] side4_elements = {1, 4, 7};
		
		swap(this.U, side1_elements,
			this.L, side2_elements,
			this.D, side3_elements,
			this.R, side4_elements);
		
	}
	public void S2() {
		S();
		S();
	}
	
	public void E() {
		int[] side1_elements = {3, 4, 5};
		int[] side2_elements = {3, 4, 5};
		int[] side3_elements = {3, 4, 5};
		int[] side4_elements = {3, 4, 5};
		
		swap(this.F, side1_elements,
			this.L, side2_elements,
			this.B, side3_elements,
			this.R, side4_elements);
	}
	
	public void E_() {
		int[] side1_elements = {3, 4, 5};
		int[] side2_elements = {3, 4, 5};
		int[] side3_elements = {3, 4, 5};
		int[] side4_elements = {3, 4, 5};
		
		swap(this.F, side1_elements,
			this.R, side2_elements,
			this.B, side3_elements,
			this.L, side4_elements);
	}
	
	public void E2() {
		E();
		E();
	}
	
	public void M() {
		int[] side1_elements = {1, 4, 7};
		int[] side2_elements = {1, 4, 7};
		int[] side3_elements = {1, 4, 7};
		int[] side4_elements = {7, 4, 1};
		
		swap(this.U, side1_elements,
			this.F, side2_elements,
			this.D, side3_elements,
			this.B, side4_elements);
	}
	
	public void M_() {
		int[] side1_elements = {1, 4, 7};
		int[] side2_elements = {7, 4, 1};
		int[] side3_elements = {1, 4, 7};
		int[] side4_elements = {1, 4, 7};
		
		swap(this.U, side1_elements,
			this.B, side2_elements,
			this.D, side3_elements,
			this.F, side4_elements);
	}
	
	public void M2() {
		M();
		M();
	}
	
	public void Fw() {
		F();
		S();
	}
	public void Fw_() {
		F_();
		S_();
	}
	public void Fw2() {
		Fw();
		Fw();
	}
	
	public void Bw() {
		B();
		S_();
	}
	public void Bw_() {
		B_();
		S();
	}
	public void Bw2() {
		Bw();
		Bw();
	}
	
	public void Lw() {
		L();
		M();
	}
	public void Lw_() {
		L_();
		M_();
	}
	public void Lw2() {
		Lw();
		Lw();
	}
	
	public void Rw() {
		R();
		M_();
	}
	public void Rw_() {
		R_();
		M();
	}
	public void Rw2() {
		Rw();
		Rw();
	}
	
	public void Uw() {
		U();
		E();
	}
	public void Uw_() {
		U_();
		E_();
	}
	public void Uw2() {
		Uw();
		Uw();
	}
	
	public void Dw() {
		D();
		E_();
	}
	public void Dw_() {
		D_();
		E();
	}
	public void Dw2() {
		Dw();
		Dw();
	}
	
	public void x() {
		Rw();
		L_();
	}
	public void x_() {
		Rw_();
		L();
	}
	public void x2() {
		x();
		x();
	}
	
	public void y() {
		Uw();
		D_();
	}
	public void y_() {
		Uw_();
		D();
	}
	public void y2() {
		y();
		y();
	}
	
	public void z() {
		Fw();
		B_();
	}
	public void z_() {
		Fw_();
		B();
	}
	public void z2() {
		z();
		z();
	}
	public void scramble(String scr) {
		z2();
		String[] scramble = scr.split(" ");
		for (String i : scramble) {
			i = i.toLowerCase();
			switch(i) {
				case "u":
					U();
					break;
				case "u'":
					U_();
					break;
				case "u2":
					U2();
					break;
				case "d":
					D();
					break;
				case "d'":
					D_();
					break;
				case "d2":
					D2();
					break;
				case "b":
					B();
					break;
				case "b'":
					B_();
					break;
				case "b2":
					B2();
					break;
				case "f":
					F();
					break;
				case "f'":
					F_();
					break;
				case "f2":
					F2();
					break;
				case "r":
					R();
					break;
				case "r'":
					R_();
					break;
				case "r2":
					R2();
					break;
				case "l":
					L();
					break;
				case "l'":
					L_();
					break;
				case "l2":
					L2();
					break;
			}
		}
		z2();
	}
	
	public String randomScramble(int moves) {
		String query = "";
		Random random = new Random();
		for (int i = 0; i < moves; i++) {
			int rndNum = random.nextInt(18);
			switch(rndNum) {
			case 0:
				query += "U ";
				break;
			case 1:
				query += "U' ";
				break;
			case 2:
				query += "U2 ";;
				break;
			case 3:
				query += "D ";;
				break;
			case 4:
				query += "D' ";;
				break;
			case 5:
				query += "D2 ";
				break;
			case 6:
				query += "B ";
				break;
			case 7:
				query += "B' ";
				break;
			case 8:
				query += "B2 ";
				break;
			case 9:
				query += "F ";
				break;
			case 10:
				query += "F' ";
				break;
			case 11:
				query += "F2 ";
				break;
			case 12:
				query += "R ";
				break;
			case 13:
				query += "R' ";
				break;
			case 14:
				query += "R2 ";
				break;
			case 15:
				query += "L ";
				break;
			case 16: 
				query += "L' ";
				break;
			case 17:
				query += "L2 ";
				break;
			}
		}
		scramble(query);
		return query;
		
	}
	
	//CROSS BEGINS HERE-----------------------------------------------------
	
	public boolean check_cross() {
	// checks if the cross is done, returns a boolean
		boolean Felements = F.get(4) == F.get(7);
		boolean Relements = R.get(4) == R.get(7);
		boolean Belements = B.get(4) == B.get(7);
		boolean Lelements = B.get(4) == B.get(7);
		boolean whiteElements = (D.get(1) == "w") && (D.get(3) == "w") && (D.get(5) == "w") && (D.get(7) == "w");
		return Felements && Relements && Belements && Lelements && whiteElements;
	}
	public ArrayList<String> determine_cross_set_elements() {
	// determines on which sides the white elements are already set, returns
	// an ArrayList with side names
	// e.g.: F, R, B, L
		ArrayList<String> setElements = new ArrayList<String>();
		if (D.get(1) == "w") {
			setElements.add("F");
		} else {
			setElements.add(null);
		}
		if (D.get(5) == "w") {
			setElements.add("R");
		} else {
			setElements.add(null);
		}
		if (D.get(7) == "w") {
			setElements.add("B");
		} else {
			setElements.add(null);
		}
		if (D.get(3) == "w") {
			setElements.add("L");
		} else {
			setElements.add(null);
		}
		return setElements;
		
	}
	public String get_colored_cross_element(String side) {
	//returns which color is on the place of cross element of the exact side
	// like you give him "F" and he gives you "g"
		String element = null;
		switch(side) {
		case "F":
			element = F.get(7);
			break;
		case "R":
			element = R.get(7);
			break;
		case "B":
			element = B.get(7);
			break;
		case "L":
			element = L.get(7);
			break;
		}
		return element;
	}
	public ArrayList<String> determine_cross_correct_elements(ArrayList<String> setSides) {
	// this should take the return of determine_cross_set_elements() as a parameter
		ArrayList<String> colors = new ArrayList<String>();
		ArrayList<String> correctSides = new ArrayList<String>();
		for (String side : setSides) {
			if (side == null) {
				colors.add(null);
			} else {
				colors.add(get_colored_cross_element(side));
			}
		}
		int nullNum = 0;
		for (String i : colors) {
			if (i == null) {
				nullNum++;
			}
		}
		if (nullNum == 3) {
			for (int i = 0; i < setSides.size(); i++) {
				if (colors.get(i) != null) {
					correctSides.add(setSides.get(i));
				}
			}
		} 
		else if (nullNum != 4) {
			ArrayList<String> rightOrder = new ArrayList<String>();
			rightOrder.add("g"); //0
			rightOrder.add("o"); //1
			rightOrder.add("b"); //2
			rightOrder.add("r"); //3
			
			ArrayList<ArrayList<String>> setsOfSets = new ArrayList<ArrayList<String>>();
			for (int i = 0; i < 4; i++) {
				if (colors.get(i) == null) {
					continue;
				}
				
				boolean stop = true;
				while (stop) {
					if (rightOrder.get(i) != colors.get(i)) {
						String temp0 = rightOrder.get(0);
						String temp1 = rightOrder.get(1);
						String temp2 = rightOrder.get(2);
						String temp3 = rightOrder.get(3);
						
						rightOrder.set(0, temp1);
						rightOrder.set(1, temp2);
						rightOrder.set(2, temp3);
						rightOrder.set(3, temp0);
					} else {
						stop = false;
					}
				}
				
				ArrayList<String> correctSidesSets = new ArrayList<String>();
				for (int j = 0; j < 4; j++) {
					if(colors.get(j) == rightOrder.get(j)) {
						correctSidesSets.add(setSides.get(j));
					}
				}
				setsOfSets.add(correctSidesSets);
			}
			
			for (ArrayList<String> aSet : setsOfSets) {
				if (aSet.size() > correctSides.size()) {
					correctSides = aSet;
				}
			}
		}
		return correctSides;
		
	}

	public ArrayList<ArrayList<String>> cross_determine_wrong_colors(ArrayList<String> crctSds) {
		// returns a 2d arraylist with ["color", "side where it's supposed to move"]
		// and takes the return of determine_cross_correct_elements() method
			
		//the argument it takes should not be empty, otherwise it's gonna return an empty AL
			ArrayList<ArrayList<String>> wrongSet = new ArrayList<ArrayList<String>>();
			if (crctSds.size() == 0) {
				return wrongSet;
			}
			ArrayList<String> correctSides = new ArrayList<String>();
			String[] sds = {"F", "R", "B", "L"};
			
			ArrayList<String> crctSds_copy = new ArrayList<String>();
			for (String i : crctSds) {
				crctSds_copy.add(i);
			}
			
			for (int i = 0; i < 4; i++) {
				boolean outtaBounds = false;
				if ((crctSds_copy.size() - 1) < i) {
					outtaBounds = true;
				}
				
				if (outtaBounds || sds[i] != crctSds_copy.get(i)) {
					crctSds_copy.add(i, sds[i]);
					correctSides.add(null);
				} else {
					correctSides.add(crctSds_copy.get(i));
				}
			}

			int correctSidesSize = correctSides.size();
			if (correctSidesSize != 4) {
				int iterations = 4 - correctSidesSize;
				for (int i = 0; i < iterations; i++) {
					correctSides.add(null);
				}
			}
			// now correctSides takes the value of the correct sides in ["F", "R", "B", "L"]
			// order and if a side is not correct it's like ["F", null, null, "L"]
			
			ArrayList<String> wrongSides = new ArrayList<String>();
			for (int i = 0; i < 4; i++) {
				if (correctSides.get(i) == null) {
					wrongSides.add(sds[i]);
				} else {
					wrongSides.add(null);
				}
			}
			
			ArrayList<String> rightOrder = new ArrayList<String>();
			rightOrder.add("g"); //0
			rightOrder.add("o"); //1
			rightOrder.add("b"); //2
			rightOrder.add("r"); //3
			ArrayList<String> colors = new ArrayList<String>();
			for (String side : correctSides) {
				if (side == null) {
					colors.add(null);
				} else {
					colors.add(get_colored_cross_element(side));
				}
			}
			
			String firstColor = get_colored_cross_element(crctSds.get(0));
			boolean stop = true;
			while (stop) {
				if (rightOrder.get(0) != firstColor) {
					String temp0 = rightOrder.get(0);
					String temp1 = rightOrder.get(1);
					String temp2 = rightOrder.get(2);
					String temp3 = rightOrder.get(3);
					
					rightOrder.set(0, temp1);
					rightOrder.set(1, temp2);
					rightOrder.set(2, temp3);
					rightOrder.set(3, temp0);
				} else {
					stop = false;
				}
			}
			
			int stepsBack = 0;
			for (int i = 0; i < 4; i++) {
				if (colors.get(i) == null) {
					stepsBack++;
				} else {
					break;
				}
			}
			for (int i = 0; i < stepsBack; i++) {
				String temp0 = rightOrder.get(0);
				String temp1 = rightOrder.get(1);
				String temp2 = rightOrder.get(2);
				String temp3 = rightOrder.get(3);
				
				rightOrder.set(0, temp3);
				rightOrder.set(1, temp0);
				rightOrder.set(2, temp1);
				rightOrder.set(3, temp2);
			}
			
			for (int i = 0; i < 4; i++) {
				if (wrongSides.get(i) == null) {
					continue;
				}
				ArrayList<String> set = new ArrayList<String>();
				set.add(rightOrder.get(i));
				set.add(wrongSides.get(i));
				wrongSet.add(set);
			}
			return wrongSet;
	}
	public ArrayList<ArrayList<String>> noInput_cross_determine_wrong_colors() {
		return cross_determine_wrong_colors(determine_cross_correct_elements(determine_cross_set_elements()));
	}
	public void cross_determine_white_colored_sides(ArrayList<String> side, String[] sidesNearby, int[] indexes) {
	// this is needed for the cross_rename_white_edges() method
		int[] edgeIndexes = {1, 3, 5, 7};
		for (int i = 0; i < 4; i++) {
			if(side.get(edgeIndexes[i]) == "w") {
				String secondElement = null;
				switch (sidesNearby[i]) {
				case "F":
					secondElement = F.get(indexes[i]);
					break;
				case "R":
					secondElement = R.get(indexes[i]);
					break;
				case "B":
					secondElement = B.get(indexes[i]);
					break;
				case "L":
					secondElement = L.get(indexes[i]);
					break;
				case "U":
					secondElement = U.get(indexes[i]);
					break;
				case "D":
					secondElement = D.get(indexes[i]);
					break;
				}
				side.set(edgeIndexes[i], "w" + secondElement);
			}
			
			/*ArrayList<ArrayList<String>> wrongColors = new ArrayList<ArrayList<String>>();
			wrongColors = cross_determine_wrong_colors(determine_cross_correct_elements(determine_cross_set_elements()));
			for (ArrayList<String> color : wrongColors) {
				if (!(color.get(0) == secondElement)) {
					secondElement = "";
				}
			}    I think I don't need this but just in case Imma leave it here*/ 
		}
	}
	public void cross_rename_white_edges() {
	// converts the "w" elements into "w'color'" elements depending on the color
	// which is attached to it
	// e,g.: "wr" is a white-red piece
	// creates the sides backup and stores the changes there
		
		// {1, 3, 5, 7} this is the order of elements on the exact side
		sideBackup();
		String[] FSides = {"U", "L", "R", "D"};
		int[] FIndexes = {7, 5, 3, 1};
		cross_determine_white_colored_sides(F_backup, FSides, FIndexes);
		
		String[] RSides = {"U", "F", "B", "D"};
		int[] RIndexes = {5, 5, 3, 5};
		cross_determine_white_colored_sides(R_backup, RSides, RIndexes);
		
		String[] LSides = {"U", "B", "F", "D"};
		int[] LIndexes = {3, 5, 3, 3};
		cross_determine_white_colored_sides(L_backup, LSides, LIndexes);
		
		String[] BSides = {"U", "R", "L", "D"};
		int[] BIndexes = {1, 5, 3, 7};
		cross_determine_white_colored_sides(B_backup, BSides, BIndexes);
		
		String[] USides = {"B", "L", "R", "F"};
		int[] UIndexes = {1, 1, 1, 1};
		cross_determine_white_colored_sides(U_backup, USides, UIndexes);
		
		String[] DSides = {"F", "L", "R", "B"};
		int[] DIndexes = {7, 7, 7, 7};
		cross_determine_white_colored_sides(D_backup, DSides, DIndexes);
	}
	
	public void cross_right_three_mover() {
	// solve bad pieces to the right
		R_();
		F();
		R();
	}
	public void cross_left_three_mover() {
	// solve bad pieces to the left
		L();
		F_();
		L_();
	}
	class Cross_piece {
		String side;
		int position;
		String secondColor;
		String potentialSide;
		String potentialSetMove;
		Cross_piece (String side, int position, String secondColor) {
			this.side = side;
			this.position = position;
			this.secondColor = secondColor;
			this.potentialSide = "";
			this.potentialSetMove = "";
		}
	}
	public ArrayList<Cross_piece> cross_determine_good_pieces() {
	// make sure you do cross_rename_white_edges() before using this method
		
		ArrayList<Cross_piece> goodPieces = new ArrayList<Cross_piece>();
		ArrayList<ArrayList<String>> potentialGoodSds = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> potentialGoodSds_backup = new ArrayList<ArrayList<String>>();
		potentialGoodSds.add(F);
		potentialGoodSds.add(R);
		potentialGoodSds.add(B);
		potentialGoodSds.add(L);
		potentialGoodSds_backup.add(F_backup);
		potentialGoodSds_backup.add(R_backup);
		potentialGoodSds_backup.add(B_backup);
		potentialGoodSds_backup.add(L_backup);
		int[] edgeInd = {3, 5};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				if (potentialGoodSds.get(i).get(edgeInd[j]) == "w") {
					String side = null;
					switch (i) {
					case 0:
						side = "F";
						break;
					case 1:
						side = "R";
						break;
					case 2:
						side = "B";
						break;
					case 3:
						side = "L";
						break;
					}
					String secondColor = potentialGoodSds_backup.get(i).get(edgeInd[j]);
					secondColor = secondColor.substring(secondColor.length() - 1);
					Cross_piece piece = new Cross_piece(side, edgeInd[j], secondColor);
					goodPieces.add(piece);
				}
			}
		}

		/*for (Cross_piece i : goodPieces) {
			System.out.println("Good: \n");
			System.out.print(i.side + ", " + i.position + ", " + i.secondColor + "\n\n");
		}*/
		return goodPieces;
	}
	public ArrayList<Cross_piece> cross_determine_neutral_pieces() {
	// make sure you do cross_rename_white_edges() before using this method
		
		ArrayList<Cross_piece> neutralPieces = new ArrayList<Cross_piece>();
		int[] edgeInd = {1, 3, 5, 7};
		for (int i = 0; i < 4; i++) {
			if (U.get(edgeInd[i]) == "w") {
				String secondColor = U_backup.get(edgeInd[i]);
				secondColor = secondColor.substring(secondColor.length() - 1);
				Cross_piece piece = new Cross_piece("U", edgeInd[i], secondColor);
				neutralPieces.add(piece);
			}
		}
		/*for (Cross_piece i : neutralPieces) {
			System.out.println("Neutral: \n");
			System.out.print(i.side + ", " + i.position + ", " + i.secondColor + "\n\n");
		}*/
		return neutralPieces;
	}
	public ArrayList<Cross_piece> cross_determine_bad_pieces() {
	// make sure you do cross_rename_white_edges() before using this method
		
		ArrayList<Cross_piece> badPieces = new ArrayList<Cross_piece>();
		ArrayList<ArrayList<String>> potentialBadSds = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> potentialBadSds_backup = new ArrayList<ArrayList<String>>();
		potentialBadSds.add(F);
		potentialBadSds.add(R);
		potentialBadSds.add(B);
		potentialBadSds.add(L);
		potentialBadSds_backup.add(F_backup);
		potentialBadSds_backup.add(R_backup);
		potentialBadSds_backup.add(B_backup);
		potentialBadSds_backup.add(L_backup);
		int edgeInd = 1;
		for (int i = 0; i < 4; i++) {
			if (potentialBadSds.get(i).get(edgeInd) == "w") {
				String side = null;
				switch (i) {
				case 0:
					side = "F";
					break;
				case 1:
					side = "R";
					break;
				case 2:
					side = "B";
					break;
				case 3:
					side = "L";
					break;
				}
				String secondColor = potentialBadSds_backup.get(i).get(edgeInd);
				secondColor = secondColor.substring(secondColor.length() - 1);
				Cross_piece piece = new Cross_piece(side, edgeInd, secondColor);
				badPieces.add(piece);
			}
		}
		/*for (Cross_piece i : badPieces) {
			System.out.println("Bad: \n");
			System.out.print(i.side + ", " + i.position + ", " + i.secondColor + "\n\n");
		}*/
		return badPieces;
		
	}
	public ArrayList<Cross_piece> cross_determine_very_bad_pieces() {
		// make sure you do cross_rename_white_edges() before using this method
			
			ArrayList<Cross_piece> veryBadPieces = new ArrayList<Cross_piece>();
			ArrayList<ArrayList<String>> potentialVeryBadSds = new ArrayList<ArrayList<String>>();
			ArrayList<ArrayList<String>> potentialVeryBadSds_backup = new ArrayList<ArrayList<String>>();
			potentialVeryBadSds.add(F);
			potentialVeryBadSds.add(R);
			potentialVeryBadSds.add(B);
			potentialVeryBadSds.add(L);
			potentialVeryBadSds_backup.add(F_backup);
			potentialVeryBadSds_backup.add(R_backup);
			potentialVeryBadSds_backup.add(B_backup);
			potentialVeryBadSds_backup.add(L_backup);
			int edgeInd = 7;
			for (int i = 0; i < 4; i++) {
				if (potentialVeryBadSds.get(i).get(edgeInd) == "w") {
					String side = null;
					switch (i) {
					case 0:
						side = "F";
						break;
					case 1:
						side = "R";
						break;
					case 2:
						side = "B";
						break;
					case 3:
						side = "L";
						break;
					}
					String secondColor = potentialVeryBadSds_backup.get(i).get(edgeInd);
					secondColor = secondColor.substring(secondColor.length() - 1);
					Cross_piece piece = new Cross_piece(side, edgeInd, secondColor);
					veryBadPieces.add(piece);
				}
			}
			/*for (Cross_piece i : veryBadPieces) {
				System.out.println("Very bad: \n");
				System.out.print(i.side + ", " + i.position + ", " + i.secondColor + "\n\n");
			}*/
			return veryBadPieces;
		}
	public ArrayList<Cross_piece> cross_determine_misplaced_pieces() {
	// make sure you do cross_rename_white_edges() before using this method
		
		ArrayList<Cross_piece> misplacedPieces = new ArrayList<Cross_piece>();
		ArrayList<String> setElements = determine_cross_set_elements();
		ArrayList<Integer> remove = new ArrayList<Integer>();
		for (int i = 0; i < setElements.size(); i++) {
			if (setElements.get(i) == null) {
				remove.add(i);
			}
		}
		Collections.reverse(remove);
		for (int i : remove) {
			setElements.remove(i);
		}
		ArrayList<String> correctElements = determine_cross_correct_elements(determine_cross_set_elements());
		remove.clear();
		for (int i = 0; i < setElements.size(); i++) {
			for (int j = 0; j < correctElements.size(); j++) {
				if (setElements.get(i) == correctElements.get(j)) {
					remove.add(i);
				}
			}
		}
		
		Collections.reverse(remove);
		for (int i : remove) {
			setElements.remove(i);
		}
		
		
		for (String i : setElements) {
			if (i == null) {
				continue;
			}
			int edgeInd = 0;
			switch (i) {
			case "F":
				edgeInd = 1;
				break;
			case "R":
				edgeInd = 5;
				break;
			case "B":
				edgeInd = 7;
				break;
			case "L":
				edgeInd = 3;
				break;
			}
			String secondColor = D_backup.get(edgeInd);
			secondColor = secondColor.substring(secondColor.length() - 1);
			Cross_piece piece = new Cross_piece("D", edgeInd, secondColor);
			misplacedPieces.add(piece);
		}
		/*for (Cross_piece i : misplacedPieces) {
			System.out.println("Misplaced: \n");
			System.out.print(i.side + ", " + i.position + ", " + i.secondColor + "\n\n");
		}*/
		return misplacedPieces;
	}
	public void cross_determine_potential_good_sides(ArrayList<Cross_piece> goodPieces) {
		for (Cross_piece good : goodPieces) {
			if (good.position == 3 && good.side.contentEquals("F")) {
				good.potentialSide = "L";
				good.potentialSetMove = "L";
			}
			if (good.position == 5 && good.side.contentEquals("F")) {
				good.potentialSide = "R";
				good.potentialSetMove = "R'";
			}
			if (good.position == 3 && good.side.contentEquals("R")) {
				good.potentialSide = "F";
				good.potentialSetMove = "F";
			}
			if (good.position == 5 && good.side.contentEquals("R")) {
				good.potentialSide = "B";
				good.potentialSetMove = "B'";
			}
			if (good.position == 3 && good.side.contentEquals("B")) {
				good.potentialSide = "R";
				good.potentialSetMove = "R";
			}
			if (good.position == 5 && good.side.contentEquals("B")) {
				good.potentialSide = "L";
				good.potentialSetMove = "L'";
			}
			if (good.position == 3 && good.side.contentEquals("L")) {
				good.potentialSide = "B";
				good.potentialSetMove = "B";
			}
			if (good.position == 5 && good.side.contentEquals("L")) {
				good.potentialSide = "F";
				good.potentialSetMove = "F'";
			}
		}
	}
	public void cross_determine_potential_neutral_sides(ArrayList<Cross_piece> neutralPieces) {
		for (Cross_piece neutral : neutralPieces) {
			if (neutral.position == 1) {
				neutral.potentialSide = "B";
				neutral.potentialSetMove = "B2";
			}
			if (neutral.position == 3) {
				neutral.potentialSide = "L";
				neutral.potentialSetMove = "L2";
			}
			if (neutral.position == 5) {
				neutral.potentialSide = "R";
				neutral.potentialSetMove = "R2";
			}
			if (neutral.position == 7) {
				neutral.potentialSide = "F";
				neutral.potentialSetMove = "F2";
			}
		}
	}
	public void CROSS() {
		ArrayList<ArrayList<String>> wrongColors = noInput_cross_determine_wrong_colors();
		if (!check_cross()) {
			cross_rename_white_edges();
			ArrayList<Cross_piece> goodPieces = cross_determine_good_pieces();
			ArrayList<Cross_piece> neutralPieces = cross_determine_neutral_pieces();
			ArrayList<Cross_piece> badPieces = cross_determine_bad_pieces();
			ArrayList<Cross_piece> veryBadPieces = cross_determine_very_bad_pieces();
			ArrayList<Cross_piece> misplacedPieces = cross_determine_misplaced_pieces();
			
			//looking for bad-very bad pair
			String[][] pairs = { {"g", "b"}, {"r", "o"} };
			ArrayList<Cross_piece> bad_veryBad = new ArrayList<Cross_piece>();
			outerloop:
			for (Cross_piece piece : badPieces) {
				for (String[] pair : pairs) {
					for (String pairColor : pair) {		
						if (pairColor.contentEquals(piece.secondColor)) {
							for (Cross_piece piece2 : veryBadPieces) {
								for (String i : pair) {
									if (piece2.secondColor.contentEquals(i)) {
										bad_veryBad.add(piece);
										bad_veryBad.add(piece2);
										break outerloop;
									}
								}
							}
						}
					}
				}
			}
			System.out.println("bd vr bd: " + bad_veryBad);
		} else {
			CROSS = true;
		}
	}
}
