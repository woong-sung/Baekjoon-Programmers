class Solution {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		int index_L = 10;
		int index_R = 12;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0)
				numbers[i] = 11;
			if (numbers[i] ==1||numbers[i] ==4||numbers[i] ==7) {
				answer += "L";
				index_L = numbers[i];
			} else if (numbers[i] ==3||numbers[i] ==6||numbers[i] ==9) {
				answer += "R";
				index_R = numbers[i];
			} else {
				int disL = getDis(index_L, numbers[i]);
				int disR = getDis(index_R, numbers[i]);
				if (disL > disR) {
					answer += "R";
					index_R = numbers[i];
				} else if (disL < disR) {
					answer += "L";
					index_L = numbers[i];
				} else {
					if (hand.equals("right")) {
						answer += "R";
						index_R = numbers[i];
					}
					if (hand.equals("left")) {
						answer += "L";
						index_L = numbers[i];
					}
				}
			}
		}

		return answer;
	}

	static int getDis(int a, int b) {
		int dis = 0;
		if (Math.abs(a - b) == 1) {
			dis = 1;
			if (a == 3 && b == 4 || a == 4 && b == 3 || a == 6 && b == 7 || a == 7 && b == 6) {
				dis += 2;
			}
		} else if (Math.abs(a - b) == 2) {
			dis += 2;
		} else if (Math.abs(a - b) == 3) {
			dis += 1;
		} else if (Math.abs(a - b) == 4) {
			dis += 2;
			if (a == 3 && b == 7 || a == 7 && b == 3) {
				dis += 2;
			}
		} else if (Math.abs(a - b) == 5) {
			dis += 3;
		} else if (Math.abs(a - b) == 6) {
			dis += 2;
		} else if (Math.abs(a - b) == 7) {
			dis += 3;
		} else if (Math.abs(a - b) == 8) {
			dis += 4;
		} else if (Math.abs(a - b) == 9) {
			dis += 3;
		} else if (Math.abs(a - b) == 10) {
			dis += 4;
		}
		return dis;
	}
}